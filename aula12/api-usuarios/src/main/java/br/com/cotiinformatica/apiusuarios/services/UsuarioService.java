package br.com.cotiinformatica.apiusuarios.services;

import br.com.cotiinformatica.apiusuarios.dtos.CriarUsuarioRequest;
import br.com.cotiinformatica.apiusuarios.dtos.CriarUsuarioResponse;
import br.com.cotiinformatica.apiusuarios.entities.Usuario;
import br.com.cotiinformatica.apiusuarios.repositories.PerfilRepository;
import br.com.cotiinformatica.apiusuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Service
public class UsuarioService {

    @Autowired //inicialização automática
    private UsuarioRepository usuarioRepository;

    @Autowired //inicialização automática
    private PerfilRepository perfilRepository;

    //Metodo para implementarmos um fluxo de criação
    //de usuário no sistema (novo usuário)
    public CriarUsuarioResponse criarUsuario(CriarUsuarioRequest request) throws Exception {

        //Capturar dados do usuario
        var usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(criptografarSenha(request.senha()));

        var perfil = perfilRepository.obterPorNome("Operador");

        usuario.setPerfilId(perfil.getId());

        //Salvar usuario no banco de dados
        usuarioRepository.inserir(usuario);

        //Retornar os dados da resposta
        return new CriarUsuarioResponse(
                "Usuário criado com sucesso",
                usuario.getNome(),
                usuario.getEmail(),
                perfil.getNome()
        );
    }

    //Metodo para fazer a criptografia da senha do usuario
    private String criptografarSenha(String senha) throws Exception {
        var digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(senha.getBytes(StandardCharsets.UTF_8));

        var hexString = new StringBuilder();

        for (byte b : hashBytes) {
            String hex = String.format("%02x", b);
            hexString.append(hex);
        }

        return hexString.toString();
    }


}
