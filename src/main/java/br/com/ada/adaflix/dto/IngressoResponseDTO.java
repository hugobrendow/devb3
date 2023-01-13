package br.com.ada.adaflix.dto;

import java.time.LocalDateTime;

public class IngressoResponseDTO {
    private Long id;
    private String nomeEvento;
    private LocalDateTime data;
    private Integer ingressosComprados;
    private String local;
    private Double valorPago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getIngressosComprados() {
        return ingressosComprados;
    }

    public void setIngressosComprados(Integer ingressosComprados) {
        this.ingressosComprados = ingressosComprados;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }
}
