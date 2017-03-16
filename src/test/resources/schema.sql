DROP TABLE IF EXISTS employee;

CREATE TABLE IF NOT EXISTS employee(id int PRIMARY KEY ,name varchar(200),expr double);

DROP TABLE IF EXISTS project;

CREATE TABLE IF NOT EXISTS project(pid int PRIMARY KEY ,pname varchar(200),emp_id int references employee);