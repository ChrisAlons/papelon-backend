package com.chanock.papelon_backend.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Prueba", description = "Endpoints de comprobación")
public class HelloController {

    @GetMapping("/api/hello")
    @Operation(summary = "Prueba de funcionamiento básico")
    public String hello() {
        return "¡Hola, Swagger + Maven funciona!";
    }
}
