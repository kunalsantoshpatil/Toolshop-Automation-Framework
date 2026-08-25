# Postman API Testing – Practice Software Testing

## 📌 Project Overview

This project demonstrates **REST API testing using Postman** on the Practice Software Testing / Toolshop API.

The objective of this project is to validate API functionality, request and response data, authentication, status codes, response fields, and end-to-end API workflows.

**API Documentation:**
https://api-v1.practicesoftwaretesting.com/api/documentation

**API Base URL:**
`https://api-v1.practicesoftwaretesting.com`

The API provides a REST interface for practicing software testing and is documented using OpenAPI/Swagger.

---

## 🛠️ Tools & Technologies

* Postman
* REST API
* HTTP Methods
* JavaScript
* JSON
* Postman Collection
* Postman Environment Variables
* API Assertions
* Collection Runner

---

## 📂 Project Structure

```text
Postman
│
├── Authentication
│   ├── Register
│   └── Login
│
├── User
│   ├── Get User
│   ├── Update User
│   └── Delete User
│
├── Product
│   ├── Get Products
│   └── Get Product
│
├── Brand
│   └── Get Brands
│
├── Cart
│   ├── Create Cart
│   └── Get Cart
│
└── Invoice
    └── Create Invoice
```

> Folder names can be adjusted to match the actual requests available in the collection.

---

## 🔐 Authentication

Authentication APIs were tested to validate user registration and login functionality.

### Register

**Method:** `POST`

The Register request validates:

* Successful user registration
* HTTP status code
* Response body
* Required response fields
* Error handling for invalid/duplicate data

### Login

**Method:** `POST`

The Login request validates:

* Valid credentials
* Successful authentication
* HTTP status code
* Authentication token
* Response body

The generated authentication token can be stored in a Postman environment variable and reused by subsequent authenticated requests.

---

## 👤 User API Testing

User APIs were tested using different HTTP methods.

### GET User

Validations include:

* Status code
* Response format
* User information
* Required response fields

### UPDATE User

Validations include:

* Request body
* Authorization
* Successful update
* Response status
* Updated user information

### DELETE User

Validations include:

* Authorization
* Successful deletion
* Expected status code
* Response message

---

## 🛒 Product API Testing

Product endpoints were tested to validate product information.

### GET Products

Validations include:

* HTTP status code
* JSON response
* Product collection
* Product IDs
* Product details

### GET Product by ID

Validations include:

* Valid product ID
* HTTP status code
* Response body
* Product details

---

## 🛍️ Cart API Testing

Cart APIs were tested as part of the shopping workflow.

Validations include:

* Cart creation
* Cart ID generation
* Product information
* Response status
* Response body

The generated Cart ID can be stored in an environment variable and reused in subsequent requests.

---

## 🧾 Invoice API Testing

Invoice functionality was tested using the available invoice endpoints.

Validations include:

* Required billing information
* Authorization
* HTTP status code
* Response body
* Invoice information

---

## 🧪 Test Assertions

Postman JavaScript tests were added to validate API responses.

Example:

```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response is JSON", function () {
    pm.response.to.be.json;
});
```

Response data can also be validated using `pm.expect()`.

Example:

```javascript
pm.test("Response contains user data", function () {
    const response = pm.response.json();

    pm.expect(response).to.have.property("id");
});
```

Postman supports post-response scripts for validating status codes, response bodies, headers, and other response data.

---

## 🔄 Environment Variables

Postman environment variables were used to avoid hardcoding dynamic values.

Examples:

```text
baseUrl
token
userId
productId
cartId
brandId
```

Example request:

```text
{{baseUrl}}/products
```

Example token usage:

```text
Authorization: Bearer {{token}}
```

Dynamic IDs generated from one request can be stored and reused in subsequent API requests.

This allows the collection to execute as a workflow rather than treating every request independently.

---

## 🔗 API Workflow

The collection can be executed as an end-to-end workflow:

```text
Register
   ↓
Login
   ↓
Store Authentication Token
   ↓
Get User
   ↓
Get Products
   ↓
Create Cart
   ↓
Store Cart ID
   ↓
Create Invoice
   ↓
Validate Responses
```

Postman collections can be used to organize requests and execute API workflows in sequence.

---

## ✅ Test Scenarios

### Positive Scenarios

* Verify successful user registration
* Verify successful login
* Verify authentication token generation
* Verify user details
* Verify product listing
* Verify product details
* Verify cart creation
* Verify invoice creation
* Verify successful update operations
* Verify successful delete operations

### Negative Scenarios

* Invalid login credentials
* Missing required fields
* Invalid user ID
* Invalid product ID
* Invalid cart information
* Unauthorized API request
* Duplicate registration
* Invalid request body

---

## 📊 Validation Performed

The following validations were implemented:

| Validation           | Status |
| -------------------- | ------ |
| HTTP Status Code     | ✅      |
| Response Body        | ✅      |
| JSON Response        | ✅      |
| Required Fields      | ✅      |
| Dynamic IDs          | ✅      |
| Authentication Token | ✅      |
| Authorization        | ✅      |
| Error Responses      | ✅      |
| Response Messages    | ✅      |
| End-to-End Workflow  | ✅      |

---

## ▶️ Collection Execution

The complete collection can be executed using the **Postman Collection Runner**.

The Collection Runner provides results for individual requests and their associated tests.

Example:

```text
Total Requests : XX
Passed         : XX
Failed         : 0
```

---

## 📸 Project Screenshots

Screenshots included in this repository demonstrate:

1. Postman Collection Structure
2. Register API – Request & Response
3. Login API – Authentication & Token
4. GET User API
5. Product API
6. Cart API
7. Invoice API
8. Postman Test Scripts
9. Collection Runner Results

---

## 📁 Repository Contents

```text
Postman/
│
├── README.md
├── Practice_Software_Testing.postman_collection.json
├── Practice_Software_Testing.postman_environment.json
└── screenshots/
    ├── 01_Collection_Structure.png
    ├── 02_Register.png
    ├── 03_Login.png
    ├── 04_Get_User.png
    ├── 05_Product.png
    ├── 06_Cart.png
    ├── 07_Invoice.png
    ├── 08_Test_Assertions.png
    └── 09_Collection_Run.png
```

---

## 🎯 Key Learning

Through this project, I practiced:

* REST API testing
* HTTP methods
* API request/response validation
* JSON validation
* Authentication and authorization
* Bearer token handling
* Environment variables
* Dynamic data handling
* JavaScript assertions
* Positive and negative testing
* API workflow testing
* Postman Collection Runner
* End-to-end API testing

---

## 🔗 References

**Practice Software Testing API Documentation:**
https://api-v1.practicesoftwaretesting.com/api/documentation

**Practice Software Testing Project:**
https://github.com/testsmith-io/practice-software-testing

**Postman Documentation:**
https://learning.postman.com/docs/getting-started/quick-start

---

## 👨‍💻 Author

**Kunal Patil**

API Testing | Postman | REST API | Selenium Java | Automation Testing
