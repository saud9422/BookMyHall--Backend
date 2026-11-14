-- V3__align_bookings_table_with_entity.sql
-- Brings the `bookings` table back in sync with the Booking entity:
--   1. Adds the date-range columns the entity maps (bookingStartDate / bookingEndDate)
--   2. Drops booking_name, which no Java field maps to
--   3. Relaxes booking_date to nullable, because neither the "by day" nor the
--      "by hour" booking flow ever populates it

ALTER TABLE `bookings`
    ADD COLUMN `booking_start_date` DATE DEFAULT NULL AFTER `booking_type`,
    ADD COLUMN `booking_end_date` DATE DEFAULT NULL AFTER `booking_start_date`,
    DROP COLUMN `booking_name`,
    MODIFY COLUMN `booking_date` DATE DEFAULT NULL;
