CREATE TABLE person (
	id serial primary key,
	nickname varchar(35) not null unique,
	pass varchar(20) not null
);

CREATE TABLE message (
        id serial primary key,
        userOwner varchar(35) not null,
        content varchar(100) not null,
);
