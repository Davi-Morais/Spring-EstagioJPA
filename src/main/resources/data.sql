INSERT INTO tb_usuario (first_name, last_name, email, password) VALUES ('Fufu', 'Brown', 'fufu@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario (first_name, last_name, email, password) VALUES ('Maria', 'Joana', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario (first_name, last_name, email, password) VALUES ('Bruno', 'Rodrigues', 'brunorodrigues@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (1, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 2);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (3, 2);




INSERT INTO tb_aluno (nome, email, idade, genero) VALUES ('Jolyne', 'jolyne@gmail.com', 20, 'M');
INSERT INTO tb_aluno (nome, email, idade, genero) VALUES ('Gabriela', 'gabriela@gmail.com', 22, 'F');
INSERT INTO tb_aluno (nome, email, idade, genero) VALUES ('Hugo', 'hugo@gmail.com', 27, 'M');
INSERT INTO tb_aluno (nome, email, idade, genero) VALUES ('Jose', 'jose@gmail.com', 30, 'M');
INSERT INTO tb_aluno (nome, email, idade, genero) VALUES ('Marcos', 'marcos@gmail.com', 30, 'M');



INSERT INTO tb_orientador (nome, email) VALUES ('Rafael', 'rafael@gmail.com');
INSERT INTO tb_orientador (nome, email) VALUES ('Joana', 'joana@gmail.com');
INSERT INTO tb_orientador (nome, email) VALUES ('Angelo', 'angelo@gmail.com');


/* INSERT INTO tb_orientador_aluno (orientador_id, aluno_id) VALUES (1, 1);
INSERT INTO tb_orientador_aluno (orientador_id, aluno_id) VALUES (1, 2);
INSERT INTO tb_orientador_aluno (orientador_id, aluno_id) VALUES (2, 3);
INSERT INTO tb_orientador_aluno (orientador_id, aluno_id) VALUES (2, 4); */



INSERT INTO tb_empresa (nome, cnpj) VALUES ('Empresa Boa', '98798798711');
INSERT INTO tb_empresa (nome, cnpj) VALUES ('Tech Rapida!', '12312312355');
INSERT INTO tb_empresa (nome, cnpj) VALUES ('Trabalho facil!', '12312312775');


/* INSERT INTO tb_empresa_aluno (empresa_id, aluno_id) VALUES (1, 1);
INSERT INTO tb_empresa_aluno (empresa_id, aluno_id) VALUES (1, 2);
INSERT INTO tb_empresa_aluno (empresa_id, aluno_id) VALUES (2, 3);
INSERT INTO tb_empresa_aluno (empresa_id, aluno_id) VALUES (2, 4); */



/* INSERT INTO tb_estagio (inicio_estagio, fim_estagio, carga_horaria, status, aluno_id, orientador_id, empresa_id)
                VALUES ('22/12/2023', '24/03/2024', 50, 'em andamento', 1, 1, 1);
INSERT INTO tb_estagio (inicio_estagio, fim_estagio, carga_horaria, status, aluno_id, orientador_id, empresa_id)
                VALUES ('26/09/2021', '26/03/2022', 70, 'finalizado', 2, 1, 1);
INSERT INTO tb_estagio (inicio_estagio, fim_estagio, carga_horaria, status, aluno_id, orientador_id, empresa_id)
                VALUES ('12/04/2022', '20/01/2023', 40, 'em andamento', 3, 2, 2);
INSERT INTO tb_estagio (inicio_estagio, fim_estagio, carga_horaria, status, aluno_id, orientador_id, empresa_id)
                VALUES ('19/06/2020', '23/02/2021', 100, 'finalizado', 4, 2, 2); */



    /*  Opcoes de resposta: 
	*  - insuficiente
     *  - regular
     *  - bom
     *  - muito bom 
     */

/* INSERT INTO tb_avaliacao_do_professor (assiduidade, disciplina, sociabilidade, responsabilidade, iniciativa, aluno_id, orientador_id)
                VALUES ('insuficiente', 'regular', 'regular', 'bom', 'muito bom', 1, 1);
INSERT INTO tb_avaliacao_do_professor (assiduidade, disciplina, sociabilidade, responsabilidade, iniciativa, aluno_id, orientador_id)
                VALUES ('muito bom', 'insuficiente', 'muito bom', 'bom', 'regular', 2, 1);
INSERT INTO tb_avaliacao_do_professor (assiduidade, disciplina, sociabilidade, responsabilidade, iniciativa, aluno_id, orientador_id)
                VALUES ('regular', 'insuficiente', 'bom', 'regular', 'muito bom', 3, 2);
INSERT INTO tb_avaliacao_do_professor (assiduidade, disciplina, sociabilidade, responsabilidade, iniciativa, aluno_id, orientador_id)
                VALUES ('regular', 'bom', 'bom', 'regular', 'bom', 4, 2); */


/* INSERT INTO tb_avaliacao_da_empresa (rendimento, conhecimentos, cumprimentos, aprendizagem, desempenho, aluno_id, empresa_id)
                VALUES ('bom', 'muito bom', 'regular', 'muito bom', 'insuficiente', 1, 1);
INSERT INTO tb_avaliacao_da_empresa (rendimento, conhecimentos, cumprimentos, aprendizagem, desempenho, aluno_id, empresa_id)
                VALUES ('muito bom', 'regular', 'bom', 'bom', 'regular', 2, 1);
INSERT INTO tb_avaliacao_da_empresa (rendimento, conhecimentos, cumprimentos, aprendizagem, desempenho, aluno_id, empresa_id)
                VALUES ('muito bom', 'regular', 'muito bom', 'regular', 'insuficiente', 3, 2);
INSERT INTO tb_avaliacao_da_empresa (rendimento, conhecimentos, cumprimentos, aprendizagem, desempenho, aluno_id, empresa_id)
                VALUES ('bom', 'muito bom', 'regular', 'muito bom', 'insuficiente', 4, 2); */