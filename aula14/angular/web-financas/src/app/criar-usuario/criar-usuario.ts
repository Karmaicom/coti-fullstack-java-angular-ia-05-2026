import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-criar-usuario',
  imports: [
    FormsModule,
    ReactiveFormsModule    
  ],
  templateUrl: './criar-usuario.html',
  styleUrl: './criar-usuario.css',
})
export class CriarUsuario {

  //Criando a estrutura do formulário
  formCriarUsuario = new FormGroup({
    nome : new FormControl('', [Validators.required, Validators.minLength(8)]),
    email : new FormControl('', [Validators.required, Validators.email]),
    senha : new FormControl('', [Validators.required, Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^a-zA-Z0-9]).{8,}$/)]),
    senhaConfirmacao : new FormControl('', [Validators.required]),
    aceiteTermos : new FormControl(false, [Validators.requiredTrue])
  });

  //Função par acapturar o evento de submit do firmulario
  criarUsuario() {
    console.log(this.formCriarUsuario.value);
  }

}
