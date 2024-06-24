use splash_db_test_creator;

-- inserimento utenti
insert into users (firstname,secondname,email,password)
values ('Mario','Verdi','mario.verdi@gmail.com','qwerty');
insert into users (firstname,secondname,email,password)
values ('Mario','Bianchi','mario.bianchi@gmail.com','qwerty');
insert into users (firstname,secondname,email,password)
values ('Giulia','Rossi','giulia.rossi@gmail.com','qwerty');
insert into users (firstname,secondname,email,password)
values ('Giulia','Verdi','giulia.verdi@gmail.com','qwerty');
insert into users (firstname,secondname,email,password)
values ('Giulia','Bianchi','giulia.bianchi@gmail.com','qwerty');

-- inserimento ristoranti
insert into restaurants (name,address,city,email,password
-- ,imgname,imgdata
)
values ('Pizzeria da Michele','Via Roma 3','Pavia','pizzeria_da_michele@gmail.com','qwerty'
-- ,'pizza.jpg', LOAD_FILE ('/usr/local/mysql-8.0.29-macos12-arm64/data/splash/pizza.jpg')
);
insert into restaurants (name,address,city,email,password)
values ('Moya','Via Mazzini 37','Pavia','moya@gmail.com','qwerty');
insert into restaurants (name,address,city,email,password)
values ('Trattoria della Nonna','Piazza Verdi 1','Milano','trattoria_della_nonna@gmail.com','qwerty');
insert into restaurants (name,address,city,email,password)
values ('Iyo','Via Dante 47','Milano','iyo@gmail.com','qwerty');
insert into restaurants (name,address,city,email,password)
values ('Trattoria del porto','Vico vecchio 5','Genova','trattoria_del_porto@gmail.com','qwerty');
insert into restaurants (name,address,city,email,password)
values ('Il pescatore','Via Roma 5','Genova','il_pescatore@gmail.com','qwerty');
insert into restaurants (name,address,city,email,password)
values ('Pizzeria da Michele','Piazza Principe 3','Genova','pizzeria_da_michele1@gmail.com','qwerty');

insert into dishes (name,price,prep_time,restaurant)
values ('Pizza Margherita','6','5','1');
insert into dishes (name,price,prep_time,restaurant)
values ('Pizza Capricciosa','9','7','1');
insert into dishes (name,price,prep_time,restaurant)
values ('Pizza Diavola','7','6','1');

insert into dishes (name,price,prep_time,restaurant)
values ('Uramaki salmone e avocado','8','5','2');
insert into dishes (name,price,prep_time,restaurant)
values ('Nighiri salmone','4','2','2');
insert into dishes (name,price,prep_time,restaurant)
values ('Nighiri branzino','4','2','2');

insert into dishes (name,price,prep_time,restaurant)
values ('Risotto alla milanese','12','23','3');
insert into dishes (name,price,prep_time,restaurant)
values ('Cotoletta alla milanese','18','20','3');
insert into dishes (name,price,prep_time,restaurant)
values ('Ossobuco con riso al salto','20','20','3');

insert into dishes (name,price,prep_time,restaurant)
values ('Mix di nighiri dello chef','25','18','4');
insert into dishes (name,price,prep_time,restaurant)
values ('Sashimi mix','25','13','4');
insert into dishes (name,price,prep_time,restaurant)
values ('Tartar di scampi','18','10','4');

insert into dishes (name,price,prep_time,restaurant)
values ('Trofie al pesto','10','12','5');
insert into dishes (name,price,prep_time,restaurant)
values ('Fritto misto di pesce','18','15','5');
insert into dishes (name,price,prep_time,restaurant)
values ('Spaghetti alle vongole','14','13','5');

insert into dishes (name,price,prep_time,restaurant)
values ('Spaghetti alle vongole','16','13','6');
insert into dishes (name,price,prep_time,restaurant)
values ('Grigliata di pesce','25','20','6');
insert into dishes (name,price,prep_time,restaurant)
values ('Insalata di mare','18','13','6');

insert into dishes (name,price,prep_time,restaurant)
values ('Pizza Margherita','5','5','7');
insert into dishes (name,price,prep_time,restaurant)
values ('Focaccia di recco','6','7','7');
insert into dishes (name,price,prep_time,restaurant)
values ('Pizza Diavola','7','6','7');