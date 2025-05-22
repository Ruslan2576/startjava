

create database robots;
\c
create table jaegers (
	id 				serial not null primary key,
	model_name 		text not null,
 	mark 			char(6) not null,
 	height 			numeric not null,
	weight 			numeric not null,
	status 			text not null,
 	origin 			text not null,
	launch 			date not null,
	kaiju_kill 		integer not null
);

\i C:/Java/StartJava/src/com/startjava/lesson_5/populate.sql
\i C:/Java/StartJava/src/com/startjava/lesson_5/queries.sql