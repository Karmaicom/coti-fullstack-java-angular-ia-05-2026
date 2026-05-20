
use bd_produtos;

create table produtos (
    id          integer         auto_increment      primary key,
    nome        varchar(100)    not null,
    preco       double          not null,
    quantidade  integer         not null
);