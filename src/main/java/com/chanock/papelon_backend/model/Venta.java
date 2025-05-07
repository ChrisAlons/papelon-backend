// src/main/java/com/chanock/papelon_backend/model/Venta.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "venta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** Usuario que registra la venta */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    /** Cliente (opcional) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    /** Fecha de la venta, asignada por BD */
    @Column(name = "fecha", nullable = false, updatable = false,insertable=false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;

    /** Total calculado de la venta */
    @Column(name = "total", nullable = false)
    private BigDecimal total;

    /** Timestamp de creación automático */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, insertable=false)
    private LocalDateTime createdAt;

    /** Timestamp de última modificación automático */
    @UpdateTimestamp
    @Column(name = "updated_at", insertable=false)
    private LocalDateTime updatedAt;

    /** Detalles de la venta */
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalles = new ArrayList<>();
}
