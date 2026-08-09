package com.example.exercicio_modulo_44.service;

import com.example.exercicio_modulo_44.model.Usuario;
import com.example.exercicio_modulo_44.repository.UsuarioRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepo usuarioRepo;

    private final JdbcTemplate jdbcTemplate;

    public UsuarioService(UsuarioRepo usuarioRepo, JdbcTemplate jdbcTemplate) {
        this.usuarioRepo = usuarioRepo;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void cadastrar(Usuario usuario) {
        usuarioRepo.salvar(usuario);
    }

    public boolean autenticar(String email, String senha) {
        String sql = """
                SELECT COUNT(*) 
                FROM usuarios 
                WHERE email = ?  
                AND senha = ?
                """;
        Integer quantidade = jdbcTemplate.queryForObject(sql, Integer.class, email, senha);

        return quantidade != null && quantidade > 0;
    }
}
