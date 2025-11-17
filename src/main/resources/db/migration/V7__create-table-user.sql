CREATE TABLE tb_user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    login    VARCHAR(255)          NOT NULL,
    password VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_tb_user PRIMARY KEY (id)
);