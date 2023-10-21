
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
-- dodanie rodzajów posiłków

insert  into mealtype( name, description, photo) values ('Vegetarian','Dieta wegetariańska polega na wyłączeniu z diety mięsa i jego przetworów. Opiera się ona głównie na pokarmach pochodzenia roślinnego, których źródłem są rośliny zbożowe, strączkowe, okopowe i oleiste, oraz warzywa, owoce, grzyby i orzechy','https://p1.hiclipart.com/preview/872/430/563/natural-foods-vegetable-vegan-nutrition-superfood-food-group-cartoon-fruit-plant-vegetarian-food-legume-leaf-vegetable-local-food-png-clipart-thumbnail.jpg' );
insert  into mealtype( name, description, photo) values ('Vegan','Wyklucza wszelkie produkty pochodzenia zwierzęcego, w tym mięso, ryby, nabiał, jaja, mleko, masło i produkty pochodzenia zwierzęcego, takie jak miód.','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3NegbAIkYXqkGl9yYWrga5ZElu7c_SgvHhWZBw5Hk&s' );
insert  into mealtype( name, description, photo) values ('LactozeeFree','Wyklucza mięso, ryby i jaja, ale pozwala na spożywanie nabiału, takiego jak mleko, jogurt, ser i masło.','https://thumb.ac-illust.com/b8/b8fefd6c36f2c0bc51ccd6d2fc83891c_t.jpeg' );

-- dodanie przykładowych diet do użytkownika o id 1L
-- najpierw diety
-- insert into diet (calories_count, normal_user_id, diet_goal, diet_name)
-- values (500,1,'schudnac','nisko kaloryczna');
--
-- insert into diet (calories_count, normal_user_id, diet_goal, diet_name)
-- values (1500,1,'Zwiekszyc wage','wysoko Kaloryczna');
-- insert into dietmeals(diet_id, meal_id)  values (1,1);
-- insert into dietmeals(diet_id, meal_id)  values (1,2);
-- insert into dietmeals(diet_id, meal_id)  values (1,3);
--
-- insert into dietmeals(diet_id, meal_id)  values (2,4);
-- insert into dietmeals(diet_id, meal_id)  values (2,5);
-- insert into dietmeals(diet_id, meal_id)  values (2,6);

insert into alergicingridients (description, photo, name)
values ('eggs','https://cdn.britannica.com/94/151894-050-F72A5317/Brown-eggs.jpg','egg');

insert into alergicingridients (description, photo, name)
values ('nuts','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJWJmpQqhIknvDN2QvNv2KcemXnjgoTX0EKMYQsxlE-Eiz8XxyDorkqaNmklTbMONX7B4&usqp=CAU','nuts');

insert into alergicingridients (description, photo, name)
values ('sea fruits','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7ETl1LTQbSQeaz89-hDvEyl5CulomHXSdwB2KCqXtr-4U-PBFc7ZTyUWrrDFIl9ClLG4&usqp=CAU','sea fruit');



-- -- wprowadzenie rodzajów cwiczeń ćwiczeń do bazy danych
-- insert into training ( max_age, normal_user_id, treining_type, description)
-- values (80,1,'FBW','treining dla początkujacych');
-- -- dodanie cwiczeń
-- insert into exercise ( level_of_advance, series,reps, training_machine_id, name, photo)
-- values (3,4,15,1,'podciaganie','podciaganie.jpg');
--
-- insert into exercise ( level_of_advance, series,reps, training_machine_id, name, photo)
-- values (4,3,10,2,'uginanie sztangi','uginanie.jpg');
--
-- -- connections between training and exercises;
-- insert into trainingexercise (exercise_id, training_id)
-- values (1,1);
-- insert into trainingexercise (exercise_id, training_id)
-- values (2,1);

-- wstawienie partii mieści które można ćwiczyć




