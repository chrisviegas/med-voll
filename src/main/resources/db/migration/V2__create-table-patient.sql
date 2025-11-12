CREATE TABLE tb_patient
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    name         VARCHAR(255)          NOT NULL,
    email        VARCHAR(255)          NOT NULL,
    phone        VARCHAR(255)          NOT NULL,
    cpf          VARCHAR(255)          NOT NULL,
    street       VARCHAR(255)          NULL,
    number       VARCHAR(255)          NULL,
    complement   VARCHAR(255)          NULL,
    neighborhood VARCHAR(255)          NULL,
    city         VARCHAR(255)          NULL,
    state        VARCHAR(255)          NULL,
    zip          VARCHAR(255)          NULL,
    CONSTRAINT pk_tb_patient PRIMARY KEY (id)
);