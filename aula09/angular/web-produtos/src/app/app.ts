import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    FormsModule
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  // Criando um objeto d biblioteca HttpClient
  httpClient = inject(HttpClient);

  // Atributo para capturar o nome do produto
  nomeProduto: string = '';

  // Metodo para ser executada quando o botao de pesquisa for clicado
  pesquisarProdutos() {

    // Fazendo uma requisição HTTP GET para consultar os produtos na API
    this.httpClient.get('http://localhost:8085/api/v1/produtos/listar?nome=' + this.nomeProduto)
                  .subscribe((data) => { // Caputurando a resposta da API
                    console.log(data); // Exibindo a resposta no console do navegador
                  });

  }

}
