create database hierarquia;

use hierarquia;

create table funcionario(
 cpf char(11) primary key,
 nome char(255) not null,
 email char(80) not null,
 telefone char(15) not null,
 aniversario date not null,
 terceiro boolean default false
 );
 
 create table departamento(
 codigo int primary key,
 nome char(20) not null
 
 );
 
 create table funcao(
 id int not null primary key,
 funcao char(20) not null,
 salario double not null
 );
 
 create table func_dpto_funcao(
 cpf_colaborador char(11),
 id_funcao int not null,
 cod_departamento int not null,
 situacao_cadastral enum('Ativo', 'Desligado'),
 
 constraint fk_idfuncionario foreign key(cpf_colaborador) references funcionario(cpf),
 constraint fk_idfuncao foreign key(id_funcao) references funcao(id),
 constraint fk_iddpto foreign key(cod_departamento) references departamento(codigo)
 );