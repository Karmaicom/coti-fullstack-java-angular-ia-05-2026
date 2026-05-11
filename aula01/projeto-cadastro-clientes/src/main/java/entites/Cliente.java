package main.java.entites;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe de modelo de dados para cliente
 */
public class Cliente {

    // Atributos do cliente
    public UUID id;
    public String nome;
    public String email;
    public String telefone;
    public String cpf;
    public LocalDateTime dataHoraCadastor;


}
