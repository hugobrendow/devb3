
package br.com.ada.adaflix.repository;

import br.com.ada.adaflix.model.Ingresso;
import br.com.ada.adaflix.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IngressoRepository extends CrudRepository<Ingresso, Long> {

    /*@Query("SELECT sum(i.quantidade) FROM Ingresso i WHERE i.evento.id = :id")
    Long countIngressoByEvento(Long id);*/
}
