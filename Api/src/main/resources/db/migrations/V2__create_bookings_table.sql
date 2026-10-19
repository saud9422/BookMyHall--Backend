-- V2__create_bookings_table.sql
-- Creates the bookings table required by the Booking entity

CREATE TABLE `bookings` (
    `booking_id` BIGINT NOT NULL AUTO_INCREMENT,
    `booking_name` VARCHAR(255) NOT NULL,
    `booking_type` VARCHAR(255) NOT NULL,
    `booking_date` DATE NOT NULL,
    `booking_start_time` TIME DEFAULT NULL,
    `booking_end_time` TIME DEFAULT NULL,
    `total_booking_hours` INT DEFAULT NULL,
    `booking_status` VARCHAR(255) NOT NULL,
    `total_amount` DECIMAL(10, 2) NOT NULL,
    `user_id` INT NOT NULL,
    `hall_id` BIGINT NOT NULL,
    `created_at` DATETIME(6) NOT NULL,
    `updated_at` DATETIME(6) DEFAULT NULL,
    PRIMARY KEY (`booking_id`),
    KEY `FK_bookings_user` (`user_id`),
    KEY `FK_bookings_hall` (`hall_id`),
    CONSTRAINT `FK_bookings_user`
        FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `FK_bookings_hall`
        FOREIGN KEY (`hall_id`) REFERENCES `halls` (`hall_id`)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;
