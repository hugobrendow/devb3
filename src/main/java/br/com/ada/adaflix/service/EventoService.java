package br.com.ada.adaflix.service;

import br.com.ada.adaflix.model.Evento;
import br.com.ada.adaflix.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento salvar(Evento evento) {
        // Realizar validações, etc...
        return eventoRepository.save(evento);
    }

    public List<Evento> listar() {
        return (List<Evento>) eventoRepository.findAll();
    }

    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}
