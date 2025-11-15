ALTER TABLE tb_doctor
    ADD is_active BIT(1) NULL;

UPDATE tb_doctor
SET is_active = 1
WHERE is_active IS NULL;
ALTER TABLE tb_doctor
    MODIFY is_active BIT(1) NOT NULL;