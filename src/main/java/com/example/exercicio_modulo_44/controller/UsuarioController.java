package com.example.exercicio_modulo_44.controller;

import com.example.exercicio_modulo_44.model.Usuario;
import com.example.exercicio_modulo_44.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Usuario usuario) {
        logger.info("Cadastro realizado com sucesso!");
        usuarioService.cadastrar(usuario);

        return ResponseEntity.ok().body("Cadastro realizado com sucesso");
    }
}
