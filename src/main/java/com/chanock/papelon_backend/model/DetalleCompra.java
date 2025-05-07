// src/main/java/com/chanock/papelon_backend/model/DetalleCompra.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "detalle_compra")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DetalleCompra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne @JoinColumn(name="compra_id", nullable=false)
    private Compra compra;

    @ManyToOne @JoinColumn(name="producto_id", nullable=false)
    private Producto producto;

    @Column(name="cantidad", nullable=false)
    private Integer cantidad;

    @Column(name="precio_unitario", nullable=false)
    private BigDecimal precioUnitario;

    @Column(name="created_at")
    private LocalDateTime createdAt;
}
