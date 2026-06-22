package br.com.cotiinformatica.apiusuarios.services;

import br.com.cotiinformatica.apiusuarios.components.JwtComponent;
import br.com.cotiinformatica.apiusuarios.dtos.*;
import br.com.cotiinformatica.apiusuarios.entities.Usuario;
import br.com.cotiinformatica.apiusuarios.exceptions.AcessoNegadoException;
import br.com.cotiinformatica.apiusuarios.exceptions.EmailJaCadastradoException;
import br.com.cotiinformatica.apiusuarios.exceptions.SenhaInvalidaException;
import br.com.cotiinformatica.apiusuarios.repositories.PerfilRepository;
import br.com.cotiinformatica.apiusuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired //inicialização automática
    private UsuarioRepository usuarioRepository;

    @Autowired //inicialização automática
    private PerfilRepository perfilRepository;

    @Autowired
    private JwtComponent jwtComponent;

    // Metodo para implementar fluxo de autenticacao de usuario no sistema (login do usuario)
    public AutenticarUsuarioResponse autenticarUsuario(AutenticarUsuarioRequest request) throws Exception {

        //Buscar o usuario no banco de dados atraves do email
        var usuario = usuarioRepository.obterPorEmail(request.email());

        //Buscar perfil no banco de dados
        var perfil = perfilRepository.buscarPorId(usuario.getPerfilId());

        //Verificar se o usuario foi encontrado e se a senha é igual ao valor enviado
        //Exception AcessoNegadoException
        if (usuario != null && usuario.getSenha().equals(criptografarSenha(request.senha()))) {
            return new AutenticarUsuarioResponse(
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    perfil.getNome(),
                    LocalDateTime.now(),
                    jwtComponent.getAccessToken(usuario.getEmail(), perfil.getNome())
            );
        }

        throw new AcessoNegadoException();
    }

    //Metodo para implementarmos um fluxo de criação
    //de usuário no sistema (novo usuário)
    public CriarUsuarioResponse criarUsuario(CriarUsuarioRequest request) throws Exception {

        //Codigo de seguranca para verificar se a senha é forte
        if(!validarSenhaForte(request.senha())) {
            throw new SenhaInvalidaException();
        }

        //Codigo de seguranca para verificar se o email já está cadastrado
        if(usuarioRepository.obterPorEmail(request.email()) != null) {
            throw new EmailJaCadastradoException();
        }
        
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

    /**
     * Metodo para retornar os dados do usuario
     * @param email
     */
    public DadosUsuarioResponse obterDadosUsuario(String email) throws Exception {

        //Buscar os dados do usuario no banco de dados atraves do email
        var usuario = usuarioRepository.obterPorEmail(email);

        //Buscar o perfil do usuario no banco de dados
        var perfil = perfilRepository.buscarPorId(usuario.getPerfilId());

        //Retornar os dados do usuario
        return new DadosUsuarioResponse(
                usuario.getId(),
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

    //Validar padrao de senha forte
    //
    private boolean validarSenhaForte(String senha) throws Exception {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$";
        return senha.matches(regex);
    }

}
