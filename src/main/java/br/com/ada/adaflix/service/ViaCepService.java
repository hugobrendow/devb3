package br.com.ada.adaflix.service;

import br.com.ada.adaflix.dto.EnderecoViaCepDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
    private RestTemplate restTemplate;
    private final String url = "https://viacep.com.br/ws/";

    public ViaCepService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public EnderecoViaCepDTO getEndereco(String cep) {
        String urlCompleta = url + cep + "/json";
        System.out.println("Chamando endereço: " + urlCompleta);
        return this.restTemplate.getForObject(urlCompleta, EnderecoViaCepDTO.class);
    }
}
