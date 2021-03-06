﻿/** Tabela para registro das falhas do projetos: TotemDesktop | TotemServidor **/

DROP SEQUENCE S_TB_FALHA;
CREATE SEQUENCE S_TB_FALHA;

DROP TABLE TB_FALHA;

CREATE TABLE TB_FALHA (

	ID BIGINT PRIMARY KEY DEFAULT NEXTVAL('S_TB_FALHA'),
	CHAVE VARCHAR(500),
	MENSAGEM VARCHAR(500),
	STACK_TRACE VARCHAR(3000),
	DATA_FALHA TIMESTAMP
);

DROP INDEX I_TB_FALHA_ID_DATA_FALHA;
CREATE INDEX I_TB_FALHA_ID_DATA_FALHA ON TB_FALHA(ID, DATA_FALHA);

DROP INDEX I_TB_FALHA_CHAVE;
CREATE INDEX I_TB_FALHA_CHAVE ON TB_FALHA(CHAVE);

SELECT *
FROM TB_FALHA
;

DELETE FROM TB_FALHA;