import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

//Criando uma estrutura de dados para representar um produto
interface Produto {
  id: number,
  nome: string,
  descricao: string,
  preco: string,
  quantidade: string,
  total: string
}

@Component({
  selector: 'app-root',
  imports: [
    FormsModule,
    CommonModule
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

    // Endereço da API
    apiUrl: string = 'http://localhost:8081/api/v1/produtos';

    //Criando um objeto da biblioteca HttpClient
    httpClient = inject(HttpClient);  

    //Variável signal para armazenar a lista de produtos obtida da API
    produtos = signal<any>([]);
  
    //Variável signal para exibir as mensagens e notificações na página
    mensagem = signal<string>('');

    //Atributo para capturar o nome do produto
    nomeProduto: string = '';

    //Atributo para guardar os dados de um produto
    produtoSelecionado = signal<Produto>({
      id: 0, //valor padrão
      nome: '', //valor padrão
      descricao: '', //valor padrão
      preco: '', //valor padrão
      quantidade: '', //valor padrão
      total: '' //valor padrão
    });

    //Atributo para guardar uma flag que indique quando o formulário
    //de cadastro ou edição do produto será exibido
    exibirFormulario = signal<boolean>(false);

    //Função para ser executada quando o botão de pesquisa for clicado
    pesquisarProdutos() {
        //Fazendo uma requisição HTTP GET para consultar os produtos na API
        this.httpClient
              .get<any[]>('http://localhost:8081/api/v1/produtos/listar?nome=' + this.nomeProduto)
              .subscribe((data) => { //Capturando a resposta da API
                  //Armazenar os dados obtidos da API no signal
                  this.produtos.set(data);
              });
    }

    //Função para ser executada quando clicarmos no botão exclusão
    excluirProduto(id: number) {
      if(confirm('Deseja realmente excluir o produto selecionado?')) {
        this.httpClient
        .delete(`${this.apiUrl}/excluir/${id}`, {responseType: 'text'})
        .subscribe((response) => {
          //armazenando a resposta obtida da API
          this.mensagem.set(response);
        })
      }
    }

    //Função para exibir o formulário de cadastro de produto
    novoProduto() {
      this.exibirFormulario.set(true);
      this.mensagem.set('');
    }

    //Funcao para ocultar formulario e limpar os valores dos campos
    cancelarEdicao() {
      this.exibirFormulario.set(false);
      this.produtoSelecionado.set({
        id: 0,
        nome: '',
        descricao: '',
        preco: '',
        quantidade: '',
        total: ''
      });
    }

    //Função para realizar o cadastro do produto
    cadastrarProduto() {
      this.httpClient
      .post(`${this.apiUrl}/criar`, this.produtoSelecionado(), { responseType : 'text'})
        .subscribe((response) => {
          this.mensagem.set(response);
          this.cancelarEdicao();
        });

        //verificar se há uma consulta de produtos exibida na tela
        if(this.produtos().length > 0) {
          this.pesquisarProdutos(); //executando a consulta
        }
    }
}
