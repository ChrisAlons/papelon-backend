// src/main/java/com/chanock/papelon_backend/model/Producto.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Producto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre", length=100, nullable=false)
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio_compra", nullable=false)
    private BigDecimal precioCompra;

    @Column(name="precio_venta", nullable=false)
    private BigDecimal precioVenta;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
