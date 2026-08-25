# 🛒 Toolshop Automation Framework

## Selenium Java | Cucumber BDD | TestNG | Maven | Page Object Model

A web UI test automation framework developed using **Selenium WebDriver with Java** to automate the **Practice Software Testing – Toolshop** application.

The framework is designed using a maintainable automation architecture with **Page Object Model (POM), Cucumber BDD, TestNG, Maven, reusable utilities, test data generation, logging, screenshots, and Extent Reports**.

---

## 🌐 Application Under Test

**Application:** Practice Software Testing – Toolshop

**Website:**
https://practicesoftwaretesting.com/

**Project Repository:**
https://github.com/kunalsantoshpatil/Toolshop-Automation-Framework

---

# 🎯 Project Objective

The objective of this project is to automate important end-to-end user workflows of an e-commerce application and demonstrate practical QA automation skills.

The framework covers:

* User registration
* User login
* Product search
* Product selection
* Add to cart
* Cart validation
* Checkout
* Payment information
* End-to-end purchase workflow
* Test reporting
* Screenshot capture
* Test data generation

---

# 🛠️ Technology Stack

| Technology         | Purpose                       |
| ------------------ | ----------------------------- |
| Java               | Programming language          |
| Selenium WebDriver | Web UI automation             |
| Cucumber           | BDD / Gherkin                 |
| TestNG             | Test execution                |
| Maven              | Build & dependency management |
| Page Object Model  | Framework design              |
| JavaFaker          | Dynamic test data             |
| Extent Reports     | HTML test reporting           |
| Log4j2             | Logging                       |
| SLF4J              | Logging facade                |
| Git                | Version control               |
| GitHub             | Source code repository        |
| IntelliJ IDEA      | Development IDE               |

The current project POM uses Selenium 4.35.0, Cucumber 7.18.1, TestNG 7.10.2, JavaFaker 1.0.2 and the ExtentReports Cucumber 7 adapter.

---

# 🏗️ Framework Architecture

The framework follows a **Page Object Model + Cucumber BDD + TestNG** architecture.

```text
                    ┌─────────────────────┐
                    │   Feature Files     │
                    │      Gherkin        │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │   Step Definitions  │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │     Page Objects    │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │  Selenium WebDriver │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │   Toolshop Website  │
                    └─────────────────────┘

                         TestNG
                           │
                           ▼
                 ┌─────────────────────┐
                 │   Extent Reports    │
                 └─────────────────────┘
```

---

# 📂 Project Structure

```text
Toolshop-Automation-Framework
│
├── src
│   │
│   ├── driver
│   │   └── DriverFactory
│   │
│   └── test
│       │
│       ├── java
│       │   │
│       │   ├── pages
│       │   │   ├── LoginPage
│       │   │   ├── HomePage
│       │   │   ├── ProductPage
│       │   │   ├── CartPage
│       │   │   └── CheckoutPage
│       │   │
│       │   ├── stepDefinitions
│       │   │
│       │   ├── runners
│       │   │
│       │   └── utils
│       │       ├── ConfigReader
│       │       ├── FakerData
│       │       └── ...
│       │
│       └── resources
│           │
│           ├── features
│           │   ├── Register.feature
│           │   ├── Login.feature
│           │   ├── Search.feature
│           │   ├── Cart.feature
│           │   ├── Checkout.feature
│           │   └── EndToEnd.feature
│           │
│           └── config
│
├── reports
│   ├── extent-report
│   └── screenshots
│
├── pom.xml
├── testng.xml
└── README.md
```

> The exact package/file names can evolve as the framework is extended.

---

# 🧩 Page Object Model

Each major application page is represented by a separate Page Object class.

### LoginPage

Responsible for:

* Email field
* Password field
* Login button
* Login validation

### HomePage

Responsible for:

* Navigation
* Product search
* Product listing
* Application-level actions

### ProductPage

Responsible for:

* Product details
* Product selection
* Add-to-cart actions

### CartPage

Responsible for:

* Cart validation
* Product quantity
* Product removal
* Cart total

### CheckoutPage

Responsible for:

* Customer details
* Address information
* Payment information
* Order completion

