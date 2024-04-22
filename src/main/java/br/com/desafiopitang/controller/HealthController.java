package br.com.desafiopitang.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("/health")
public class HealthController {

	@GetMapping
    @Produces(MediaType.TEXT_PLAIN)
    public String health() {
        return "Verificação de serviço OK.";
    }
}
