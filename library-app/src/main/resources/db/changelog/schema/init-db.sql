--liquibase formatted sql
--changeset goraj:1
CREATE TABLE IF NOT EXISTS author
(
    author_id INT NOT NULL PRIMARY KEY,
    last_name VARCHAR(255),
    first_name VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS books
(
    book_id INT NOT NULL PRIMARY KEY,
    title VARCHAR(255),
    isbn VARCHAR(17)
    );

    CREATE TABLE IF NOT EXISTS readers
(
    reader_id INT NOT NULL PRIMARY KEY,
    last_name VARCHAR(255),
    first_name VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS loans
(
    loan_id INT NOT NULL PRIMARY KEY,
    loan_date DATE,
    reader_id INT,
    book_id INT,
    FOREIGN KEY (reader_id) REFERENCES readers (reader_id),
    FOREIGN KEY (book_id) REFERENCES books (book_id)
    );

CREATE TABLE IF NOT EXISTS child
(
    child_id INT NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS parent
(
    parent_id INT NOT NULL PRIMARY KEY,
    address VARCHAR(50),
    phone_number VARCHAR(9)
);
--rollback drop table author CASCADE;
--rollback drop table books CASCADE;
--rollback drop table readers CASCADE;
--rollback drop table loans CASCADE;
--rollback drop table child CASCADE;
--rollback drop table parent CASCADE;

--changeset goraj:2
ALTER TABLE parent
    ADD reader_id int;
ALTER TABLE parent
    ADD FOREIGN KEY (reader_id) REFERENCES readers (reader_id) ON DELETE CASCADE;
ALTER TABLE child
    ADD reader_id int;
ALTER TABLE child
    ADD FOREIGN KEY (reader_id) REFERENCES readers (reader_id) ON DELETE CASCADE;
-- rollback ALTER TABLE parent DROP COLUMN reader_id CASCADE;
-- rollback ALTER TABLE child DROP COLUMN reader_id CASCADE;

--changeset goraj:3
ALTER TABLE books
    ADD author_id int;
ALTER TABLE books
    ADD FOREIGN KEY (author_id) REFERENCES author (author_id) ON DELETE CASCADE;
-- rollback ALTER TABLE books DROP COLUMN author_id CASCADE;

--changeset goraj:4
ALTER TABLE child
    DROP COLUMN child_id CASCADE;
ALTER TABLE child
    ADD parent_id INT UNIQUE;
ALTER TABLE parent
    DROP COLUMN parent_id CASCADE;

BEGIN;
CREATE SCHEMA IF NOT EXISTS backup;
CREATE TABLE IF NOT EXISTS backup.readers_tmp
(
    LIKE readers INCLUDING ALL
);
INSERT INTO backup.readers_tmp
SELECT *
FROM readers;

CREATE TABLE IF NOT EXISTS backup.author_tmp
(
    LIKE author INCLUDING ALL
);
INSERT INTO backup.author_tmp
SELECT *
FROM author;

CREATE TABLE IF NOT EXISTS backup.books_tmp
(
    LIKE books INCLUDING ALL
);
INSERT INTO backup.books_tmp
SELECT *
FROM books;

CREATE TABLE IF NOT EXISTS backup.child_tmp
(
    LIKE child INCLUDING ALL
);
INSERT INTO backup.child_tmp
SELECT *
FROM child;

CREATE TABLE IF NOT EXISTS backup.loans_tmp
(
    LIKE loans INCLUDING ALL
);
INSERT INTO backup.loans_tmp
SELECT *
FROM loans;

CREATE TABLE IF NOT EXISTS backup.parent_tmp
(
    LIKE parent INCLUDING ALL
);
INSERT INTO backup.parent_tmp
SELECT *
FROM parent;
COMMIT;

BEGIN;
ALTER TABLE author DROP COLUMN author_id CASCADE;
ALTER TABLE author ADD COLUMN author_id SERIAL NOT NULL PRIMARY KEY UNIQUE;
INSERT INTO author ("last_name", "first_name", "author_id") SELECT last_name, first_name, CAST(author_id AS INTEGER) AS author_id FROM backup.author_tmp;

ALTER TABLE books DROP COLUMN book_id CASCADE;
ALTER TABLE books ADD COLUMN book_id SERIAL NOT NULL PRIMARY KEY UNIQUE;
INSERT INTO books (title, isbn, book_id) SELECT title, isbn, CAST(book_id AS INTEGER) AS book_id FROM backup.books_tmp;

ALTER TABLE loans DROP COLUMN loan_id CASCADE;
ALTER TABLE loans ADD COLUMN loan_id SERIAL NOT NULL PRIMARY KEY UNIQUE;
INSERT INTO loans (loan_date, reader_id, book_id, loan_id)  SELECT loan_date, reader_id, book_id, CAST(loan_id AS INTEGER) AS loan_id FROM backup.loans_tmp;

ALTER TABLE readers DROP COLUMN reader_id CASCADE;
ALTER TABLE readers ADD COLUMN reader_id SERIAL NOT NULL PRIMARY KEY UNIQUE;
INSERT INTO readers (last_name, first_name, reader_id) SELECT last_name, first_name, CAST(reader_id AS INTEGER) AS reader_id FROM backup.readers_tmp;
COMMIT;

--changeset goraj:5

ALTER TABLE books ADD COLUMN amount INT;
-- rollback ALTER TABLE books DROP COLUMN amount CASCADE;

--changeset goraj:6
ALTER TABLE loans ADD COLUMN return_date DATE;
-- rollback ALTER TABLE loans DROP COLUMN return_date CASCADE;