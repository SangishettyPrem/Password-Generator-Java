# 🔐 Password Generator & Strength Analyzer

A console-based Java application that generates random passwords based on user-defined criteria and evaluates password strength.

This project is being developed as a practical Java learning project to strengthen concepts such as OOP, encapsulation, service-layer design, exception handling, secure random generation, and testing.

---

## 🚀 Features

### 🔑 Password Generator

* Generate passwords with a custom length.
* Include uppercase letters.
* Include lowercase letters.
* Include numbers.
* Include symbols.
* Ensures that every selected character category is represented.
* Uses `SecureRandom` for random password generation.
* Randomly shuffles generated characters.

### 🛡️ Password Strength Checker

The application evaluates passwords based on:

* Password length.
* Uppercase characters.
* Lowercase characters.
* Numbers.
* Symbols.

### 📊 Strength Levels

| Score | Strength    |
| ----: | ----------- |
|   0–2 | WEAK        |
|     3 | MEDIUM      |
|     4 | STRONG      |
|     5 | VERY STRONG |

> **Note:** The strength checker is an educational heuristic and should not be considered a complete real-world password security assessment.

---

## 🛠️ Technologies Used

* **Java**
* **Maven**
* **IntelliJ IDEA**
* **Git**
* **GitHub**

### Java APIs Used

* `java.util.Scanner`
* `java.util.List`
* `java.util.Collections`
* `java.lang.StringBuilder`
* `java.lang.Character`
* `java.security.SecureRandom`

---

## 📁 Project Structure

```text
password-generator/
│
├── pom.xml
├── README.md
│
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── project/
    │               └── passwordgenerator/
    │                   │
    │                   ├── model/
    │                   │   └── PasswordCriteria.java
    │                   │
    │                   ├── service/
    │                   │   └── PasswordGeneratorService.java
    │                   │
    │                   └── ui/
    │                       ├── ConsoleApplication.java
    │                       └── InputReader.java
    │
    └── test/
        └── java/
```

---

## 🏗️ Application Architecture

The application follows a simple layered architecture.

```text
                    User
                     │
                     ▼
          ┌─────────────────────┐
          │ ConsoleApplication  │
          └──────────┬──────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │     InputReader     │
          └──────────┬──────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │   PasswordCriteria  │
          └──────────┬──────────┘
                     │
                     ▼
       ┌────────────────────────────┐
       │ PasswordGeneratorService  │
       └────────────────────────────┘
```

### Responsibilities

**ConsoleApplication**

* Displays the application menu.
* Handles application flow.
* Collects user input.
* Displays results.

**InputReader**

* Handles console input.
* Reads integers.
* Reads yes/no values.
* Reads strings.
* Handles invalid input.

**PasswordCriteria**

* Represents the user's password requirements.
* Stores password length and required character categories.

**PasswordGeneratorService**

* Builds the character pool.
* Generates random characters.
* Ensures required character categories are included.
* Shuffles the generated password.

---

## 🔐 Password Generation

The password generator works using the following process:

```text
User enters password criteria
            │
            ▼
     PasswordCriteria
            │
            ▼
    Build Character Pool
            │
            ▼
Add one character from
each required category
            │
            ▼
Generate remaining characters
using SecureRandom
            │
            ▼
       Shuffle Characters
            │
            ▼
     Generated Password
```

### Example

User selects:

```text
Password Length: 16
Uppercase: Yes
Lowercase: Yes
Numbers: Yes
Symbols: Yes
```

Possible generated password:

```text
R$3%)qOOC76XzPEq
```

Another execution may produce:

```text
7@xP2#LmQ9!aZc4$
```

The generated password is random and should satisfy all selected criteria.

---

## 🛡️ Password Strength Checking

The password strength checker currently uses five criteria:

```text
1. Password length >= 8
2. Contains uppercase character
3. Contains lowercase character
4. Contains number
5. Contains symbol
```

Each satisfied criterion contributes one point.

### Example

Password:

```text
Hello@123456
```

Analysis:

```text
Length >= 8       ✓
Uppercase         ✓
Lowercase         ✓
Number            ✓
Symbol            ✓
```

Score:

```text
5
```

Strength:

```text
VERY STRONG
```

---

## 📋 Application Menu

```text
========================================
       Password Generator & Analyzer
========================================

1. Generate Password
2. Check Password Strength
3. Analyze Password
4. Exit
```

---

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone <repository-url>
```

### 2. Navigate to the project

```bash
cd password-generator
```

### 3. Build the project

```bash
mvn clean package
```

### 4. Run the application

Open the project in IntelliJ IDEA and run:

```text
ConsoleApplication.java
```

---

## 💻 Example Usage

### Generate Password

```text
========================================
       Password Generator & Analyzer
========================================

1. Generate Password
2. Check Password Strength
3. Analyze Password
4. Exit

Enter the Choice: 1

Password Length
16

Upper Case Letters are required (Y/N): Y
Lower Case Letters are required (Y/N): Y
Numbers are required (Y/N): Y
Symbols are required (Y/N): Y

Generated Password:
R$3%)qOOC76XzPEq
```

---

## 📚 Java Concepts Practiced

This project is being used to practice:

* Object-Oriented Programming
* Classes and Objects
* Encapsulation
* Constructors
* Immutable objects
* `final` fields
* Enums
* Collections
* `StringBuilder`
* Loops
* Conditional statements
* Exception handling
* Custom exceptions
* Constructor dependency injection
* `SecureRandom`
* `Character` API
* Maven
* JUnit testing

---

## 🔮 Future Improvements

The project is currently under development.

Planned improvements include:

* [ ] Password criteria validation
* [ ] Custom `InvalidPasswordCriteriaException`
* [ ] Detailed password analysis
* [ ] Password suggestions
* [ ] Common password detection
* [ ] Repeated character detection
* [ ] Sequential character detection
* [ ] JUnit 5 tests
* [ ] Improved console UI
* [ ] Maven packaging
* [ ] Final project cleanup

---

## ⚠️ Disclaimer

The password strength checker is intended for educational purposes.

The current scoring system checks basic characteristics such as length and character diversity. It does not perform comprehensive password-security analysis and should not be treated as a definitive measure of password security.

---

## 🎯 Project Purpose

The purpose of this project is to build a practical Java application while learning Java development concepts step by step.

It is also intended to serve as a foundation for progressing from **Core Java to Spring Boot backend development**.

---

## 👨‍💻 Author

**Prem Kumar**

Java | Spring Boot | Node.js | React | Full Stack Development
