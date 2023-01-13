package br.com.ada.adaflix.service;

import br.com.ada.adaflix.dto.IngressoRequestDTO;
import br.com.ada.adaflix.dto.IngressoResponseDTO;
import br.com.ada.adaflix.model.Evento;
import br.com.ada.adaflix.model.Ingresso;
import br.com.ada.adaflix.model.Usuario;
import br.com.ada.adaflix.repository.IngressoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IngressoService {

    private final IngressoRepository ingressoRepository;
    private final EventoService eventoService;
    private final UsuarioService usuarioService;


    public IngressoService(IngressoRepository ingressoRepository, EventoService eventoService, UsuarioService usuarioService) {
        this.ingressoRepository = ingressoRepository;
        this.eventoService = eventoService;
        this.usuarioService = usuarioService;
    }

    public Ingresso comprar(IngressoRequestDTO ingressoDTO) {
        LocalDateTime hoje = LocalDateTime.now();
        // Buscar o evento por ID
        Long eventoId = ingressoDTO.getEventoId();
        Evento evento = eventoService.buscarPorId(eventoId);

        Long usuarioId = ingressoDTO.getUsuarioId();
        Usuario usuario = usuarioService.buscarPorId(usuarioId);

        LocalDateTime inicioVendas = evento.getInicioVendas();
        LocalDateTime fimVendas = evento.getFimVendas();
        if (hoje.isBefore(inicioVendas) || hoje.isAfter(fimVendas)) {
            throw new IllegalArgumentException("Data de compra não permitida");
        }
        /*Long totalIngressos = ingressoRepository.countIngressoByEvento(eventoId);
        if (totalIngressos + ingresso.getQuantidade() > evento.getCapacidade()) {
            throw new IllegalArgumentException("Data de compra não permitida");
        }*/
        Ingresso ingressoSalvar = new Ingresso();
        ingressoSalvar.setEvento(evento);
        ingressoSalvar.setQuantidade(ingressoDTO.getQuantidade());
        ingressoSalvar.setFormaPagamento(ingressoDTO.getFormaPagamento());
        ingressoSalvar.setUsuario(usuario);

        Ingresso ingressoSalvo = ingressoRepository.save(ingressoSalvar);

        return ingressoSalvo;
    }
}
