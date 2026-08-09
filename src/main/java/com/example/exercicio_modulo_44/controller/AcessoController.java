package com.example.exercicio_modulo_44.controller;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acesso")
public class AcessoController {
    private final Logger logger = LoggerFactory.getLogger(AcessoController.class);

    @GetMapping
    public ResponseEntity<String> acessar(HttpSession session) {
        Object usuarioLogado = session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            logger.error("Acesso negado. Faça o login primeiro");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado. Faça o login primeiro");
        }

        logger.info("Acesso permitido");
        return ResponseEntity.status(HttpStatus.OK).body("Acesso permitido. Bem-vindo " + usuarioLogado);
    }
}
