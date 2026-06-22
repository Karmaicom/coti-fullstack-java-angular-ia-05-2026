package br.com.cotiinformatica.apiusuarios.components;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtComponent {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private String jwtExpiration;

    /**
     * Metodo para retornar a data de expiração do Token
     * @return
     */
    public Date getExpirationDate() {
        var dataAtual = new Date(); // capturando a data atual do sistema
        //Retornando uma nova data adicionando o tempo de expiração
        return new Date(dataAtual.getTime() + Integer.parseInt(jwtExpiration));
    }

    /**
     * Metodo para gerar e retornar o Token JWT
     * @param emailUsuario
     * @param perfil
     * @return
     */
    public String getAccessToken(String emailUsuario, String perfil) {
        return Jwts.builder()
                .setSubject(emailUsuario) //Identificacao unica do usuario
                .claim("perfil", perfil) //Claims: informações adicionais do usuario
                .setIssuedAt(new Date()) //Data e hora da geração do Token
                .setExpiration(getExpirationDate()) //Date e hora da expiração do Token
                .signWith(SignatureAlgorithm.HS256, jwtSecret) //Assinatura do Token utilizando o algoritmo e a chave secreta
                .compact(); //Gerando o Token
    }

    /**
     * Metodo para ler o email do usuário contido no TOKEN JWT
     * @param http
     * @return Email do usuario, encontrado no token
     * @throws Exception
     */
    public String getEmailUsuario(HttpServletRequest http) throws Exception {
        String authorization = http.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return null;
        }

        String token = authorization.substring(7);

        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

}
