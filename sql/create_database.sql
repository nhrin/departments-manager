create database mydb;
use mydb;

create table Departments
(
    id   int auto_increment primary key,
    name varchar(255) unique
);

create table Employees
(
    id   int auto_increment primary key,
    name varchar(255),
    email varchar(255) unique,
    department_id int,
    foreign key (department_id) references Departments (id)
);