// src/main/java/com/chanock/papelon_backend/model/MovimientoStock.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "movimiento_stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientoStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** FK al producto */
    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "fecha", nullable = false, insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime fecha;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "tipo", length = 10, nullable = false)
    private String tipo;

    @Column(name = "referencia_id")
    private Integer referenciaId;

    @Column(name = "referencia_tipo", length = 10)
    private String referenciaTipo;
}
