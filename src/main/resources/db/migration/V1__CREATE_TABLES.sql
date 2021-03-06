CREATE TABLE public.users (
	id BIGINT not null PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
	password varchar(64) not null,
	username varchar(64) not null unique
);

CREATE TABLE todo (
	id BIGINT not null PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
	title varchar(64) not null,
	completed BOOLEAN not null
);