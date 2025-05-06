// src/main/java/com/chanock/papelon_backend/mapper/CustomerMapper.java
package com.chanock.papelon_backend.mapper;

import com.chanock.papelon_backend.dto.*;
import com.chanock.papelon_backend.model.Customers;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerResponseDto toDto(Customers c) {
        return CustomerResponseDto.builder()
                .id(c.getId())
                .name(c.getName())
                .email(c.getEmail())
                .phone(c.getPhone())
                .address(c.getAddress())
                .build();
    }

    public Customers toEntity(CustomerRequestDto dto) {
        return Customers.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .build();
    }
}
