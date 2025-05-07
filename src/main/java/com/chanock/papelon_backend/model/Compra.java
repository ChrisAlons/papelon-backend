// src/main/java/com/chanock/papelon_backend/model/Compra.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "compra")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Compra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

    @ManyToOne @JoinColumn(name="proveedor_id", nullable=false)
    private Proveedor proveedor;

    @Column(name="fecha", nullable=false)
    private LocalDateTime fecha;

    @Column(name="total", nullable=false)
    private BigDecimal total;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy="compra", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<DetalleCompra> detalles = new ArrayList<>();
}
