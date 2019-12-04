-- CREATE DATABASE IF NOT EXISTS clinivet;
-- CREATE SCHEMA clinivetschema;
-- SET search_path='clinivetschema';

CREATE TABLE clinivetschema.administradores (
	nome character varying(255) NOT NULL,
	endereco character varying(255)  NOT NULL,
	cidade character varying(255)  NOT NULL,
	estado character varying(255)  NOT NULL,
	telefone_residencial character varying(255),
	telefone_celular character varying(255) NOT NULL,
	email character varying(255) NOT NULL,
	cpf character varying(255) NOT NULL,
	matricula SERIAL NOT NULL PRIMARY KEY,
	tipo_permissao character varying(255) NOT NULL,
	data_contratacao timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE clinivetschema.funcionarios (
	nome character varying(255) NOT NULL,
	endereco character varying(255)  NOT NULL,
	cidade character varying(255)  NOT NULL,
	estado character varying(255)  NOT NULL,
	telefone_residencial character varying(255),
	telefone_celular character varying(255) NOT NULL,
	email character varying(255) NOT NULL,
	cpf character varying(255) NOT NULL,
	matricula SERIAL NOT NULL PRIMARY KEY,
	tipo_permissao character varying(255) NOT NULL,
	data_contratacao timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE clinivetschema.veterinarios (
	nome character varying(255) NOT NULL,
	endereco character varying(255)  NOT NULL,
	cidade character varying(255)  NOT NULL,
	estado character varying(255)  NOT NULL,
	telefone_residencial character varying(255),
	telefone_celular character varying(255) NOT NULL,
	email character varying(255) NOT NULL,
	cpf character varying(255) NOT NULL,
	matricula SERIAL NOT NULL PRIMARY KEY,
	crmv integer NOT NULL,
	tipo_permissao character varying(255) NOT NULL,
	data_contratacao timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE clinivetschema.animais (
	nome character varying(255),
	sexo varchar(1) NOT NULL,
	cor character varying(255),
	id_especie integer NOT NULL,
	id_raca integer NOT NULL,
	data_nascimento timestamp,
	id_dono integer NOT NULL NOT NULL,
	codigo SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE clinivetschema.clientes (
	nome character varying(255) NOT NULL,
	documento integer NOT NULL UNIQUE,
	endereco character varying(255)  NOT NULL,
	cidade character varying(255)  NOT NULL,
	estado character varying(255)  NOT NULL,
	telefone character varying(255)  NOT NULL,
	email character varying(255)  NOT NULL,
	cpf integer NOT NULL PRIMARY KEY
);

CREATE TABLE clinivetschema.consultas (
	tipo character varying(255) NOT NULL,
	data_hora timestamp DEFAULT CURRENT_TIMESTAMP,
	id SERIAL NOT NULL PRIMARY KEY,
	id_animal integer NOT NULL,
	id_dono integer,
	sintomas character varying(255),
	forma_pagamento character varying(255) NOT NULL,
	id_veterinario integer NOT NULL
);

CREATE TABLE clinivetschema.pagamentos (
	pagante integer NOT NULL,
	tipo character varying(255) NOT NULL,
	valor numeric(10,2) NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE clinivetschema.pedidos (
	tipo character varying(255) NOT NULL,
	data_hora timestamp DEFAULT CURRENT_TIMESTAMP,
	id SERIAL NOT NULL PRIMARY KEY,
	id_procedimento integer NOT NULL
);

CREATE TABLE clinivetschema.procedimentos (
	tipo character varying(255) NOT NULL,
	data_hora timestamp DEFAULT CURRENT_TIMESTAMP,
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
	forma_pagamento character varying(255) NOT NULL,
	id_animal integer NOT NULL,
	responsavel integer
);

CREATE TABLE clinivetschema.injecoes (
	nome_injecao character varying(255) NOT NULL,
	local_aplicacao character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	forma_pagamento character varying(255) NOT NULL,
	id_animal integer NOT NULL,
	responsavel integer
);

CREATE TABLE clinivetschema.banhos (
	nome_produto character varying(255) NOT NULL,
	data_hora timestamp NOT NULL,
	id SERIAL NOT NULL PRIMARY KEY,
	forma_pagamento character varying(255) NOT NULL,
	id_animal integer NOT NULL,
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
	forma_pagamento character varying(255) NOT NULL,
	id_animal integer NOT NULL,
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

CREATE TABLE clinivetschema.matricula (
	cpf integer NOT NULL PRIMARY KEY,
	senha character varying(255) NOT NULL
);

ALTER TABLE ONLY clinivetschema.animais
ADD CONSTRAINT animais_fk FOREIGN KEY (id_dono)
REFERENCES clinivetschema.clientes(cpf);

ALTER TABLE ONLY clinivetschema.consultas
ADD CONSTRAINT consulta_veterinario_fk FOREIGN KEY (id_veterinario)
REFERENCES clinivetschema.veterinarios(matricula);

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

CREATE FUNCTION clinivetschema.consulta_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('consulta', NEW.data_hora, NEW.id_veterinario);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER consulta_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.consultas
FOR EACH ROW EXECUTE PROCEDURE clinivetschema.consulta_procedimento();

-- Funcao e trigger de vacina para procedimento

CREATE FUNCTION clinivetschema.vacina_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('vacina', NEW.data_hora, NEW.responsavel);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER vacina_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.vacinas
FOR EACH ROW EXECUTE PROCEDURE clinivetschema.vacina_procedimento();

-- Funcao e trigger de injecao para procedimento

CREATE FUNCTION clinivetschema.injecao_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('injecao', NEW.data_hora, NEW.responsavel);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER injecao_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.injecoes
FOR EACH ROW EXECUTE PROCEDURE clinivetschema.injecao_procedimento();

-- Funcao e trigger de banho para procedimento

CREATE FUNCTION clinivetschema.banho_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('banho', NEW.data_hora, NEW.responsavel);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER banho_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.banhos
FOR EACH ROW EXECUTE PROCEDURE clinivetschema.banho_procedimento();

-- Funcao e trigger de tosa para procedimento

CREATE FUNCTION clinivetschema.tosa_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('tosa', NEW.data_hora, NEW.responsavel);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER tosa_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.tosas
FOR EACH ROW EXECUTE PROCEDURE clinivetschema.tosa_procedimento();

-- Funcao e trigger de cirurgia para procedimento

CREATE FUNCTION clinivetschema.cirurgia_procedimento()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO clinivetschema.procedimentos
	VALUES ('cirurgia', NEW.data_hora, NEW.responsavel);
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER cirurgia_procedimento
AFTER INSERT OR UPDATE OF id ON clinivetschema.cirurgias
FOR EACH ROW EXECUTE PROCEDURE clinivetschema.cirurgia_procedimento();

-- SELECT to_char(CURRENT_TIMESTAMP, 'YYYY-MM-DD - HH:MI:SS');

INSERT INTO clinivetschema.funcionarios VALUES 
('Joao da Silva', 'Rua das Graças, 12', 'Campo-Grande', 'MS', '77889944', '33225518', 'joao.silva@email.com', '35124512784', 11112222, 'usuario'),
('Maria Ines', 'Av. Sen. Calarge, 354, ap. 302', 'Campo-Grande', 'MS', '24159378', '20157409', 'maria.ines@email.com', '25124512784', 22223333, 'usuario'),
('Roberto Ishii', 'Rua Flores Belas, 456', 'Campo-Grande', 'MS', '84527845', '33224578', 'roberto.ishii@email.com', '15124512784', 33334444, 'veterinario'),
('Karina Pereira', 'Av. Espirito Santo, 9893', 'Campo-Grande', 'MS', '78786545', '12657899', 'karina.pereira@email.com', '45124512784', 44445555, 'veterinario'),
('Sergio Gimenez', 'Rua Dolores Duran, 1532, casa 4', 'Campo-Grande', 'MS', '33881732', '91574402', 'sergiogimenez@email.com', '55124512784', 55556666, 'administrador'),
('Flavia Paes', 'Av Gal Osorio, 4571', 'Campo-Grande', 'MS', '31205780', '20452105', 'flavia.paes@email.com', '65124512784', 66667777, 'administrador');

INSERT INTO clinivetschema.administradores VALUES 
('Sergio Gimenez', 'Rua Dolores Duran, 1532, casa 4', 'Campo-Grande', 'MS', '33881732', '91574402', 'sergiogimenez@email.com', '55124512784', 55556666, 'administrador'),
('Flavia Paes', 'Av Gal Osorio, 4571', 'Campo-Grande', 'MS', '31205780', '20452105', 'flavia.paes@email.com', '65124512784', 66667777, 'administrador');

INSERT INTO clinivetschema.veterinarios VALUES 
('Roberto Ishii', 'Rua Flores Belas, 456', 'Campo-Grande', 'MS', '84527845', '33224578', 'roberto.ishii@email.com', '15124512784', 33334444, 6458, 'veterinario'),
('Karina Pereira', 'Av. Espirito Santo, 9893', 'Campo-Grande', 'MS', '78786545', '12657899', 'karina.pereira@email.com', '45124512784', 44445555, 2548, 'veterinario');

INSERT INTO clinivetschema.especies VALUES
('Cachorro', 1),
('Gato', 2),
('Passaro', 3),
('Outros', 4);

INSERT INTO clinivetschema.racas VALUES
('Pastor alemão', 2457),
('Frajola', 2040),
('Bull dog', 7815),
('Vira-lata', 1111);

INSERT into clinivetschema.clientes VALUES
('Patricia Matsunaga', 21548754, 'Rua das Palavras, 32', 'Campo Grande', 'MS', '97976565', 'patriciamatsu@email.com', 2157850),
('Ricardo Alelo', 87521352, 'Av. Pombal', 'Campo Grande', 'MS', '54542222', 'ricardo.alelo@email.com', 4531826);

INSERT INTO clinivetschema.animais (nome, sexo, cor, id_especie, id_raca, id_dono, codigo)
VALUES
('Bilu', 'F', 'Marrom', 1, 2457, 2157850, 1563),
('Mel', 'F', 'Frajola', 2, 2040, 4531826, 3515);