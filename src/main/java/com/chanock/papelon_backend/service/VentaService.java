// src/main/java/com/chanock/papelon_backend/service/VentaService.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.dto.VentaRequestDto;
import com.chanock.papelon_backend.exception.ResourceNotFoundException;
import com.chanock.papelon_backend.model.*;
import com.chanock.papelon_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepo;
    private final UsuarioRepository usuarioRepo;
    private final ClienteRepository clienteRepo;
    private final ProductoRepository productoRepo;

    /** Listar todas las ventas ordenadas por ID ascendente */
    public List<Venta> findAll() {
        return ventaRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    /** Buscar una venta por su ID */
    public Venta findById(Integer id) {
        return ventaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venta", id));
    }

    /** Crear una venta con sus detalles y disparar triggers para stock */
    @Transactional
    public Venta create(VentaRequestDto dto) {
        Usuario usuario = usuarioRepo.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", dto.getUsuarioId()));

        Cliente cliente = null;
        if (dto.getClienteId() != null) {
            cliente = clienteRepo.findById(dto.getClienteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente", dto.getClienteId()));
        }

        Venta venta = Venta.builder()
                .usuario(usuario)
                .cliente(cliente)
                .build();

        List<DetalleVenta> detalles = dto.getDetalles().stream().map(d -> {
            Producto prod = productoRepo.findById(d.getProductoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Producto", d.getProductoId()));
            return DetalleVenta.builder()
                    .venta(venta)
                    .producto(prod)
                    .cantidad(d.getCantidad())
                    .precioUnitario(d.getPrecioUnitario())
                    .build();
        }).collect(Collectors.toList());

        venta.setDetalles(detalles);

        BigDecimal total = detalles.stream()
                .map(dv -> dv.getPrecioUnitario().multiply(BigDecimal.valueOf(dv.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        venta.setTotal(total);

        return ventaRepo.save(venta);
    }
}
