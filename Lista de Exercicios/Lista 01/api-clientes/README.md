# API Clientes

API REST desenvolvida em **Java** com **Spring Boot**, criada como parte da lista de exercícios do curso **COTI Fullstack Java Angular IA - 05/2026**.

O projeto tem como objetivo praticar os principais conceitos de desenvolvimento backend com Spring Boot, incluindo criação de endpoints REST, organização em camadas, documentação com Swagger/OpenAPI e integração com banco de dados PostgreSQL.

---

## 📌 Sobre o projeto

A **API Clientes** é uma aplicação backend para gerenciamento de clientes. Ela pode ser utilizada como base para operações de cadastro, consulta, atualização e exclusão de registros de clientes em um banco de dados.

Este projeto é indicado para estudos de:

- Criação de APIs REST com Spring Boot;
- Organização de projetos Java em camadas;
- Integração com PostgreSQL;
- Uso de Lombok para reduzir código repetitivo;
- Documentação de endpoints com Swagger/OpenAPI;
- Boas práticas em aplicações backend.

---

## 🚀 Tecnologias utilizadas

- **Java 25**
- **Spring Boot 4.0.6**
- **Spring Web MVC**
- **PostgreSQL Driver**
- **Lombok**
- **Springdoc OpenAPI / Swagger UI**
- **Maven**

---

## 📁 Estrutura esperada do projeto

```text
api-clientes/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/cotiinformatica/
│   │   │       └── ...
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

---

## ⚙️ Pré-requisitos

Antes de executar o projeto, verifique se você possui instalado:

- JDK compatível com Java 25;
- Maven;
- PostgreSQL;
- Uma IDE Java, como IntelliJ IDEA, Eclipse ou VS Code;
- PgAdmin, DBeaver ou outro cliente para gerenciamento do banco.

---

## 🗄️ Configuração do banco de dados

Crie um banco de dados PostgreSQL para a aplicação. Exemplo:

```sql
CREATE DATABASE bd_clientes;
```

Depois, configure o arquivo `src/main/resources/application.properties`:

```properties
spring.application.name=api-clientes

spring.datasource.url=jdbc:postgresql://localhost:5432/bd_clientes
spring.datasource.username=postgres
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> Ajuste o usuário, senha, porta e nome do banco conforme a configuração do seu ambiente.

---

## ▶️ Como executar o projeto

Na raiz do projeto `api-clientes`, execute:

```bash
mvn spring-boot:run
```

Ou execute a classe principal da aplicação diretamente pela sua IDE.

Após iniciar, a API ficará disponível em:

```text
http://localhost:8080
```

---

## 📖 Documentação Swagger

Com a aplicação em execução, acesse a documentação interativa da API em:

```text
http://localhost:8080/swagger-ui.html
```

ou:

```text
http://localhost:8080/swagger-ui/index.html
```

A documentação OpenAPI geralmente fica disponível em:

```text
http://localhost:8080/v3/api-docs
```

---

## 🔗 Endpoints sugeridos

Abaixo está uma estrutura comum para uma API de clientes:

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/api/clientes` | Cadastra um novo cliente |
| `GET` | `/api/clientes` | Lista todos os clientes |
| `GET` | `/api/clientes/{id}` | Consulta um cliente por ID |
| `PUT` | `/api/clientes/{id}` | Atualiza os dados de um cliente |
| `DELETE` | `/api/clientes/{id}` | Remove um cliente |

Exemplo de JSON para cadastro:

```json
{
  "nome": "João da Silva",
  "email": "joao@email.com",
  "cpf": "12345678901"
}
```

---

## 🧪 Testando a API

Você pode testar os endpoints usando:

- Swagger UI;
- Insomnia;
- Postman;
- cURL;
- Extensões REST Client no VS Code.

Exemplo com cURL:

```bash
curl -X GET http://localhost:8080/api/clientes
```

---

## 📦 Dependências principais

As principais dependências estão configuradas no arquivo `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>3.0.2</version>
</dependency>

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

---

## 🎯 Objetivo educacional

Este projeto foi criado para reforçar conhecimentos fundamentais no desenvolvimento de aplicações backend com Java e Spring Boot, especialmente no contexto de APIs REST conectadas a banco de dados relacional.

---

## 👨‍💻 Autor

Desenvolvido por **Karmaicom Martins**.

Repositório do curso:

```text
https://github.com/Karmaicom/coti-fullstack-java-angular-ia-05-2026
```

---

## 📚 Fontes oficiais

- Documentação oficial do Spring Boot: https://docs.spring.io/spring-boot/
- Documentação oficial do Spring Framework MVC: https://docs.spring.io/spring-framework/reference/web/webmvc.html
- Documentação oficial do PostgreSQL: https://www.postgresql.org/docs/
- Documentação oficial do Springdoc OpenAPI: https://springdoc.org/
- Documentação oficial do Maven: https://maven.apache.org/guides/
