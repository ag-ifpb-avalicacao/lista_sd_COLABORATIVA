CREATE TABLE user (
    id serial primary key,
    nickname varchar(50) not null,
    pass varchar(30) not null
);