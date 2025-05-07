// src/main/java/com/chanock/papelon_backend/model/Usuario.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "usuario")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="username", length=50, nullable=false, unique=true)
    private String username;

    @Column(name="password", length=100, nullable=false)
    private String password;

    @Column(name="rol", length=20, nullable=false)
    private String rol;

    /** Fecha de creación, asignada automáticamente */
    @CreationTimestamp
    @Column(name="created_at", nullable=false, updatable=false)
    private LocalDateTime createdAt;

    /** Fecha de última modificación, actualizada automáticamente */
    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
