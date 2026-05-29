package br.com.cotiinformatica.apiprodutos.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @GetMapping("/listar")
    public String listar(){
        return "Listagem de produtos obtida com sucesso!";
    }

    @PostMapping("/criar")
    public String criar() {
        return "Produto criado com sucesso!";
    }

    @PutMapping("/alterar")
    public String alterar() {
        return "Produto alterado com sucesso!";
    }

    @DeleteMapping("/excluir")
    public String excluir(String id) {
        return "Produto excluído com sucesso!";
    }

}
