// src/main/java/com/chanock/papelon_backend/model/Proveedor.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "proveedor")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Proveedor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre", length=100, nullable=false)
    private String nombre;

    @Column(name="telefono", length=20)
    private String telefono;

    @Column(name="direccion")
    private String direccion;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
