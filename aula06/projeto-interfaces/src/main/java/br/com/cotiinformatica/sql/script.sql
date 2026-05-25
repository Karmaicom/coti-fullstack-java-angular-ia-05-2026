create table aluno(
    id          UUID             	primary key,
    nome        varchar(150)        not null,
    matricula   varchar(10)         not null,
    email       varchar(50)         not null
);

create table professor(
    id          UUID                primary key,
    nome        varchar(150)        not null,
    telefone    varchar(15)         not null
);