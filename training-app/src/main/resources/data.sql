
-- role użytkowników
insert  into authority (authority) values('NormalUser');
insert  into authority (authority) values('Premium');
insert  into authority (authority) values('Administrator');

-- przykładowi użytkownicy
#
insert into normaluser (authority_id, birth_date, height, palfactor,sex, weight, first_name, last_name, mail, password,
                        photo)
values (1,'1979-06-16',193.0,1.5,true,99,'Michal','Kowalski','kowalski@gmail.com','password1','photo.jpg');


insert into normaluser (authority_id, birth_date, height, palfactor,sex, weight, first_name, last_name, mail, password,
                        photo)
values (1,'1989-02-15',166.0,1.5,true,82,'Karol','Nowacki','nowacki@gmail.com','password2','photo2.jpg');


insert into normaluser (authority_id, birth_date, height, palfactor,sex, weight, first_name, last_name, mail, password,
                        photo)
values (1,'1997-01-16',185.0,1.5,true,73,'Maciej','Mazurski','mazurski@gmail.com','password3','photo2.jpg');


insert into normaluser (authority_id, birth_date, height, palfactor,sex, weight, first_name, last_name, mail, password,
                        photo)
values (1,'2001-02-23',157.0,1.5,false,55,'Maja','Niedzielska','niedzielska@gmail.com','password4','photo2.jpg');


insert into normaluser (authority_id, birth_date, height, palfactor,sex, weight, first_name, last_name, mail, password,
                        photo)
values (1,'1959-12-12',166.0,1.5,false,66,'Natalia','Lewandowska','lewandowska@gmail.com','password14','photo2.jpg');