create table author
(
    author_id   varchar(32)  not null
        primary key,
    create_date timestamp,
    first_name  varchar(255) not null,
    last_name   varchar(255) not null,
    male        boolean      not null
);


create table book
(
    book_id     varchar(32)  not null
        primary key,
    create_date timestamp,
    name        varchar(255) not null
);


create table author_book
(
    book_id   varchar(32) not null
        constraint fkioufdohwqqxemkciuruoq9269
            references author,
    author_id varchar(32) not null
        constraint fkssxqi6evp5gr92bik3qta3tgn
            references book
);