-- CREATE DATABASE IF NOT EXISTS clinivet;
-- CREATE SCHEMA clinivetschema;
-- SET search_path='clinivetschema';

CREATE TABLE clinivetschema.administradores (
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

CREATE TABLE clinivetschema.funcionarios (
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

CREATE TABLE clinivetschema.veterinarios (
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

CREATE TABLE clinivetschema.animais (
	nome character varying(255) NOT NULL,
	sexo character(1) NOT NULL,
	cor character varying(255) NOT NULL,
	id_especie integer,
	id_raca integer,
	id_dono integer NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,

    CONSTRAINT animal_sexo_check CHECK ((sexo = ANY (ARRAY['F'::bpchar, 'M'::bpchar])))
);

CREATE TABLE clinivetschema.clientes (
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

CREATE TABLE clinivetschema.consultas (
	tipo character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	id_animal integer NOT NULL,
	id_veterinario integer NOT NULL
);

CREATE TABLE clinivetschema.documentos (
	caminho_arquivo character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE clinivetschema.pagamentos (
	pagante integer NOT NULL,
	tipo character varying(255) NOT NULL,
	valor numeric(10,2) NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE clinivetschema.pedidos (
	tipo character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	id_procedimento integer NOT NULL
);

CREATE TABLE clinivetschema.procedimentos (
	tipo character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE clinivetschema.servicos (
	numero integer NOT NULL PRIMARY KEY,
	tipo character varying(255) NOT NULL
);

CREATE TABLE clinivetschema.animais_servicos (
	numero_servico integer NOT NULL,
	id_animal integer NOT NULL,
	data_hora timestamp NOT NULL
);

CREATE TABLE clinivetschema.vacinas (
	nome_vacina character varying(255) NOT NULL,
	lugar_aplicacao character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE clinivetschema.injecoes (
	nome_injecao character varying(255) NOT NULL,
	local_aplicacao character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE clinivetschema.banhos (
	nome_produto character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE clinivetschema.tosas (
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE clinivetschema.cirurgias (
	nome character varying(255) NOT NULL,
	descricao character varying(255),
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	responsavel integer
);

CREATE TABLE clinivetschema.relatorios (
	autor character varying(255) NOT NULL,
	assunto character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE clinivetschema.racas (
	descricao character varying(255),
	codigo integer NOT NULL PRIMARY KEY
);

CREATE TABLE clinivetschema.especies (
	descricao character varying(255),
	codigo integer NOT NULL PRIMARY KEY
);

CREATE TABLE clinivetschema.produtos (
	tipo character varying(255) NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE clinivetschema.vendas (
	id_consulta integer NOT NULL,
	id_produto integer NOT NULL
);

ALTER TABLE ONLY clinivetschema.animais
ADD CONSTRAINT animais_fk FOREIGN KEY (id_dono)
REFERENCES clinivetschema.clientes(id);

ALTER TABLE ONLY clinivetschema.consultas
ADD CONSTRAINT consulta_veterinario_fk FOREIGN KEY (id_veterinario)
REFERENCES clinivetschema.veterinarios(id);

ALTER TABLE ONLY clinivetschema.consultas
ADD CONSTRAINT animais_consulta_fk FOREIGN KEY (id_animal)
REFERENCES clinivetschema.consultas(id);

ALTER TABLE ONLY clinivetschema.animais
ADD CONSTRAINT animais_especie_fk FOREIGN KEY (id_especie)
REFERENCES clinivetschema.especies(codigo);

ALTER TABLE ONLY clinivetschema.animais
ADD CONSTRAINT animais_raca_fk FOREIGN KEY (id_raca)
REFERENCES clinivetschema.racas(codigo);

ALTER TABLE ONLY clinivetschema.pedidos
ADD CONSTRAINT pedido_fk FOREIGN KEY (id_procedimento)
REFERENCES clinivetschema.procedimentos(id);

ALTER TABLE ONLY clinivetschema.animais_servicos
ADD PRIMARY KEY (id_animal, numero_servico);

ALTER TABLE ONLY clinivetschema.vendas
ADD PRIMARY KEY (id_consulta, id_produto);

-- Funcao e trigger de consulta para procedimento

CREATE FUNCTION consulta_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('consulta', NEW.data_hora, NEW.id_veterinario);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER consulta_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.consultas
FOR EACH ROW EXECUTE PROCEDURE consulta_procedimento();

-- Funcao e trigger de vacina para procedimento

CREATE FUNCTION vacina_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('vacina', NEW.data_hora, NEW.responsavel);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER vacina_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.vacinas
FOR EACH ROW EXECUTE PROCEDURE vacina_procedimento();

-- Funcao e trigger de injecao para procedimento

CREATE FUNCTION injecao_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('injecao', NEW.data_hora, NEW.responsavel);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER injecao_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.injecoes
FOR EACH ROW EXECUTE PROCEDURE injecao_procedimento();

-- Funcao e trigger de banho para procedimento

CREATE FUNCTION banho_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('banho', NEW.data_hora, NEW.responsavel);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER banho_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.banhos
FOR EACH ROW EXECUTE PROCEDURE banho_procedimento();

-- Funcao e trigger de tosa para procedimento

CREATE FUNCTION tosa_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('tosa', NEW.data_hora, NEW.responsavel);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER tosa_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.tosas
FOR EACH ROW EXECUTE PROCEDURE tosa_procedimento();

-- Funcao e trigger de cirurgia para procedimento

CREATE FUNCTION cirurgia_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('cirurgia', NEW.data_hora, NEW.responsavel);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER cirurgia_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.cirurgias
FOR EACH ROW EXECUTE PROCEDURE cirurgia();


-- SELECT to_char(CURRENT_TIMESTAMP, 'YYYY-MM-DD - HH:MI:SS');