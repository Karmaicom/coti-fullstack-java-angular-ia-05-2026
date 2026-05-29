create table produto (
    id                  serial              primary key,
    nome                varchar(150)        not null,
    descricao           text                not null,
    preco               decimal(10,2)       not null,
    quantidade          integer             not null,
    data_cadastro       timestamp           not null    default current_timestamp, -- Já cadastra com data atual
    data_atualizacao    timestamp           null,
    data_exclusao       timestamp           null,
    ativo               int                 not null    default 1 -- Produto é cadastrado automaticamente como ativo
);