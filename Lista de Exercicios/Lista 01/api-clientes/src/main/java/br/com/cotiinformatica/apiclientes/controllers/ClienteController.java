package br.com.cotiinformatica.apiclientes.controllers;

import br.com.cotiinformatica.apiclientes.dtos.ClienteRequestDTO;
import br.com.cotiinformatica.apiclientes.dtos.ClienteResponseDTO;
import br.com.cotiinformatica.apiclientes.entites.Cliente;
import br.com.cotiinformatica.apiclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Metodo para cadastrar um cliente no banco de dados
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody ClienteRequestDTO dto) {
        try {
            var cliente = new Cliente();
            cliente.setId(UUID.randomUUID());
            cliente.setNome(dto.nome());
            cliente.setEmail(dto.email());
            cliente.setCpf(dto.cpf());
            cliente.setTelefone(dto.telefone());

            clienteRepository.inserir(cliente);

            return ResponseEntity.status(201).body("Cliente " + cliente.getNome() + " inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage() );
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    /**
     * Metodo para atualizar os dados de um cliente
     * @param id
     * @param dto
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody ClienteRequestDTO dto) {
        try {
            var cliente = new Cliente();
            cliente.setNome(dto.nome());
            cliente.setEmail(dto.email());
            cliente.setCpf(dto.cpf());
            cliente.setTelefone(dto.telefone());

            var result = clienteRepository.atualizar(id, cliente);

            if (result)
                return ResponseEntity.status(200).body("Cliente " + cliente.getNome() + " atualizado com sucesso!");
            else
                return ResponseEntity.status(400).body("Não foi possível atualizar os dados do cliente informado!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage() );
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    /**
     * Metodo para remover/inativar um cliente no banco de dados
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> remover(@PathVariable UUID id) {
        try {
            var result = clienteRepository.excluir(id);

            if (result)
                return ResponseEntity.status(200).body("Cliente excluído com sucesso!");
            else
                return ResponseEntity.status(400).body("Não foi possível excluir o cliente informado!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage() );
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    /**
     * Metodo para ativar um cliente no banco de dados
     * @param id
     * @return
     */
    @PutMapping("/ativar/{id}")
    public ResponseEntity<?> ativar(@PathVariable UUID id) {
        try {
            var result = clienteRepository.ativar(id);

            if (result)
                return ResponseEntity.status(200).body("Cliente ativado com sucesso!");
            else
                return ResponseEntity.status(400).body("Não foi possível ativar o cliente informado!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage() );
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    /**
     * Metodo para listar todos os clientes ativos no banco de dados
     * @return
     */
    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            return ResponseEntity.status(200).body(clienteRepository.listar());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage() );
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    /**
     * Metodo para buscar um cliente filtrando atraves do id do cliente
     * @param id
     * @return
     */
    @GetMapping("/buscarPorId")
    public ResponseEntity<?> buscarPorId(@RequestParam UUID id) {
        try {
            var cliente = clienteRepository.buscarPorId(id);

            if (cliente != null) {
                var dto = new ClienteResponseDTO(
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getCpf(),
                        cliente.getTelefone(),
                        cliente.getDataCadastro(),
                        cliente.getDataAtualizacao(),
                        cliente.getDataExclusao(),
                        cliente.getAtivo()
                );

                return ResponseEntity.status(200).body(dto);
            } else
                return ResponseEntity.status(404).body("Não foi possível encontrar os dados do cliente informado!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage() );
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
