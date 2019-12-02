CREATE DATABASE IF NOT EXISTS clinivet;
CREATE SCHEMA clinivetschema;
SET search_path='clinivetschema';

TRUNCATE TABLE clinivetschema.administradores;
TRUNCATE TABLE clinivetschema.animais;
TRUNCATE TABLE clinivetschema.clientes;
TRUNCATE TABLE clinivetschema.consultas;
TRUNCATE TABLE clinivetschema.documentos;
TRUNCATE TABLE clinivetschema.especies;
TRUNCATE TABLE clinivetschema.funcionarios;
TRUNCATE TABLE clinivetschema.pagamentos;
TRUNCATE TABLE clinivetschema.pedidos;
TRUNCATE TABLE clinivetschema.procedimentos;
TRUNCATE TABLE clinivetschema.racas;
TRUNCATE TABLE clinivetschema.relatorios;
TRUNCATE TABLE clinivetschema.resultados;
TRUNCATE TABLE clinivetschema.servicos;
TRUNCATE TABLE clinivetschema.veterinarios;

CREATE TABLE IF NOT EXISTS clinivetschema.administradores (
	nome character varying(255) NOT NULL,
	sexo character(1),
	endereco character varying(255)  NOT NULL,
	cidade character varying(255)  NOT NULL,
	estado character varying(255)  NOT NULL,
	telefone_residencial character varying(255)  NOT NULL,
	telefone_celular character varying(255)  NOT NULL,
	email character varying(255)  NOT NULL,
	cpf integer NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,

    CONSTRAINT adm_sexo_check CHECK ((sexo = ANY (ARRAY['F'::bpchar, 'M'::bpchar])))
);

CREATE TABLE IF NOT EXISTS clinivetschema.funcionarios (
	nome character varying(255) NOT NULL,
	sexo character(1),
	endereco character varying(255)  NOT NULL,
	cidade character varying(255)  NOT NULL,
	estado character varying(255)  NOT NULL,
	telefone_residencial character varying(255)  NOT NULL,
	telefone_celular character varying(255)  NOT NULL,
	email character varying(255)  NOT NULL,
	cpf integer NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,

    CONSTRAINT funcionario_sexo_check CHECK ((sexo = ANY (ARRAY['F'::bpchar, 'M'::bpchar])))
);

CREATE TABLE IF NOT EXISTS clinivetschema.veterinarios (
	nome character varying(255) NOT NULL,
	sexo character(1),
	endereco character varying(255)  NOT NULL,
	cidade character varying(255)  NOT NULL,
	estado character varying(255)  NOT NULL,
	telefone_residencial character varying(255)  NOT NULL,
	telefone_celular character varying(255)  NOT NULL,
	email character varying(255)  NOT NULL,
	cpf integer NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,

    CONSTRAINT veterinario_sexo_check CHECK ((sexo = ANY (ARRAY['F'::bpchar, 'M'::bpchar])))
);

CREATE TABLE IF NOT EXISTS clinivetschema.animais (
	nome character varying(255) NOT NULL,
	sexo character(1) NOT NULL,
	cor character varying(255) NOT NULL,
	especie character varying(255) NOT NULL,
	raca character varying(255) NOT NULL,
	donoId integer NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,

    CONSTRAINT animal_sexo_check CHECK ((sexo = ANY (ARRAY['F'::bpchar, 'M'::bpchar])))
);

CREATE TABLE IF NOT EXISTS clinivetschema.clientes (
	nome character varying(255) NOT NULL,
	sexo character(1),
	endereco character varying(255)  NOT NULL,
	cidade character varying(255)  NOT NULL,
	estado character varying(255)  NOT NULL,
	telefone_residencial character varying(255)  NOT NULL,
	telefone_celular character varying(255)  NOT NULL,
	email character varying(255)  NOT NULL,
	cpf integer NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,

    CONSTRAINT clientes_sexo_check CHECK ((sexo = ANY (ARRAY['F'::bpchar, 'M'::bpchar])))
);

CREATE TABLE IF NOT EXISTS clinivetschema.consultas (
	tipo character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	id_animal integer NOT NULL,
	id_veterinario integer NOT NULL,
);

CREATE TABLE IF NOT EXISTS clinivetschema.documentos (
	caminho_arquivo character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS clinivetschema.pagamentos (
	pagante integer NOT NULL,
	tipo character varying(255) NOT NULL,
	valor numeric(10,2) NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS clinivet.pedidos (
	tipo character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS clinivet.procedimentos (
	tipo character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer NOT NULL
);

CREATE TABLE IF NOT EXISTS clinivet.racas (
	nome character varying(255) PRIMARY KEY,
	descricao character varying(255)
);

CREATE TABLE IF NOT EXISTS clinivet.relatorios (
	autor character varying(255) NOT NULL,
	assunto character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
)