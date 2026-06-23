# API Usuarios

API REST para cadastro, autenticacao e consulta de dados de usuarios. O projeto foi desenvolvido com Spring Boot, utiliza MySQL como banco de dados, JDBC para acesso aos dados, JWT para autenticacao e Swagger/OpenAPI para documentacao interativa.

## Tecnologias

- Java 25
- Spring Boot 4.1.0
- Spring Web MVC
- Maven
- MySQL 8
- Docker Compose
- JWT
- Lombok
- Springdoc OpenAPI / Swagger UI

## Estrutura do projeto

```text
api-usuarios
|-- docker-compose.yaml
|-- pom.xml
`-- src
    |-- main
    |   |-- java/br/com/cotiinformatica/apiusuarios
    |   |   |-- components
    |   |   |-- configurations
    |   |   |-- controllers
    |   |   |-- dtos
    |   |   |-- entities
    |   |   |-- exceptions
    |   |   |-- factories
    |   |   |-- filters
    |   |   |-- repositories
    |   |   |-- scripts
    |   |   `-- services
    |   `-- resources
    `-- test
```

## Funcionalidades

- Criar usuario com validacao de senha forte.
- Impedir cadastro de e-mail duplicado.
- Criptografar senha com SHA-256 antes de salvar.
- Autenticar usuario por e-mail e senha.
- Gerar token JWT apos autenticacao.
- Proteger endpoint de dados do usuario com Bearer Token.
- Consultar dados do usuario autenticado.

## Pre-requisitos

- Java 25
- Maven 3.9+
- Docker e Docker Compose

Tambem e possivel usar o Maven Wrapper do projeto:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

## Como executar

Clone o repositorio e acesse a pasta do projeto:

```bash
git clone https://github.com/Karmaicom/coti-fullstack-java-angular-ia-05-2026.git
cd coti-fullstack-java-angular-ia-05-2026/aula12/api-usuarios
```

Suba o MySQL e o phpMyAdmin com Docker Compose:

```bash
docker compose up -d
```

Servicos iniciados:

| Servico | URL / Porta |
| --- | --- |
| MySQL | `localhost:3309` |
| phpMyAdmin | `http://localhost:5052` |

Credenciais do banco configuradas no projeto:

| Campo | Valor |
| --- | --- |
| Database | `bd_api_usuarios` |
| Usuario | `coti` |
| Senha | `Coti@2026` |
| Porta | `3309` |

Crie as tabelas executando o script:

```sql
use bd_api_usuarios;

create table perfis(
   id int auto_increment,
   nome varchar(25) not null unique,
   primary key(id)
);

create table usuarios(
     id int auto_increment,
     nome varchar(100) not null,
     email varchar(100) not null unique,
     senha varchar(100) not null,
     data_hora_cadastro timestamp not null,
     perfil_id int not null,
     primary key(id),
     foreign key(perfil_id) references perfis(id)
);
```

Cadastre o perfil padrao usado no fluxo de criacao de usuarios:

```sql
insert into perfis (nome) values ('Operador');
```

Execute a aplicacao:

```bash
mvn spring-boot:run
```

A API ficara disponivel em:

```text
http://localhost:8081
```

## Configuracao

O perfil ativo padrao e `developer`, definido em `src/main/resources/application.yaml`:

```yaml
spring:
  profiles:
    active: developer

server:
  port: 8081
```

As configuracoes de banco e JWT ficam em `src/main/resources/application-developer.yaml`:

```yaml
datasource:
  url: jdbc:mysql://localhost:3309/bd_api_usuarios?useSSL=false&serverTimezone=America/Sao_Paulo&allowPublicKeyRetrieval=true
  user: coti
  pass: Coti@2026
  driver-class-name: com.mysql.cj.jdbc.Driver

jwt:
  secret: 2c3370b8-ff54-4897-8234-e4c1c3103151
  expiration: 3600000
```

## Documentacao da API

Com a aplicacao em execucao, acesse o Swagger UI:

```text
http://localhost:8081/swagger-ui/index.html
```

## Endpoints

Base URL:

```text
http://localhost:8081/api/v1/usuario
```

### Criar usuario

```http
POST /api/v1/usuario/criar
Content-Type: application/json
```

Request:

```json
{
  "nome": "Ana Silva",
  "email": "ana.silva@email.com",
  "senha": "Senha@123"
}
```

Response `201 Created`:

```json
{
  "mensagem": "Usuario criado com sucesso",
  "nomeUsuario": "Ana Silva",
  "emailUsuario": "ana.silva@email.com",
  "perfilUsuario": "Operador"
}
```

Regras:

- A senha deve ter no minimo 8 caracteres.
- A senha deve conter letra minuscula, letra maiuscula, numero e caractere especial.
- O e-mail deve ser unico.

Possiveis respostas:

| Status | Descricao |
| --- | --- |
| `201` | Usuario criado com sucesso |
| `409` | E-mail ja cadastrado ou senha invalida |
| `500` | Erro interno |

### Autenticar usuario

```http
POST /api/v1/usuario/autenticar
Content-Type: application/json
```

Request:

```json
{
  "email": "ana.silva@email.com",
  "senha": "Senha@123"
}
```

Response `200 OK`:

```json
{
  "id": 1,
  "nome": "Ana Silva",
  "email": "ana.silva@email.com",
  "perfil": "Operador",
  "dataHoraAcesso": "2026-05-01T10:30:00",
  "accessToken": "token.jwt.gerado"
}
```

Possiveis respostas:

| Status | Descricao |
| --- | --- |
| `200` | Usuario autenticado com sucesso |
| `401` | Acesso negado |
| `500` | Erro interno |

### Obter dados do usuario autenticado

```http
GET /api/v1/usuario/obter-dados
Authorization: Bearer <accessToken>
```

Response `200 OK`:

```json
{
  "id": 1,
  "nome": "Ana Silva",
  "email": "ana.silva@email.com",
  "perfil": "Operador"
}
```

Possiveis respostas:

| Status | Descricao |
| --- | --- |
| `200` | Dados retornados com sucesso |
| `401` | Token ausente, invalido ou expirado |
| `500` | Erro interno |

## Exemplos com cURL

Criar usuario:

```bash
curl -X POST http://localhost:8081/api/v1/usuario/criar \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Ana Silva",
    "email": "ana.silva@email.com",
    "senha": "Senha@123"
  }'
```

Autenticar usuario:

```bash
curl -X POST http://localhost:8081/api/v1/usuario/autenticar \
  -H "Content-Type: application/json" \
  -d '{
    "email": "ana.silva@email.com",
    "senha": "Senha@123"
  }'
```

Obter dados do usuario autenticado:

```bash
curl -X GET http://localhost:8081/api/v1/usuario/obter-dados \
  -H "Authorization: Bearer <accessToken>"
```

## Testes

Execute os testes com:

```bash
mvn test
```

## Observacoes

- O endpoint `/api/v1/usuario/obter-dados` exige token JWT no cabecalho `Authorization`.
- O token expira em `3600000` milissegundos, equivalente a 1 hora.
- O projeto usa JDBC diretamente, sem Spring Data JPA.
- Antes de criar usuarios, o perfil `Operador` precisa existir na tabela `perfis`.
