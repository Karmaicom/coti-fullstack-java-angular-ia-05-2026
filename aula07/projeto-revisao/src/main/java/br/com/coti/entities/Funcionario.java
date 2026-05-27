package br.com.coti.entities;

import br.com.coti.enums.TipoContrato;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Funcionario {

    private UUID id;
    private String nome;
    private String matricula;
    private String cpf;
    private LocalDate dataAdmissao;
    private TipoContrato tipoContrato;

    public Funcionario() {
        this.id = UUID.randomUUID();
    }

    public Funcionario(String nome, String matricula, String cpf, LocalDate dataAdmissao, TipoContrato tipoContrato) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
        this.tipoContrato = tipoContrato;
    }

    @Override
    public String toString() {
        return "Funcionario { " +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", matricula: '" + matricula + '\'' +
                ", cpf: '" + cpf + '\'' +
                ", dataAdmissao: " + dataAdmissao +
                ", tipoContrato: " + tipoContrato +
                "}\n";
    }
}
