import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, FormsModule, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';

@Component({
  selector: 'app-criar-usuario',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './criar-usuario.html',
  styleUrl: './criar-usuario.css',
})
export class CriarUsuario {

  //Injecao de dependencia da classe HttpCliente
  private http = inject(HttpClient);

  //Criando a estrutura do formulário
  formCriarUsuario = new FormGroup({
    nome: new FormControl('', [Validators.required, Validators.minLength(8)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    senha: new FormControl('', [Validators.required, Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^a-zA-Z0-9]).{8,}$/)]),
    senhaConfirmacao: new FormControl('', [Validators.required]),
    aceiteTermos: new FormControl(false, [Validators.requiredTrue])
  }, {
    validators: this.validarSenhasIguais
  });

  //Função para validação customizada do campo 'senhaConfirmacao'
  validarSenhasIguais(control: AbstractControl) : ValidationErrors | null {
    //capturar o valor preenchido nos campos senha e senhaConfirmacao
    const valorSenha = control.get('senha')?.value;
    const valorSenhaConfirmacao = control.get('senhaConfirmacao')?.value;
    
    //verificar se o usuário informou a senha e os valores estão diferentes
    if(valorSenha && valorSenhaConfirmacao && valorSenha !== valorSenhaConfirmacao) {
      //retornar um erro de validacao
      return { senhasDiferentes: true }
    }

    return null;
  }

  //Função par acapturar o evento de submit do firmulario
  criarUsuario() {

    //Criando um JSON somente com os campos requeridos pela API
    const json = {
      nome : this.formCriarUsuario.value.nome,
      email : this.formCriarUsuario.value.email,
      senha : this.formCriarUsuario.value.senha
    };

    //Enviando a requisição para o backend
    this.http.post('http://localhost:8081/api/v1/usuario/criar', json)
      .subscribe({
        next : (response) => { //Capturando se o retorno for sucesso da API
          console.log('Sucesso!', response);
        },
        error : (e) => { //Capturando se o retorno for diferente de HTTP do grupo 200
          console.log("Error: ", e.error);
        }
      });

  }

}
