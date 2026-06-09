
create table cliente (
    id                  UUID              primary key not null,
    nome                varchar(100)        not null,
    email               varchar(100)        not null unique,
    cpf                 char(14)            not null unique,
    telefone            varchar(20)         not null,
    data_cadastro       timestamp           not null    default current_timestamp, -- Já cadastra com data atual
    data_atualizacao    timestamp           null,
    data_exclusao       timestamp           null,
    ativo               int                 not null    default 1 -- Cliente é cadastrado automaticamente como ativo
);