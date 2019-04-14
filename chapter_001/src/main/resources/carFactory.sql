

--select * from car_engine;

--alter table car add column tipe varchar(40);

--insert into car_body (name, date_made) values('LitleHatch1017', '03.03.19');


--insert into car_engine (name,date_made,power,tipe) values('dragon011018','02.01.19',340,'BiDisel');
-alter table car_engine add column tipe varchar(40);


--insert into car_engine (name,date_made,power,tipe) values('megatrone012019','02.04.19',340,'Electro');
--insert into car_engine (name,date_made,power,tipe) values('Next011018','03.01.19',240,'Gibrid');
--insert into car_engine (name,date_made,power,tipe) values('oldShcool011018','10.01.19',220,'BensineBiTurbo');
--insert into car_engine (name,date_made,power,tipe) values('NewWey011018','04.03.19',200,'Propan');
--insert into car_engine (name,date_made,power,tipe) values('Optimus011218','02.02.19',280,'Turbo');
--insert into car_engine (name,date_made,power,tipe) values('Economy011118','07.03.19',120,'petrolTurbo');



--insert into car_transmission (name,date_made,tipe) values('Slogic011018Auto','02.01.19',7);
--insert into car_transmission (name,date_made,tipe) values('Pozitrone011018Variator','07.04.19',0);
--insert into car_transmission (name,date_made,tipe) values('Mehatronic011217Auto','09.03.19',8);
--insert into car_transmission (name,date_made,tipe) values('SpeedSift100119TwoRobot','05.03.19',7);
--insert into car_transmission (name,date_made,tipe) values('Pozitive011018OneRobot','20.12.18',8);
--insert into car_transmission (name,date_made,tipe) values('Ician100818auto','02.01.19',6);
--insert into car_transmission (name,date_made,tipe) values('Nexttronic011029Auto','06.04.19',9);
--insert into car_transmission (name,date_made,tipe) values('Smart011018Variator','27.02.19',0);

                                     заполнение  и изменение таблицы car

alter table car add column color  varchar(40);
alter table car add column date_made date;

--update car set name='TitanM2018', car_body_id=2,car_engine_id=6,car_transmission_id=31,date_made='08.04.19';
insert into car (name, car_body_id ,car_engine_id, car_transmission_id,
 color, date_made) values('Smart012017', 6, 7, 32, 'BlueHeavy01', '10.04.19');
insert into car (name, car_body_id ,car_engine_id,
 --color, date_made) values('GreenWood101018', 2, 2, 'Yelow00', '13.04.19');

--insert into car (name, car_body_id ,car_engine_id, car_transmission_id,
 --color, date_made) values('Eco050618', 1, 3, 26, 'BlueHeavy01', '05.04.19');


 --update car set color='Black02Blue' where id=1;

                    запросы, выборка имен автомобилей со всеми  именами запчатей

select car.name, car_body.name, car_engine.name, car_transmission.name from car inner join car_body on car.car_body_id=car_body.id
join car_engine on car.car_engine_id=car_engine.id
join car_transmission on car.car_transmission_id=car_transmission.id;


                    вывод запчастей  котырые не используються
                                  первый вариант одной таблицы, вывод корпусов, которые не используються всё идет
                                         по тойже схеме могу вывести другие запчасти в отдельных таблицах
select car.name, car_body.name from car
right join car_body on car.car_body_id=car_body.id where car.car_body_id is null


второй вариант вывод с присоеденением 3 таблиц, так не идёт вопрос почему? Я догадываюсь но как обойти препятствие?

--right join car_body on car.car_body_id=car_body.id
right join car_engine on car.car_engine_id=car_engine.id
right join car_transmission on car.car_transmission_id=car_transmission.id
where car.car_body_id is null or
 car.car_engine_id is null or
 car.car_transmission_id is null;

                                Немного изврашенный вариант

select Cb.name as NoUseParts from  car as c
right  join car_body as CB on c.car_body_id=Cb.id
where c.car_body_id is Null

 union ALL
select CE.name from car as c
right join car_engine as CE on c.car_engine_id=CE.id
where  c.car_engine_id is Null

union all
select CT.name from car as c
right join car_Transmission as CT on c.car_transmission_id=CT.id
where c.car_transmission_id is Null;


выводит запчасти в одном столбце

