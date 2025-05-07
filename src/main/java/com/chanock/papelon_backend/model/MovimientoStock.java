// src/main/java/com/chanock/papelon_backend/model/MovimientoStock.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento_stock")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MovimientoStock {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="producto_id", nullable=false)
    private Producto producto;

    @Column(name="fecha", nullable=false)
    private LocalDateTime fecha;

    @Column(name="cantidad", nullable=false)
    private Integer cantidad;

    @Column(name="tipo", length=10, nullable=false)
    private String tipo;

    @Column(name="referencia_id")
    private Integer referenciaId;

    @Column(name="referencia_tipo", length=10)
    private String referenciaTipo;
}
