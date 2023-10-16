
-- role użytkowników
insert  into authority (authority) values('NormalUser');
insert  into authority (authority) values('Premium');
insert  into authority (authority) values('Administrator');

-- przykładowi użytkownicy
#
insert into normaluser (authority_id, birth_date, height, palfactor,sex, weight, first_name, last_name,login, mail, password,
                        photo)
values (1,'1979-06-16',193.0,1.6,true,99,'Michal','Kowalski','ps5','kowalski@gmail.com','password1','photo.jpg');



insert into normaluser (authority_id, birth_date, height, palfactor,sex, weight, first_name, last_name,login, mail, password,
                        photo)
values (1,'1989-02-15',166.0,1.8,true,82,'Karol','Nowacki','2115','nowacki@gmail.com','password2','photo2.jpg');


insert into normaluser (authority_id, birth_date, height, palfactor,sex, weight, first_name, last_name,login, mail, password,
                        photo)
values (1,'1997-01-16',185.0,1.5,true,73,'Maciej','Mazurski','mistrz','mazurski@gmail.com','password3','photo2.jpg');


insert into normaluser (authority_id, birth_date, height, palfactor,sex, weight, first_name, last_name,login, mail, password,
                        photo)
values (1,'2001-02-23',157.0,1.6,false,55,'Maja','Niedzielska','maja','niedzielska@gmail.com','password4','photo2.jpg');


insert into normaluser (authority_id, birth_date, height, palfactor,sex, weight, first_name, last_name,login, mail, password,
                        photo)
values (1,'1959-12-12',166.0,1.5,false,66,'Natalia','Lewandowska','lewa','lewandowska@gmail.com','password14','photo2.jpg');

-- premium users

insert into premiumuser (end_subscription, hips_circumference, id, start_subscription, waist_circumference)
values ('2000-01-11',200.0,1,'2000-01-09',150.0);
-- add some maxes
--
insert into maxinexercise (bench, day_of_records, deadlift, normal_user_id, pullups, squad)
values (100,'2000-01-11',156,1,12,200);

--
insert into maxinexercise (bench, day_of_records, deadlift, normal_user_id, pullups, squad)
values (120,'2001-01-12',160,1,10,220);
--
--
insert into maxinexercise (bench, day_of_records, deadlift, normal_user_id, pullups, squad)
values (120,'2001-01-12',160,1,10,220);
--
--
insert into maxinexercise (bench, day_of_records, deadlift, normal_user_id, pullups, squad)
values (160,'2002-01-12',179,1,40,300);
--
--
insert into maxinexercise (bench, day_of_records, deadlift, normal_user_id, pullups, squad)
values (100,'2002-01-12',90,1,70,150);
-- insert meals
-- create
-- definer = root@localhost procedure InsertData(IN countMeals int)
-- BEGIN
--     DECLARE i INT DEFAULT 1;
--     DECLARE max_count INT DEFAULT countMeals;
--
--     WHILE i <= max_count DO
--             INSERT INTO meal (calories, meal_type_id, meal_name, photo)
--             VALUES (FLOOR(RAND() * (1000 - 300 + 1) + 300), 1, concat('name',i), concat('photo',i));
--             SET i = i + 1;
-- END WHILE;
-- END;
--
--
--
--
-- create
-- definer = root@localhost procedure insertExercises(IN countExercises int)
-- BEGIN
--     DECLARE i INT DEFAULT 1;
--     DECLARE max_count INT DEFAULT countExercises;  -- Change to insert 20 records
--
--     WHILE i <= max_count DO
--             INSERT INTO exercise( level_of_advance, series, training_machine_id, type_of_exercise_id, name, photo)
--             VALUES (FLOOR(RAND() * (5 - 1 + 1) + 1),(FLOOR(RAND() * (15 - 1 + 1) + 1)),1,3,concat('exercise',i),concat('photo',i));
--             SET i = i + 1;
-- END WHILE;
-- END;
