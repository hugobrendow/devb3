package br.com.ada.adaflix.repository;

import br.com.ada.adaflix.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
