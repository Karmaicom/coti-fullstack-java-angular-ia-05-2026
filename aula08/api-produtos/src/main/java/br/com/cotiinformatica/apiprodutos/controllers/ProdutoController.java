package br.com.cotiinformatica.apiprodutos.controllers;

import br.com.cotiinformatica.apiprodutos.dtos.ProdutoRequestDTO;
import br.com.cotiinformatica.apiprodutos.dtos.ProdutoResponseDTO;
import br.com.cotiinformatica.apiprodutos.entities.Produto;
import br.com.cotiinformatica.apiprodutos.intefaces.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private IProdutoRepository repository;

    @Autowired
    public ProdutoController(IProdutoRepository repository) {
        this.repository = repository;
    }

    /**
     * Metodo End point para consultar produto por nome
     * @param nome
     * @return
     */
    @GetMapping("/listar")
    public ResponseEntity<?> obterPorNome(String nome) {
        try {
            var produto = repository.obterPorNome(nome);

            //Executando e capturando a lista de produtos no banco
            var lista = repository.obterPorNome(nome);

            //Copiando os registros obtidos do banco para uma lista de ProdutoResponseDto
            var response = lista.stream()
                    .map(item -> new ProdutoResponseDTO(
                            item.getId(),
                            item.getNome(),
                            item.getDescricao(),
                            item.getPreco(),
                            item.getQuantidade(),
                            item.getAtivo(),
                            item.getPreco() * item.getQuantidade()
                    )).toList();

            return ResponseEntity.status(200).body(response);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            return ResponseEntity.status(500).body("Erro ao tentar inserir produto!\n" +  e.getMessage());
        }
    }

    /**
     * Metodo para cadastrar um produto no banco de dados
     * @param produtoRequest
     * @return
     */
    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody ProdutoRequestDTO produtoRequest) {
        try {
            var produto = new Produto();
            produto.setNome(produtoRequest.nome());
            produto.setDescricao(produtoRequest.descricao());
            produto.setPreco(produtoRequest.preco());
            produto.setQuantidade(produtoRequest.quantidade());

            repository.inserirProduto(produto);

            return ResponseEntity.status(201).body("Produto cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            return ResponseEntity.status(500).body("Erro ao tentar inserir produto!\n" +  e.getMessage());
        }
    }

    /**
     * Metodo para alterar o cadastro de um produto
     * @param id
     * @param dto
     * @return
     */
    @PutMapping("alterar/{id}")
    public ResponseEntity<String> alterar(@PathVariable int id, @RequestBody ProdutoRequestDTO dto) {
        try {
            var produto = new Produto();
            produto.setId(id);
            produto.setNome(dto.nome());
            produto.setDescricao(dto.descricao());
            produto.setPreco(dto.preco());
            produto.setQuantidade(dto.quantidade());

            if (repository.atualizar(id, produto)) {
                return ResponseEntity.status(200).body("Produto atualizado com sucesso!");
            } else {
                return ResponseEntity.status(404).body("Produto não encontrado para atualização!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            return ResponseEntity.status(500).body("Erro ao tentar atualizar um produto!\n" +  e.getMessage());
        }
    }

    /**
     * Metodo para excluir um produto
     * @param id
     * @return
     */
    @DeleteMapping("excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Integer id) {
        try {
            if (repository.excluir(id)) {
                return ResponseEntity.status(200).body("Produto excluído com sucesso!");
            } else {
                return ResponseEntity.status(404).body("Produto não encontrado para exclusão!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            return ResponseEntity.status(500).body("Erro ao tentar excluir produto!\n" +  e.getMessage());
        }
    }

    /**
     * Metodo para buscar um produto por id
     * @param id
     * @return
     */
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            //Executando e capturando um produto através do ID
            var produto = repository.buscarPorId(id);

            if(produto == null) {
                return ResponseEntity.status(404).body("Produto não encontrado.");
            }

            var response = new ProdutoResponseDTO(
                    produto.getId(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco(),
                    produto.getQuantidade(),
                    produto.getAtivo(),
                    produto.getPreco() * produto.getQuantidade()
            );

            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            return ResponseEntity.status(500).body("Erro ao tentar inserir produto!\n" +  e.getMessage());
        }
    }
}
