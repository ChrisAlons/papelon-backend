// src/main/java/com/chanock/papelon_backend/model/DetalleVenta.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "detalle_venta")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DetalleVenta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne @JoinColumn(name="venta_id", nullable=false)
    private Venta venta;

    @ManyToOne @JoinColumn(name="producto_id", nullable=false)
    private Producto producto;

    @Column(name="cantidad", nullable=false)
    private Integer cantidad;

    @Column(name="precio_unitario", nullable=false)
    private BigDecimal precioUnitario;

    @Column(name="created_at")
    private LocalDateTime createdAt;
}
