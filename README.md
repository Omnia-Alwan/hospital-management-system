# Hospital Management System (Console-Based)

A console-based hospital management system built in Java to practice core Object-Oriented Programming principles and relational database design with MySQL. The application uses an MVC-style structure, with a command-line interface serving as the View layer.

## Overview

The system manages hospital staff, patients, medical operations, billing, and reporting through a class hierarchy that models real-world hospital roles using inheritance and polymorphism.

## Class Design

- **User** *(abstract base class)* — shared identity and authentication fields for anyone in the system
  - **Patient** — patient records and personal/medical information
  - **Employee** — shared staff attributes
    - **Doctor** — manages patient operations/procedures/reports
    - **Receptionist** — handles patient registration and scheduling
    - **Cashier** — processes payments and generates receipts

- **Operation** — represents a medical procedure/operation performed on a patient
- **Reciept** *(Receipt)* — billing record generated after payment
- **Report** — generates summary reports (e.g. patient history, hospital activity)
- **Database** — handles the MySQL connection and persistence layer
- **Option** — supports the CLI menu/navigation flow

## Key OOP Concepts Applied

- **Abstraction** — `User` defines a common contract implemented differently by each subclass
- **Inheritance** — `Employee`, `Doctor`, `Receptionist`, `Cashier`, and `Patient` all extend from `User`, with `Doctor`/`Receptionist`/`Cashier` further extending `Employee`
- **Polymorphism** — shared behaviors (e.g. login, profile display) behave differently depending on the concrete subclass
- **Encapsulation** — internal state of each class is accessed through defined methods rather than exposed directly

## Architecture

- **Model** — `User`, `Patient`, `Employee`, `Doctor`, `Receptionist`, `Cashier`, `Operation`, `Reciept`, `Report`
- **Controller** — coordinates actions between the CLI and the data layer
- **View** — command-line interface (`Option`) for user input and menu navigation
- **Database** — MySQL persistence via the `Database` class

## Tech Stack

- Java (Core OOP)
- MySQL

## How to Run

1. Clone the repository
2. Set up a MySQL database and update connection details in `models/Database.java`
3. Compile the project:
   ```bash
   javac *.java
   ```
4. Run the application:
   ```bash
   java Main


## Notes

This project was built primarily as an exercise in applying OOP design principles (inheritance, polymorphism, abstraction) alongside relational database persistence, rather than as a production-ready system.
