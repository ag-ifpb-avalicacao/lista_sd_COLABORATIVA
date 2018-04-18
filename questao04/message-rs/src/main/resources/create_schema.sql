CREATE TABLE message (
    id serial primary key,
    userOwner varchar(30) not null,
    content varchar(50) not null
);