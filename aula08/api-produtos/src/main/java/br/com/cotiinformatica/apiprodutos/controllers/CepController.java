package br.com.cotiinformatica.apiprodutos.controllers;

import br.com.cotiinformatica.apiprodutos.dtos.CepResponseDTO;
import br.com.cotiinformatica.apiprodutos.services.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/produtos/cep")
public class CepController {

    @Autowired
    private CepService cepRestClient;

    @GetMapping("/{cep}")
    public CepResponseDTO consultar(@PathVariable String cep) {
        return cepRestClient.consultarCep(cep);
    }

}
