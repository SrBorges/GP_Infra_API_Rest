create table problemas(

id bigint not null auto_increment,

problema varchar(30) not null,
localizacao varchar(60) not null,
logradouro varchar(30) not null,
bairro varchar(20) not null,
cidade varchar(30) not null,
estado varchar(2) not null,

primary key(id)

)
