package br.com.desafiopitang.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("/health")
public class HealthResource {

	@GetMapping
    @Produces(MediaType.TEXT_PLAIN)
    public String health() {
        return "Verificação de serviço OK.";
    }
}
