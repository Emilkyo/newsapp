drop table if exists users cascade;
create table users
(
    id       bigserial not null,
    password varchar(255),
    username varchar(255),
    primary key (id)
)