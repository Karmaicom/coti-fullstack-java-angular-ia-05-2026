package br.com.cotiinformatica.apiusuarios.controllers;

import br.com.cotiinformatica.apiusuarios.components.JwtComponent;
import br.com.cotiinformatica.apiusuarios.dtos.AutenticarUsuarioRequest;
import br.com.cotiinformatica.apiusuarios.dtos.CriarUsuarioRequest;
import br.com.cotiinformatica.apiusuarios.exceptions.AcessoNegadoException;
import br.com.cotiinformatica.apiusuarios.exceptions.EmailJaCadastradoException;
import br.com.cotiinformatica.apiusuarios.exceptions.SenhaInvalidaException;
import br.com.cotiinformatica.apiusuarios.services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtComponent jwtComponent;

    @PostMapping("criar")
    public ResponseEntity<?> criarUsuario(@RequestBody CriarUsuarioRequest request) {
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

    @PostMapping("autenticar")
    public ResponseEntity<?> autenticar(@RequestBody AutenticarUsuarioRequest request) {
        try {
            var response = usuarioService.autenticarUsuario(request);

            //HTTP 200 (OK)
            return ResponseEntity.status(200).body(response);
        } catch (AcessoNegadoException e) {
            // HTTP 401 (UNAUTHORIZED)
            return ResponseEntity.status(401).body(e.getMessage());
        } catch (Exception e) {
            // HTTP 500 (INTERNAL SERVER ERROR)
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("obter-dados")
    public ResponseEntity<?> obterDados(HttpServletRequest http) {
        try {
            //Retornar o e-mail do usuario passando todas as informações da requisição
            var email = jwtComponent.getEmailUsuario(http);

            //Buscando os dados do usuario atraves do e-mail
            var response = usuarioService.obterDadosUsuario(email);

            //HTTP 200 (OK)
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            // HTTP 500 (INTERNAL SERVER ERROR)
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
