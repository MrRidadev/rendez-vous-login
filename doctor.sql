create database doctor;
use doctor;
drop table if exists users;
create table users (
id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    motPass VARCHAR(255) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    specialisation VARCHAR(100) ,
	role ENUM('patient', 'doctor') NOT NULL
);

select * from users;
insert into users (nom,email,motPass,numero,specialisation,role) values('rida','kiratte@gmail.com',123456789,0665413778,'ridaaaaa','patient');
