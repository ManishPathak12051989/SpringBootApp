# SpringBootApp

#Table ddl and structure
create database if not exists <db_name>;
create table if not exists <db_name>.<table_name> (
	id int not null primary key auto_increment,
	name varchar(40) not null,
	age int,
	address varchar(40),
	stream varchar(20)
);

#Configuring properties file (src/main/resources/application.properties)
server.port=<port>
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/assignment (database url)
spring.datasource.username=<user name>
spring.datasource.password=<password>

# Sample Get Request
GET
localhost:7070/students/fetch

#Sample Post Request
POST
localhost:7070/students/
{
        "name": "M ",
        "age": 23,
        "address": "Ghy",
        "stream": "Science"
	
}

#Sample Put Request
PUT
localhost:7070/students/
{
	    "id": "1",
        "name": "Manish Pathak",
        "age": 23,
        "address": "Ghy",
        "stream": "Science"
}

# Notes
This application is a maven project.
