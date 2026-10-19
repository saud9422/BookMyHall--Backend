
-- V1__baseline_schema.sql
-- Initial schema for BookMyHall

-- 1. USER TABLE
CREATE TABLE `user` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `address` VARCHAR(255) DEFAULT NULL,
                        `created_on` DATETIME(6) DEFAULT NULL,
                        `email` VARCHAR(255) DEFAULT NULL,
                        `is_active` BIT(1) NOT NULL,
                        `name` VARCHAR(255) DEFAULT NULL,
                        `password` VARCHAR(255) DEFAULT NULL,
                        `phone` VARCHAR(255) DEFAULT NULL,
                        `role` TINYINT DEFAULT NULL,
                        `updated_on` DATETIME(6) DEFAULT NULL,
                        `gender` TINYINT DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;


-- 2. HALLS TABLE
CREATE TABLE `halls` (
                         `hall_id` BIGINT NOT NULL AUTO_INCREMENT,
                         `capacity` BIGINT DEFAULT NULL,
                         `created` DATETIME(6) DEFAULT NULL,
                         `description` VARCHAR(150) DEFAULT NULL,
                         `halltype` TINYINT DEFAULT NULL,
                         `location` VARCHAR(255) DEFAULT NULL,
                         `hall_name` VARCHAR(150) NOT NULL,
                         `price_per_day` BIGINT DEFAULT NULL,
                         `price_per_hour` BIGINT DEFAULT NULL,
                         `updated` DATETIME(6) DEFAULT NULL,
                         `user_id` INT DEFAULT NULL,
                         PRIMARY KEY (`hall_id`),
                         KEY `FKhc0dxnibww1xwsve440r9o0r0` (`user_id`),
                         CONSTRAINT `FKhc0dxnibww1xwsve440r9o0r0`
                             FOREIGN KEY (`user_id`)
                                 REFERENCES `user` (`id`),
                         CONSTRAINT `halls_chk_1`
                             CHECK (`halltype` BETWEEN 0 AND 8)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;


-- 3. HALL IMAGES TABLE
CREATE TABLE `hall_images` (
                               `id` BIGINT NOT NULL AUTO_INCREMENT,
                               `image_data` LONGBLOB,
                               `hall_id` BIGINT NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `FKp64nope3qfmfgdr9w0qbf5e94` (`hall_id`),
                               CONSTRAINT `FKp64nope3qfmfgdr9w0qbf5e94`
                                   FOREIGN KEY (`hall_id`)
                                       REFERENCES `halls` (`hall_id`)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;
