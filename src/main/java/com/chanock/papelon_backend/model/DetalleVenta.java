// src/main/java/com/chanock/papelon_backend/model/DetalleVenta.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "detalle_venta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** Venta a la que pertenece este detalle */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta;

    /** Producto vendido */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    /** Cantidad vendida */
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    /** Precio unitario de venta */
    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;

    /** Timestamp de creación automático */
    @CreationTimestamp
    @Column(name = "created_at", insertable=false, updatable = false)
    private LocalDateTime createdAt;
}
