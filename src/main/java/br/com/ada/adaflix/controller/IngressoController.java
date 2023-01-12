package br.com.ada.adaflix.controller;

import br.com.ada.adaflix.dto.IngressoRequestDTO;
import br.com.ada.adaflix.model.Ingresso;
import br.com.ada.adaflix.service.IngressoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

    /*
        Quero um endpoint para comprar um ingresso:
            - Evento
            - Usuário
            - Forma de Pagamento
            - Quantidade

            Ficar atento no horário e dia permitido para venda...

        Retornar o Ingresso:
            - Número do ingresso
            - Horário do evento
            - Nome do Evento
            - Local
            - Endereço
     */

    private final IngressoService ingressoService;

    public IngressoController(IngressoService ingressoService) {
        this.ingressoService = ingressoService;
    }

    @PostMapping("/comprar")
    public Ingresso comprar(@RequestBody IngressoRequestDTO ingressoRequestDTO) {
        return ingressoService.comprar(ingressoRequestDTO);
    }

}
