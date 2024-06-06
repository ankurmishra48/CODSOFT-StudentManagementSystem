
create database studentmanagement;
show databases;
use studentmanagement;
create table login(username varchar(20), password varchar(20));
insert into login values('admin','1234');
select * from login;
create table Student(name varchar(20), fname varchar(20),class varchar(20), address varchar(100), phone varchar(20), email varchar(40), education varchar(20), branch varchar(30), aadhar varchar(25), stuId varchar(15));
SELECT * FROM Student;
SHOW COLUMNS FROM Student;

