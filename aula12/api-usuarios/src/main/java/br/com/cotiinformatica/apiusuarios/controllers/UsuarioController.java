package br.com.cotiinformatica.apiusuarios.controllers;

import br.com.cotiinformatica.apiusuarios.dtos.CriarUsuarioRequest;
import br.com.cotiinformatica.apiusuarios.exceptions.EmailJaCadastradoException;
import br.com.cotiinformatica.apiusuarios.exceptions.SenhaInvalidaException;
import br.com.cotiinformatica.apiusuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("criar")
    public ResponseEntity<?>  criarUsuario(@RequestBody CriarUsuarioRequest request) {
        try {
            var response = usuarioService.criarUsuario(request);

            // HTTP 201 (CREATED)
            return ResponseEntity.status(201).body(response);
        } catch (EmailJaCadastradoException e) {
            // HTTP 409 (CONFLICT)
            return  ResponseEntity.status(409).body(e.getMessage());
        } catch (SenhaInvalidaException e) {
            // HTTP 400 (BAD REQUEST)
            return  ResponseEntity.status(409).body(e.getMessage());
        } catch (Exception e) {
            //HTTP 500 (INTERNAL SERVER ERROR)
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
