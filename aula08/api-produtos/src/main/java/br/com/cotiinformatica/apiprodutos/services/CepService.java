package br.com.cotiinformatica.apiprodutos.services;

import br.com.cotiinformatica.apiprodutos.dtos.CepResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CepService {

    @Autowired
    private RestClient restClient;

    public CepResponseDTO consultarCep(String cep) {

        cep = cep.replace("-", "").trim();

        if (!cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido. Informe exatamente 8 números.");
        }

        CepResponseDTO response = restClient
                .get()
                .uri("https://viacep.com.br/ws/{cep}/json/", cep)
                .retrieve()
                .body(CepResponseDTO.class);

        if (response != null && Boolean.TRUE.equals(response.erro())) {
            throw new RuntimeException("CEP não encontrado.");
        }

        return response;
    }

}