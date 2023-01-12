package br.com.ada.adaflix.dto;

import br.com.ada.adaflix.model.Evento;
import br.com.ada.adaflix.model.Usuario;
import jakarta.persistence.*;

public class IngressoRequestDTO {
    private Long eventoId;
    private Integer quantidade;
    private String formaPagamento;
    private Long usuarioId;

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
