create table if not exists pessoa(
	id serial primary key,
	nome varchar(255) not null,
	tipo_documento varchar(255) not null, 	
	documento varchar(255) not null,
	renda_comprometida numeric(15,5) not null default 0
);

create table if not exists pessoa_socio(
	pessoa_id int not null,
	socio_id int not null
);

create table if not exists socio(
	id serial primary key,
	pessoa_id int not null
);

alter table pessoa_socio add constraint sociedade_pk primary key (pessoa_id, socio_id);
alter table pessoa_socio add constraint pessoa_fk foreign key (pessoa_id) references pessoa(id);
alter table pessoa_socio add constraint socio_fk foreign key (socio_id) references socio(id);
alter table socio add constraint pessoa_fk foreign key (pessoa_id) references pessoa(id);

insert into pessoa
(nome, tipo_documento, documento, renda_comprometida)
values('montreal', 'CNPJ', '50254026000134', '44.30');

insert into pessoa
(nome, tipo_documento, documento, renda_comprometida)
values('coca-cola', 'CNPJ', '28621394000114', '44.30');

insert into socio
(pessoa_id)
values(1);

insert into socio
(pessoa_id)
values(2);

INSERT INTO pessoa_socio
(pessoa_id, socio_id)
VALUES(1, 2);

INSERT INTO pessoa_socio
(pessoa_id, socio_id)
VALUES(2, 1);

