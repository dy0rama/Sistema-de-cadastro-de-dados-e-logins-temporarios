package com.example.exercicio_modulo_44.repository;

import com.example.exercicio_modulo_44.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepo {
    private final JdbcTemplate jdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(UsuarioRepo.class);

    public UsuarioRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha) values (?, ?, ?)";

        logger.info("Cadastro salvo com sucesso!");
        jdbcTemplate.update(sql, usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
