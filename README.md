# College Placement Management System

A **Java-based College Placement Management System** built to practice and demonstrate **Core Java, OOP, SQL, JDBC, DAO Pattern, and layered architecture**.

## 🚀 Project Progress

### ✅ Completed

#### Java Fundamentals

* Java Basics
* Object-Oriented Programming
* Collections
* Exception Handling
* Generics — *in progress*

#### Database Fundamentals

* SQL
* Database Design
* Table Relationships
* Joins
* Constraints
* Basic Transactions

#### JDBC

* Database Connection
* `PreparedStatement`
* `ResultSet`
* CRUD Operations
* Transactions
* DAO Pattern

#### Version 2 — Placement Management System

Implemented database-backed functionality for:

* 👨‍🎓 Student management
* 🏢 Company management
* 💼 Job management
* 📝 Application management
* Eligibility checking based on:

    * CGPA
    * Backlogs
* Duplicate application prevention
* Ineligible application prevention
* Find application by ID
* Get all applications
* Get applications by student
* Get eligible jobs

## 🏗️ Architecture

```text
Main
  ↓
PlacementService
  ↓
DAO Interfaces
  ↓
DAO Implementations
  ↓
JDBC
  ↓
MySQL Database
```

### DAO Components

```text
StudentDAO
StudentDAOImpl

CompanyDAO
CompanyDAOImpl

JobDAO
JobDAOImpl

ApplicationDAO
ApplicationDAOImpl
```

## 🛠️ Technologies

* Java 17
* MySQL
* JDBC
* Maven
* IntelliJ IDEA

## 📚 Current Learning Stage

```text
Java Fundamentals          ✅
        ↓
Database Fundamentals      ✅
        ↓
JDBC + DAO Pattern         ✅
        ↓
Version 2 Project          ✅
        ↓
Web / REST Fundamentals    🔜
        ↓
Spring Boot
        ↓
JPA / Hibernate
        ↓
Frontend
        ↓
React
        ↓
Full-Stack Application
        ↓
Deployment
```

## 🔜 Next Step

The next learning stage is **Web / REST Fundamentals**, starting with:

1. HTTP
2. Request / Response
3. GET / POST / PUT / DELETE
4. HTTP Status Codes
5. JSON
6. REST API Design

The existing placement management system will later be evolved into a **Spring Boot REST API**.
