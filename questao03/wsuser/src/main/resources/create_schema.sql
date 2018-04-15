CREATE TABLE person (
	id serial primary key,
	nickname varchar(35) not null unique,
	pass varchar(20) not null
);