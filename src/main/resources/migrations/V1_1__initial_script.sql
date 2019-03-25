create table user
(
	user_id int auto_increment,
	user_name varchar(100) not null,
	user_surname varchar(100) not null,
	birth_date timestamp(6) null,
	constraint user_pk
		primary key (user_id)
);

create table department
(
	dep_id int auto_increment,
	dep_name varchar(100) not null,
	dep_capacity int not null,
	constraint department_pk
		primary key (dep_id)
);

create table factory
(
	factory_id int auto_increment,
	factory_name varchar(100) not null,
	factory_open_year date not null,
	constraint factory_pk
		primary key (factory_id)
);

alter table department
	add factory_id int not null;

alter table department
	add constraint department_factory_factory_id_fk
		foreign key (factory_id) references factory (factory_id)
			on update cascade on delete cascade;

alter table user
	add dep_id int not null;

alter table user
	add constraint user_department_dep_id_fk
		foreign key (dep_id) references department (dep_id)
			on update cascade on delete cascade;

create index user_user_name_index
	on user (user_name);
;
CREATE DEFINER=`root`@`localhost`
FUNCTION `get_user_factory_by_id`(id integer)
RETURNS varchar(100) CHARSET utf8mb4
BEGIN
DECLARE result VARCHAR(100);
select max(f.factory_name) as factory_name
into result
  from user u
  join department d on d.dep_id = u.dep_id
  join factory f on f.factory_id = d.factory_id
 where user_id = id;

RETURN result;
END