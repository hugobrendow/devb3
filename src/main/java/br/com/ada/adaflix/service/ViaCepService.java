package br.com.ada.adaflix.service;

import br.com.ada.adaflix.dto.EnderecoViaCepDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ViaCepService {
    private RestTemplate restTemplate;
    private WebClient webClient;
    private final String url = "https://viacep.com.br/ws/";

    public ViaCepService(RestTemplateBuilder restTemplateBuilder, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.webClient = webClientBuilder.baseUrl(url).build();
    }

    public EnderecoViaCepDTO getEndereco(String cep) {
        String urlCompleta = url + cep + "/json";
        System.out.println("Chamando endereço: " + urlCompleta);
        return this.restTemplate.getForObject(urlCompleta, EnderecoViaCepDTO.class);
    }

    public EnderecoViaCepDTO getEnderecoWebClient(String cep) {
        return this.webClient.get()
                .uri("{cep}/json", cep)
                .retrieve()
                .toEntity(EnderecoViaCepDTO.class)
                .block().getBody();
    }
}
