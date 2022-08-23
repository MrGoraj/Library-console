--liquibase formatted sql
--changeset goraj:1
CREATE TABLE IF NOT EXISTS author (
    author_id INT NOT NULL PRIMARY KEY,
    last_name VARCHAR(255),
    first_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS books (
    book_id INT NOT NULL PRIMARY KEY,
    title VARCHAR(255),
    isbn VARCHAR(17)
);

CREATE TABLE IF NOT EXISTS readers (
   reader_id INT NOT NULL PRIMARY KEY,
   last_name VARCHAR(255),
   first_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS loans (
    loan_id INT NOT NULL PRIMARY KEY,
    loan_date DATE,
    reader_id INT,
    book_id INT,
    FOREIGN KEY(reader_id) REFERENCES readers(reader_id),
    FOREIGN KEY(book_id) REFERENCES books(book_id)
);

CREATE TABLE IF NOT EXISTS child (
    child_id INT NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS parent (
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