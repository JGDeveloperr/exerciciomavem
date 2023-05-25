CREATE DATABASE  IF NOT EXISTS `lojacoisasecoisas`;
USE `lojacoisasecoisas`;


set SQL_SAFE_UPDATES=0;

create table clientes(
idcliente int auto_increment not null primary key,
nome char(40)not null,
registro char(40) not null,
email char(50)not null
);

CREATE TABLE servicos(
  id  int not null auto_increment primary key,
  cnpj_prestador varchar(25),
  tiposervico char(255) DEFAULT NULL,
  
  foreign key(id) references clientes(idcliente)
);


CREATE TABLE `prestador` (
  `idprestador` int NOT NULL AUTO_INCREMENT primary key,
  `descricaoservico` char(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  valor double,
  foreign key(idprestador) references clientes(idcliente)
  );
  
SELECT cnpj_prestador, nome, tiposervico, descricaoservico,date,valor
FROM prestador
inner join servicos
on prestador.idprestador = servicos.id
inner join clientes
on clientes.registro = servicos.cnpj_prestador;



create view find_one as

SELECT cnpj_prestador, nome, tiposervico, descricaoservico,date,valor 
FROM prestador 
inner join servicos on prestador.idprestador = servicos.id 
inner join clientes on clientes.registro = servicos.cnpj_prestador;


delimiter $$
create procedure retorna_id(inout registro1 char)
begin

SELECT idcliente
FROM `lojacoisasecoisas`.`clientes` 
where registro = registro1;

end $$
delimiter ;


delimiter $$
create procedure insere_prestador(inout registro1 char, inout descricaoservico1 char(255), in date1 date, in valor1 double)
begin

call retorna_id(@registro1);
select @id;
insert into prestador(id, descricaoservico, date, valor) values(descricaoservico1, date1, valor1);


end $$
delimiter ;

create view find_one as
SELECT cnpj_prestador, nome, tiposervico, descricaoservico,date,valor
FROM prestador
inner join servicos
on prestador.idprestador = servicos.id
inner join clientes
on clientes.registro = servicos.cnpj_prestador
where cnpj_prestador = "456.789/0001-01";