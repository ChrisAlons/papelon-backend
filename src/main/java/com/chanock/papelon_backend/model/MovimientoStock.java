package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento_stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientoStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    @NotNull
    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TipoMovimiento tipo;

    @Column(name = "referencia_id")
    private Long referenciaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "referencia_tipo", length = 10)
    private ReferenciaTipo referenciaTipo;

    @PrePersist
    protected void prePersist() {
        this.fecha = LocalDateTime.now();
    }
}
