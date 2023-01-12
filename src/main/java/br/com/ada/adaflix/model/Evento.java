package br.com.ada.adaflix.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj = "DEFAULT";
    private String nome;
    @Column(unique = true)
    private String descricao;
    private LocalDateTime data;
    private String local;
    private Double preco;
    private Long capacidade;
    private LocalDateTime inicioVendas;
    @Column(name = "encerramento")
    private LocalDateTime fimVendas;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Long capacidade) {
        this.capacidade = capacidade;
    }

    public LocalDateTime getInicioVendas() {
        return inicioVendas;
    }

    public void setInicioVendas(LocalDateTime inicioVendas) {
        this.inicioVendas = inicioVendas;
    }

    public LocalDateTime getFimVendas() {
        return fimVendas;
    }

    public void setFimVendas(LocalDateTime fimVendas) {
        this.fimVendas = fimVendas;
    }
}
