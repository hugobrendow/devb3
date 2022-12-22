package br.com.ada.adaflix.repository;

import br.com.ada.adaflix.model.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
}
