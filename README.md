# RestAssured Java TestNG Framework

A **Java-based API automation framework** built using **RestAssured**, **TestNG**, and **Maven**.  
This project demonstrates a clean, modular design for API testing with support for **BDD (Cucumber)**, reusable payloads, and structured reporting.

---

## 📂 Project Structure

│── src
│   ├── main
│   │   ├── java
│   │   │   ├── api                # API client classes (e.g., LibraryAPIClient.java)
│   │   │   ├── constants          # Endpoints and constants (EndPoint.java)
│   │   │   ├── models             # Request/Response POJOs (AddBookRequest.java, GetBookResponse.java, etc.)
│   │   │   ├── payloads           # Payload builders (BookPayloads.java)
│   │   └── resources              # Config files/resources
│   ├── test
│   │   ├── java
│   │   │   ├── base               # BaseTest setup (BaseTest.java)
│   │   │   ├── feature            # Cucumber feature files (AddBook.feature)
│   │   │   ├── runners            # TestNG/Cucumber runners (TestRunner.java)
│   │   │   ├── stepdefinitions    # Step definitions (AddBookSteps.java)
│── pom.xml                        # Maven dependencies & build configuration
│── target                         # Compiled output
│── test-output                    # TestNG reports


---

## 🚀 Features
- **RestAssured** for API automation (GET, POST, PUT, DELETE).
- **TestNG** for test execution and reporting.
- **Cucumber (BDD)** for feature-driven testing.
- **POJO Models** for request/response mapping.
- **Payload Builders** for dynamic test data.
- **Maven** for dependency management and build lifecycle.
- **Reusable BaseTest** for common setup/teardown.

---

## ⚙️ Prerequisites
- Java 17+
- Maven 3.8+
- IDE (IntelliJ IDEA / Eclipse)
- Git

---

👉 This README is **GitHub-ready**: it explains the framework, structure, setup, and usage in a professional way.  

Would you like me to also add a **sample API test case snippet** (like `AddBookRequest` + `RestAssured` test) inside the README so that new users immediately see how to write tests with your framework?


   
