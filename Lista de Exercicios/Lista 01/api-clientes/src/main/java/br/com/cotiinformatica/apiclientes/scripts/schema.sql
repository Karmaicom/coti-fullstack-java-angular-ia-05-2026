
create table cliente (
     id                  uuid              primary key not null,
     nome                varchar(100)        not null,
     email               varchar(100)        not null unique,
     cpf                 char(14)            not null unique,
     telefone            varchar(20)         not null,
     data_cadastro       timestamp           not null    default current_timestamp, -- Já cadastra com data atual
     data_atualizacao    timestamp           null,
     data_exclusao       timestamp           null,
     ativo               int                 not null    default 1 -- Cliente é cadastrado automaticamente como ativo
);

select * from cliente;


select id, nome, email, cpf, telefone,
       data_cadastro, data_atualizacao, data_exclusao, ativo
from cliente where ativo = 1 and id = ('a2c3be30-0594-4fdc-aa86-8801567f9258'::uuid)


select id, nome, email, cpf, telefone,
       data_cadastro, data_atualizacao, data_exclusao, ativo
from cliente
where ativo = 1;



update cliente set
                   nome = ('Fulano da Silva Machado') ,
                   email = ('fulanodasilvamachado@gmail.com'),
                   cpf = ('111.111.111-11'),
                   telefone = ('(21) 99111-1111'),
                   data_atualizacao = ('2026-06-09 16:25:04.658776-03')
where ativo = 1 and id = ('a2c3be30-0594-4fdc-aa86-8801567f9258'::uuid)