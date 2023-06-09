create table usuario(

id bigint not null auto_increment,
nome varchar(60) not null,
cpf varchar(50) not null,
dnascimento varchar(20) not null,
email varchar(30) not null,
logradouro varchar(30) not null,
bairro varchar(20) not null,
cidade varchar(30) not null,
estado varchar(2) not null,

primary key(id)

)