This approach keeps locators and page-specific actions separate from test logic and improves maintainability.

---

# 🥒 Cucumber BDD

The project uses **Cucumber BDD** to describe test scenarios using Gherkin syntax.

Example:

```gherkin
Feature: User Login

  Scenario: Login with valid credentials
    Given user is on the login page
    When user enters valid email and password
    And user clicks on login
    Then user should be successfully logged in
```

The Gherkin scenario is connected to Java Step Definition classes, which interact with the Page Objects.

---

# 🧪 Automated Test Scenarios

## 1. User Registration

Validates:

* Registration page navigation
* First name
* Last name
* Date of birth
* Phone number
* Email
* Password
* Registration submission
* Successful registration

Dynamic data is generated using **JavaFaker**.

---

## 2. User Login

Validates:

* Login page
* Valid email
* Valid password
* Login submission
* Successful login

---

## 3. Product Search

Validates:

* Product search functionality
* Search result visibility
* Product selection
* Product details

---

## 4. Add Product to Cart

Validates:

* Product selection
* Add-to-cart functionality
* Cart navigation
* Product presence in cart
* Quantity
* Price

---

## 5. Checkout

Validates:

* Customer information
* Address information
* Payment information
* Checkout flow
* Successful order completion

---

## 6. End-to-End Workflow

The complete business workflow is automated:

```text
Register
   ↓
Login
   ↓
Search Product
   ↓
Select Product
   ↓
Add Product to Cart
   ↓
Open Cart
   ↓
Proceed to Checkout
   ↓
Enter Customer Details
   ↓
Enter Payment Details
   ↓
Place Order
   ↓
Validate Order Success
```

This scenario demonstrates an end-to-end automation flow instead of testing individual pages in isolation.

---

# 🎲 Dynamic Test Data

The framework uses **JavaFaker** to generate dynamic test data.

Examples:

* First name
* Last name
* Email
* Phone number
* Date of birth
* Password
* Account information
* Payment-related test data

This helps avoid repeatedly using the same static test data.

---

# 🔧 Driver Management

The project contains a dedicated driver management approach through the `driver` package.

The WebDriver instance is used by the Page Objects and test execution layer.

This keeps browser initialization and driver management separate from individual test scenarios.

---

# 📝 Assertions & Validation

The automation validates expected application behavior using assertions.

Examples:

```java
Assert.assertEquals(actualTitle, expectedTitle);
```

```java
Assert.assertTrue(element.isDisplayed());
```

```java
Assert.assertNotNull(orderId);
```

Assertions are used to verify:

* Page navigation
* Element visibility
* Login success
* Product availability
* Cart contents
* Checkout results
* Order confirmation

---

# 📸 Screenshot Capture

Screenshots are captured during test execution, particularly for failed scenarios.

Screenshots are stored under:

```text
reports/screenshots/
```

This helps with debugging and provides visual evidence when a test fails.

---

# 📊 Extent Reports

The project uses **ExtentReports** for HTML reporting.

The report provides information such as:

* Test scenarios
* Pass/Fail status
* Execution details
* Steps
* Failure information
* Screenshots

Report location:

```text
reports/extent-report/
```

---

# 🪵 Logging

Logging is included to make test execution easier to understand and troubleshoot.

Logs can be used to identify:

* Test execution flow
* Important actions
* Passed operations
* Failures
* Exceptions

---

# ⚙️ Maven Configuration

The project uses Maven for dependency and build management.

Run the project after installing the required JDK and Maven environment.

### Clean and execute tests

```bash
mvn clean test
```

### Execute using TestNG XML

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

The Maven Surefire plugin is configured to execute the project's TestNG suite.

---

# ▶️ How to Run the Project

## Step 1 – Clone the Repository

```bash
git clone https://github.com/kunalsantoshpatil/Toolshop-Automation-Framework.git
```

## Step 2 – Open the Project

Open the project in:

```text
IntelliJ IDEA
```

## Step 3 – Verify Java

The current Maven configuration targets Java 26.

```bash
java -version
```

## Step 4 – Install Maven Dependencies

```bash
mvn clean install
```

## Step 5 – Execute Tests

```bash
mvn clean test
```

Or run:

```text
testng.xml
```

