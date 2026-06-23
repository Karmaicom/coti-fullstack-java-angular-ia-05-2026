create table perfis (
    id int primary key,
    nome varchar(25) not null unique
);

create table usuarios (
    id int primary key,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    senha varchar(100) not null,
    data_hora_cadastro timestamp not null,
    perfil_id int not null,
    foreign key (perfil_id) references perfis(id)
);