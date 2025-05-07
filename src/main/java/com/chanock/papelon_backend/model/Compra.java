// src/main/java/com/chanock/papelon_backend/model/Compra.java
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
@Table(name = "compra")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="proveedor_id", nullable=false)
    private Proveedor proveedor;

    /** La BD asigna el valor por defecto DEFAULT CURRENT_TIMESTAMP */
    @Column(name="fecha", nullable=false, insertable=false, updatable=false)
    private LocalDateTime fecha;

    @Column(name="total", nullable=false)
    private BigDecimal total;

    /** La BD asigna created_at por DEFAULT CURRENT_TIMESTAMP */
    @CreationTimestamp
    @Column(name="created_at", nullable=false, updatable=false, insertable=false)
    private LocalDateTime createdAt;

    /** Hibernate actualiza updated_at automáticamente */
    @UpdateTimestamp
    @Column(name="updated_at", insertable=false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy="compra", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<DetalleCompra> detalles = new ArrayList<>();
}
