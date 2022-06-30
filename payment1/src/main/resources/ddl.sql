create table if not exists p3_sb_book
(
    id          bigint auto_increment
    primary key,
    author_name varchar(200) not null,
    author_uuid varchar(50)  not null,
    book_name   varchar(500) not null,
    book_uuid   varchar(50)  not null,
    stock       bigint       not null,
    constraint p3_sb_book_author_uuid_uindex
    unique (author_uuid),
    constraint p3_sb_book_book_uuid_uindex
    unique (book_uuid)
    );

create table if not exists sb_author
(
    id   bigint auto_increment
    primary key,
    name varchar(200) not null,
    uuid varchar(200) not null
    );

create table if not exists sb_books
(
    id        bigint auto_increment
    primary key,
    name      varchar(200)     not null,
    pages     int              not null,
    stock     bigint default 0 not null,
    uuid      varchar(50)      not null,
    author_id bigint default 0 not null
    );

create table if not exists sb_outbox
(
    id          bigint auto_increment
    primary key,
    uuid        varchar(100) not null,
    object_json text         not null
    );

create table if not exists st_sell
(
    id       bigint auto_increment
    primary key,
    book_id  varchar(100) not null,
    quantity int          not null,
    bought   datetime     not null
    );

