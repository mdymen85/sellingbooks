CREATE DATABASE payments1;

USE payments1;

create table sb_author (
    id bigint auto_increment,
    name varchar(255),
    uuid decimal(40,0),
    primary key (id)
);

create table sb_author_books (
    author_entity_id bigint not null,
    books_id bigint not null,
    primary key (author_entity_id, books_id)
);

create table sb_books (
    id bigint auto_increment,
    name varchar(255),
    pages integer not null,
    uuid decimal(40,0),
    primary key (id)
);

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'mdymen_pass';

-- docker run --name payments1-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mdymen_pass -d mysql:latest
-- docker exec -i payments1-mysql sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < data.sql
