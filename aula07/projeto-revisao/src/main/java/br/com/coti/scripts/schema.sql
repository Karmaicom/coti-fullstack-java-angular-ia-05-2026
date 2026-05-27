create table funcionario (
    id              UUID            primary key,
    nome            varchar(150)    not null,
    matricula       varchar(20)     not null,
    cpf             varchar(14)     not null,
    dataAdmissao    DATE            not null,
    tipoContrato    varchar(20)     not null
);