Hibernate-PostgreSQL Example Project
This project demonstrates how to use Hibernate ORM with PostgreSQL in a basic Java application. It covers:
Hibernate configuration using hibernate.cfg.xml
Entity relationships (OneToMany, ManyToOne)
Basic CRUD operations (Create, Read, Update, Delete)
HQL (Hibernate Query Language) queries
Caching with @Cacheable
Lazy vs Eager fetching

Tech Stack
Java
Hibernate ORM
PostgreSQL
Maven/Plain Java project (no build tool dependency)

Project Structure
IntelliJ IDEA
├── src/
│   └── main/
│       ├── java/
│       │   └── org/example/
│       │       ├── Main.java
│       │       ├── Coders.java
│       │       ├── Laptop.java
│       │       └── Student.java (optional)
│       └── resources/
│           └── hibernate.cfg.xml

Setup Instructions
1. Prerequisites
Java (8+)
PostgreSQL installed and running
IntelliJ IDEA or any Java IDE
postgresql JDBC driver in classpath
2. PostgreSQL Setup
Create a database
CREATE DATABASE DatabaseName;
(Optional) Create the required user and assign privileges:
CREATE USER postgres WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE DatabaseName TO postgres;
3. Configure hibernate.cfg.xml
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/DatabaseName</property>
<property name="hibernate.connection.username">username</property>
<property name="hibernate.connection.password">password</property>
<property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
<property name="hibernate.hbm2ddl.auto">update</property>
<property name="hibernate.show_sql">true</property>
   



   

