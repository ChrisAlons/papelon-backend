package com.chanock.papelon_backend.config;

import com.chanock.papelon_backend.model.Usuario;
import com.chanock.papelon_backend.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DataInitializer {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initDefaultUser() {
        return args -> {
            final String defaultUser = "admin";
            final String defaultPass = "admin123";
            if (usuarioRepository.findByUsername(defaultUser).isEmpty()) {
                Usuario admin = Usuario.builder()
                        .username(defaultUser)
                        .password(passwordEncoder.encode(defaultPass))
                        .rol("ADMIN")
                        .build();
                usuarioRepository.save(admin);
                log.info("Default ADMIN user created: username='{}', password='{}'", defaultUser, defaultPass);
            }
        };
    }
}
