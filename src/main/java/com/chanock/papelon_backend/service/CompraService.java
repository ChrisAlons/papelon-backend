// src/main/java/com/chanock/papelon_backend/service/CompraService.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.dto.CompraRequestDto;
import com.chanock.papelon_backend.exception.ResourceNotFoundException;
import com.chanock.papelon_backend.model.Compra;
import com.chanock.papelon_backend.model.DetalleCompra;
import com.chanock.papelon_backend.model.Producto;
import com.chanock.papelon_backend.model.Usuario;
import com.chanock.papelon_backend.model.Proveedor;
import com.chanock.papelon_backend.repository.CompraRepository;
import com.chanock.papelon_backend.repository.ProductoRepository;
import com.chanock.papelon_backend.repository.UsuarioRepository;
import com.chanock.papelon_backend.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository repo;
    private final UsuarioRepository usuarioRepo;
    private final ProveedorRepository proveedorRepo;
    private final ProductoRepository productoRepo;

    /** Devuelve todas las compras ordenadas por ID asc */
    public List<Compra> findAll() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Compra findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compra", id));
    }

    @Transactional
    public Compra create(CompraRequestDto dto) {
        Usuario u = usuarioRepo.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", dto.getUsuarioId()));
        Proveedor p = proveedorRepo.findById(dto.getProveedorId())
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", dto.getProveedorId()));

        Compra c = new Compra();
        c.setUsuario(u);
        c.setProveedor(p);

        List<DetalleCompra> detalles = dto.getDetalles().stream().map(d -> {
            Producto prod = productoRepo.findById(d.getProductoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Producto", d.getProductoId()));
            DetalleCompra dc = new DetalleCompra();
            dc.setCompra(c);
            dc.setProducto(prod);
            dc.setCantidad(d.getCantidad());
            dc.setPrecioUnitario(d.getPrecioUnitario());
            return dc;
        }).collect(Collectors.toList());
        c.setDetalles(detalles);

        BigDecimal total = detalles.stream()
                .map(dc -> dc.getPrecioUnitario().multiply(BigDecimal.valueOf(dc.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        c.setTotal(total);

        return repo.save(c);
    }
}
