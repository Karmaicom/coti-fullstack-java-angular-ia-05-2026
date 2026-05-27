package br.com.coti.entities;

import br.com.coti.enums.TipoContrato;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Funcionario {

    private UUID id;
    private String nome;
    private String matricula;
    private String cpf;
    private LocalDate dataAdmissao;
    private TipoContrato tipoContrato;

}
