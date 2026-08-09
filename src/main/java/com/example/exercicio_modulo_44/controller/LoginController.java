package com.example.exercicio_modulo_44.controller;

import com.example.exercicio_modulo_44.request.LoginRequest;
import com.example.exercicio_modulo_44.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private final UsuarioService usuarioService;
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request, HttpSession session ) {
        boolean usuarioValido = usuarioService.autenticar(request.getEmail(), request.getSenha());
        if (!usuarioValido) {
            logger.error("Usuário e/ou senha inválidos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário e/ou senha inválidos");
        }

        session.setAttribute("usuarioLogado", request.getEmail());
        session.setMaxInactiveInterval(60);

        logger.info("Login realizado com sucesso. Acesso foi liberado por 1 minuto");
        return ResponseEntity.ok("Login realizado com sucesso. Acesso está liberado por 1 minuto");
    }
}
