CREATE DATABASE IF NOT EXISTS clinivet;
CREATE SCHEMA clinivetschema;
SET search_path='clinivetschema';

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
	tipo character varying(255) NOT NULL,
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
	id_especie integer,
	id_raca integer,
	id_dono integer NOT NULL,
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
	id_veterinario integer NOT NULL
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

CREATE TABLE IF NOT EXISTS clinivetschema.pedidos (
	tipo character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

-- 2 GATILHOS A SEREM CRIADOS

CREATE TABLE IF NOT EXISTS clinivetschema.procedimentos (
	tipo character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE IF NOT EXISTS clinivetschema.servicos (
	numero integer NOT NULL PRIMARY KEY,
	tipo character varying(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS clinivetschema.animais_servicos (
	numero_servico integer NOT NULL,
	id_animal integer NOT NULL,
	data_hora timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS clinivetschema.vacinas (
	nome_vacina character varying(255) NOT NULL,
	lugar_aplicacao character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE IF NOT EXISTS clinivetschema.injecoes (
	nome_injecao character varying(255) NOT NULL,
	local_aplicacao character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE IF NOT EXISTS clinivetschema.banhos (
	nome_produto character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE IF NOT EXISTS clinivetschema.tosas (
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE IF NOT EXISTS clinivetschema.cirurgias (
	nome character varying(255) NOT NULL,
	descricao character varying(255),
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE IF NOT EXISTS clinivetschema.relatorios (
	autor character varying(255) NOT NULL,
	assunto character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS clinivetschema.racas (
	descricao character varying(255),
	codigo integer NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS clinivetschema.especies (
	descricao character varying(255),
	codigo integer NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS clinivetschema.produtos (
	tipo character varying(255) NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS clinivetschema.venda (
	id_consulta integer NOT NULL,
	id_produto integer NOT NULL
);

ALTER TABLE ONLY clinivetschema.animais
	ADD CONSTRAINT animais_fk FOREIGN KEY (id_dono) REFERENCES clinivetschema.clientes(id);


