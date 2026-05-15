

create table cliente (
    id      uuid                primary key,
    nome    varchar(100)        not null,
    cpf     varchar(14)         not null
);

create table endereco(
    id                  uuid                primary key,
    logradouro          varchar(100)        not null,
    numero              varchar(15)         not null,
    complemento         varchar(50)         not null,
    bairro              varchar(50)         not null,
    cidade              varchar(50)         not null,
    uf                  varchar(2)          not null,
    cep                 varchar(9)          not null,
    cliente_id          uuid                not null,
    foreign key (cliente_id) references cliente(id)
);