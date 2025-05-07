// src/main/java/com/chanock/papelon_backend/model/Cliente.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "cliente")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre", length=100, nullable=false)
    private String nombre;

    @Column(name="email", length=100)
    private String email;

    @Column(name="telefono", length=15)
    private String telefono;

    @Column(name="direccion")
    private String direccion;

    @Column(name="created_at")
    private OffsetDateTime createdAt;

    @Column(name="updated_at")
    private OffsetDateTime updatedAt;
}
