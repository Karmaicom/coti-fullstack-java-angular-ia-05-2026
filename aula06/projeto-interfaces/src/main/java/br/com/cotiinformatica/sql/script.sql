create table aluno(
    id          serial              primary key,
    nome        varchar(150)        not null,
    matricula   varchar(10)         not null,
    email       varchar(50)         not null
);

create table professores(
    id          serial              primary key,
    nome        varchar(150)        not null,
    telefone    varchar(15)         not null
);