ALTER TABLE tb_patient
    ADD is_active BIT(1) NULL;

UPDATE tb_patient
SET is_active = 1
WHERE is_active IS NULL;
ALTER TABLE tb_patient
    MODIFY is_active BIT(1) NOT NULL;