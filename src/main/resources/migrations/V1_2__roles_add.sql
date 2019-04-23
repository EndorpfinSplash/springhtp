create table roles
(
  role_id int(20) auto_increment primary key,
  role_name varchar(50) not null,
  role_user_id int(20) not null,
  constraint ROL_USR_FK
    foreign key (role_user_id) references user (user_id)
      on delete cascade
)
  charset=utf8;

alter table user
  add login varchar(100) not null;

alter table user
  add password varchar(100) not null;

create unique index user_login_uindex
  on user (login);