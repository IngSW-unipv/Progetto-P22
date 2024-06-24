drop schema if exists splash_db_test_creator;
create schema splash_db_test_creator;
use splash_db_test_creator;

drop table if exists users;
create table users
(id int primary key auto_increment,
email char (50) unique not null,
firstname char (30) not null,
secondname char (30) not null,
balance int not null default 0,
password char (20) not null
);

drop table if exists restaurants;
create table restaurants
(id int primary key auto_increment,
name char (40) not null,
address char (30) not null,
city char (30) not null,
balance int not null default 0,
email char (50) not null unique,
password char (20) not null
-- ,
-- imgname VARCHAR(255),
-- imgdata LONGBLOB
);

drop table if exists dishes;
create table dishes
(id int primary key auto_increment,
name char (40) not null,
avaibility int not null default 0,
prep_time int,
price int not null,
restaurant int not null,
foreign key (restaurant) references restaurants(id)
);
