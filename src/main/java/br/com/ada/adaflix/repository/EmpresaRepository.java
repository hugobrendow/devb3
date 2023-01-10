package br.com.ada.adaflix.repository;

import br.com.ada.adaflix.model.Empresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

    Empresa findByCnpj(String cnpj);

    List<Empresa> findByNomeAndCnpj(String nome, String cnpj);

}
