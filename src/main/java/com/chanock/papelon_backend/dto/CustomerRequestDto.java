package com.chanock.papelon_backend.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequestDto {
    @Size(max = 100)
    private String name;
    @Size(max = 100)
    private String email;
    @Size(max = 15)
    private String phone;
    private String address;
}
