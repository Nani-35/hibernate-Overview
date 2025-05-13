# Hibernate + PostgreSQL Example Project

This project demonstrates how to integrate **Hibernate ORM** with **PostgreSQL** in a basic Java application.

---

## 🔍 Features

- Hibernate configuration using `hibernate.cfg.xml`
- Entity relationships: `@OneToMany`, `@ManyToOne`
- Basic CRUD operations: Create, Read, Update, Delete
- HQL (Hibernate Query Language) usage
- Caching with `@Cacheable`
- Lazy vs Eager fetching strategies

---

## 🛠️ Tech Stack

- Java (8 or above)
- Hibernate ORM
- PostgreSQL
- JDBC
- IntelliJ IDEA (Recommended)
- No build tool (Plain Java project)

---

## ⚙️ Setup Instructions

### 1. Prerequisites

- Java JDK 8+
- PostgreSQL installed and running
- PostgreSQL JDBC driver added to classpath
- Java IDE like IntelliJ IDEA

---
```markdown
### 2. PostgreSQL Setup

```sql
-- Create a new database
CREATE DATABASE your_database_name;

-- (Optional) Create a user and assign privileges
CREATE USER your_username WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE your_database_name TO your_username; 
---
### 3. Configure hibernate.cfg.xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/your_database_name</property>
        <property name="hibernate.connection.username">your_username</property>
        <property name="hibernate.connection.password">your_password</property>

        <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
        <property name="hibernate.hbm2ddl.auto">update</property>

        <property name="show_sql">true</property>
        <property name="format_sql">true</property>

        <!-- Add your mapped classes here -->
        <mapping class="com.yourpackage.entity.Coders"/>
        <mapping class="com.yourpackage.entity.Laptop"/>
        <mapping class="com.yourpackage.entity.Student"/>
    </session-factory>
</hibernate-configuration>
