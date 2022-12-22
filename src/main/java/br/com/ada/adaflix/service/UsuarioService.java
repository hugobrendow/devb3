package br.com.ada.adaflix.service;

import br.com.ada.adaflix.model.Usuario;
import br.com.ada.adaflix.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        // Implementa regras de validações, etc...
        return usuarioRepository.save(usuario);
    }
}
