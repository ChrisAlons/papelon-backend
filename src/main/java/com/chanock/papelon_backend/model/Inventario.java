// src/main/java/com/chanock/papelon_backend/model/Inventario.java
package com.chanock.papelon_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** FK al producto */
    @Column(name = "producto_id", nullable = false, unique = true)
    private Integer productoId;

    @Column(name = "stock_actual", nullable = false)
    private Integer stockActual;

    @Column(name = "updated_at", insertable = false, updatable = false)
    @Generated(GenerationTime.ALWAYS)
    private LocalDateTime updatedAt;
}
