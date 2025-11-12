CREATE TABLE `tb_doctor` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `city` varchar(255) DEFAULT NULL,
                             `complement` varchar(255) DEFAULT NULL,
                             `neighborhood` varchar(255) DEFAULT NULL,
                             `number` varchar(255) DEFAULT NULL,
                             `state` varchar(255) DEFAULT NULL,
                             `street` varchar(255) DEFAULT NULL,
                             `zip` varchar(255) DEFAULT NULL,
                             `crm` varchar(255) NOT NULL,
                             `specialty` enum('CARDIOLOGIA','DERMATOLOGIA','GINECOLOGIA','ORTOPEDIA') DEFAULT NULL,
                             `email` varchar(255) NOT NULL,
                             `name` varchar(255) NOT NULL,
                             `phone` varchar(255) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;