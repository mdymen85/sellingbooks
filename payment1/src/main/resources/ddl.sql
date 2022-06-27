-- auto-generated definition
create schema payments1 collate utf8mb4_0900_ai_ci;

-- auto-generated definition
create table sb_author
(
    id       bigint auto_increment primary key,
    name     varchar(200)     not null,
    uuid     varchar(200)     not null,
    quantity bigint default 0 not null
);


-- auto-generated definition
create table sb_outbox
(
    id         bigint auto_increment primary key,
    uuid       varchar(100) not null,
    objectJson varchar(100) not null
);