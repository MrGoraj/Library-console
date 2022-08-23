--liquibase formatted sql
--changeset goraj:2
ALTER TABLE parent ADD reader_id int;
ALTER TABLE parent ADD FOREIGN KEY (reader_id) REFERENCES readers(reader_id) ON DELETE CASCADE;
ALTER TABLE child ADD reader_id int;
ALTER TABLE child ADD FOREIGN KEY (reader_id) REFERENCES readers(reader_id) ON DELETE CASCADE;
-- rollback ALTER TABLE parent DROP COLUMN reader_id CASCADE;
-- rollback ALTER TABLE child DROP COLUMN reader_id CASCADE;

