# Exercício: Programação Orientada a Objetos (POO) em Java

Este repositório contém a resolução de um exercício prático focado em conceitos fundamentais de **Programação Orientada a Objetos**, **Padrão MVC/Camadas** (Controllers, Services, Entities) e **Persistência de Dados em XML** utilizando a linguagem Java.

---

## 🚀 Objetivo do Projeto

O objetivo principal é construir uma aplicação de console que permita o cadastro de funcionários, encapsulando as regras de negócio em camadas distintas e persistindo os dados informados em um arquivo local no formato XML.

## 📋 Requisitos do Exercício

O projeto foi desenvolvido seguindo estritamente os seguintes critérios:

*   **Nome do Projeto:** `exercicio-poo`
*   **Arquitetura de Pacotes:** Organização clara e dividida em:
    *   `entities` (Modelagem do domínio)
    *   `services` (Regras de negócio e persistência)
    *   `controllers` (Interação com o usuário e orquestração)

### 🧱 Estrutura das Classes

1.  **`Funcionario` (Camada `entities`):**
    *   Atributos: `id` (UUID), `nome` (String) e `salario` (Double).
    *   Regras: Construtor configurado para gerar e preencher o `id` automaticamente no momento da instanciação. Atributos privados e protegidos por métodos *getters* e *setters* (Encapsulamento).

2.  **`FuncionarioService` (Camada `services`):**
    *   Responsável por receber o objeto do funcionário e realizar a persistência salvando os dados em um arquivo com formato **XML**.

3.  **`FuncionarioController` (Camada `controllers`):**
    *   Orquestrador do fluxo de cadastro. Captura as entradas do usuário via teclado (`Scanner`) e repassa o objeto estruturado para a camada de serviço.

4.  **`Main`:**
    *   Ponto de entrada da aplicação (`main`), responsável por iniciar a execução do cadastro.

---

## 🛠️ Tecnologias Utilizadas

*   **Java SE** (Java Development Kit)
*   **UUID API** (Para geração de identificadores únicos globais)
*   **XML Serialization** (Para persistência dos dados)

---

## 📂 Estrutura de Pastas Sugerida

```text
src/
└── main/
    └── java/
        └── br/
            └── com/
                └── exerciciopoo/
                    ├── controllers/
                    │   └── FuncionarioController.java
                    ├── entities/
                    │   └── Funcionario.java
                    ├── services/
                    │   └── FuncionarioService.java
                    └── Main.java