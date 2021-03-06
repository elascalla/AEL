﻿/** Tabela para registro de parametros do Sistema **/

DROP SEQUENCE S_TB_PARAMETRO;
CREATE SEQUENCE S_TB_PARAMETRO;

DROP TABLE TB_PARAMETRO;

CREATE TABLE TB_PARAMETRO(

	ID BIGINT PRIMARY KEY DEFAULT NEXTVAL('S_TB_PARAMETRO'),
	NOME VARCHAR(30),
	VALOR VARCHAR(300),
	DATA_PARAMETRO TIMESTAMP
);

DROP INDEX I_TB_PARAMETRO_NOME;
CREATE INDEX I_TB_PARAMETRO_NOME; ON TB_PARAMETRO(NOME);

SELECT *
FROM TB_PARAMETRO;

SELECT count(*) 
FROM TB_PARAMETRO;

DELETE FROM TB_PARAMETRO;

INSERT INTO TB_PARAMETRO(NOME, VALOR, DATA_PARAMETRO) 
	VALUES('EMAIL_FROM', 'totemsuporte@laulettaepereira.com.br', CURRENT_TIMESTAMP)
;

INSERT INTO TB_PARAMETRO(NOME, VALOR, DATA_PARAMETRO) 
	VALUES('EMAIL_TO', 'totemsuporte@laulettaepereira.com.br', CURRENT_TIMESTAMP)
;

INSERT INTO TB_PARAMETRO(NOME, VALOR, DATA_PARAMETRO) 
	VALUES('EMAIL_CC', 'andrevmdb@gmail.com,erick.lascalla@gmail.com,leandrohenrique.negri@gmail.com', CURRENT_TIMESTAMP)
;

INSERT INTO TB_PARAMETRO(NOME, VALOR, DATA_PARAMETRO) 
	VALUES('EMAIL_USERNAME', 'totemsuporte@laulettaepereira.com.br', CURRENT_TIMESTAMP)
;

INSERT INTO TB_PARAMETRO(NOME, VALOR, DATA_PARAMETRO) 
	VALUES('EMAIL_PASSWORD', 'totem1234', CURRENT_TIMESTAMP)
;