CREATE TABLE aluno(
	matricula BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL,
	nascimento DATE NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	senha VARCHAR(255) NOT NULL,
	telefone VARCHAR(50),
	imagem VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE professor(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL,
	disciplina VARCHAR(50) NOT NULL,
	nascimento DATE NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	senha VARCHAR(255) NOT NULL,
	telefone VARCHAR(50),
	imagem VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE aluno_permissao (
	codigo_aluno BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_aluno, codigo_permissao),
	FOREIGN KEY (codigo_aluno) REFERENCES aluno(matricula),
	FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE professor_permissao (
	codigo_professor BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_professor, codigo_permissao),
	FOREIGN KEY (codigo_professor) REFERENCES professor(id),
	FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE materia(
	materia VARCHAR(50) PRIMARY KEY
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE notas(
	nota1 float(10,2),
	nota2 float(10,2),
	nota3 float(10,2),
	nota4 float(10,2),
	media float(10,2),
	materia VARCHAR(50),
	aluno BIGINT(20),
	FOREIGN KEY(materia) REFERENCES materia(materia),
	FOREIGN KEY(aluno) REFERENCES aluno(matricula),
	PRIMARY KEY(materia,aluno)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE faltas(
	materia VARCHAR(50),
	aluno BIGINT(20),
	numero1 BIGINT(20),
	numero2 BIGINT(20),
	numero3 BIGINT(20),
	numero4 BIGINT(20),
	FOREIGN KEY(materia) REFERENCES materia(materia),
	FOREIGN KEY(aluno) REFERENCES aluno(matricula),
	PRIMARY KEY(materia,aluno)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;