from IntelliJ IDEA.

---

# 📋 Test Execution Flow

```text
Feature File
     ↓
Cucumber Runner
     ↓
Step Definitions
     ↓
Page Objects
     ↓
Selenium WebDriver
     ↓
Toolshop Application
     ↓
Assertions
     ↓
Extent Report
     ↓
Screenshots on Failure
```

---

# 📈 Reporting

After execution, check:

```text
reports/
│
├── extent-report/
│   └── ExtentReport.html
│
└── screenshots/
    └── *.png
```

Open the generated HTML report in a browser to review the test execution.

---

# 🔍 What This Project Demonstrates

### Selenium

* WebDriver automation
* Locators
* WebElement interactions
* Explicit waits
* Actions
* Browser automation

### Java

* OOP concepts
* Classes and methods
* Inheritance
* Exception handling
* Collections
* Utility classes

### Cucumber

* Feature files
* Gherkin
* Step Definitions
* Hooks
* Test Runner
* BDD workflow

### TestNG

* Test execution
* Assertions
* Test suites
* Integration with Cucumber

### Maven

* Dependency management
* Build lifecycle
* Test execution

### Framework Design

* Page Object Model
* Driver Factory
* Reusable utilities
* Configuration management
* Dynamic test data
* Reporting
* Screenshot capture

---

# 🧪 Test Coverage

| Module            | Automated Coverage |
| ----------------- | ------------------ |
| Registration      | ✅                  |
| Login             | ✅                  |
| Product Search    | ✅                  |
| Product Selection | ✅                  |
| Add to Cart       | ✅                  |
| Cart Validation   | ✅                  |
| Checkout          | ✅                  |
| Payment Details   | ✅                  |
| End-to-End Flow   | ✅                  |
| Screenshots       | ✅                  |
| Extent Reporting  | ✅                  |
| Dynamic Test Data | ✅                  |

---

# 📸 Recommended Screenshots for Interview

The README should not contain too many screenshots.

I recommend showing these:

### 1. Framework Structure

Show:

```text
src
 ├── driver
 └── test
      ├── java
      └── resources
```

### 2. Page Object

Show one Page Object such as:

```text
LoginPage.java
```

Demonstrate that locators and page actions are separated from test logic.

### 3. Feature File

Show a Cucumber feature such as:

```text
Login.feature
```

### 4. Step Definition

Show how the Gherkin steps call Page Object methods.

### 5. Test Execution

Show the TestNG/Cucumber execution result.

### 6. Extent Report

Show the final HTML report with:

```text
PASS
FAIL
SKIPPED
Execution Details
Screenshots
```

### 7. Failed Test Screenshot

Show one example where the framework captured a screenshot after a failure.

---

# 💡 Key Framework Benefits

### Maintainability

Page-specific locators and actions are separated from test scenarios.

### Reusability

Common actions and utilities can be reused across multiple test cases.

### Readability

Cucumber feature files make business scenarios easy to understand.

### Debugging

Logging, screenshots, and Extent Reports make failures easier to investigate.

### Scalability

New pages and scenarios can be added without significantly changing the existing framework.

---

# 🚀 Future Enhancements

Possible future improvements:

* Parallel execution
* Cross-browser execution
* Selenium Grid
* Jenkins CI/CD integration
* Docker execution
* Retry failed scenarios
* Data-driven testing using Excel/CSV
* Allure reporting
* API + UI integration
* Cloud execution using Selenium Grid providers

---

# 📚 Repository

Full project:

https://github.com/kunalsantoshpatil/Toolshop-Automation-Framework

Source code:

https://github.com/kunalsantoshpatil/Toolshop-Automation-Framework/tree/main/src

---

# 👨‍💻 Author

**Kunal Patil**

QA Automation | Selenium Java | Cucumber | TestNG | API Testing | Postman

---

## ⭐ Project Summary

This project demonstrates a practical **Selenium Java automation framework** for an e-commerce application using **Page Object Model, Cucumber BDD, TestNG, Maven, JavaFaker, logging, screenshots, and Extent Reports**.

The framework automates critical user journeys from **registration and login through product search, cart, checkout, and end-to-end purchase validation**.
