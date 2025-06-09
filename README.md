# 📞 Telecom API

A Spring Boot-based RESTful API for managing telecom entries, allowing users to create, update, and retrieve SIM and plan-related information. It integrates with MongoDB Atlas for cloud-based storage.

---

## 🚀 Features

* Create and manage telecom customer entries
* Store and retrieve all entries or a single entry by SIM Number
* Input validation using Jakarta Bean Validation
* MongoDB Atlas for database storage
* Swagger/OpenAPI UI for API exploration

---

## 🪧 Tech Stack

* Java 21 (Eclipse Temurin)
* Spring Boot 3.x
* Spring Data MongoDB
* Jakarta Validation
* MongoDB Atlas
* Swagger (springdoc-openapi)

---

## 📅 Project Structure

```
telecom-api/
├── src/
│   ├── main/
│   │   ├── java/com/spartified/telecomApi/
│   │   │   └── config/
│   │   │   ├── controller/
│   │   │   ├── entity/
│   │   │   └── exception/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       ├── application.properties
│   └── test/
├── pom.xml
└── README.md
```

---

## 🔧 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/telecom-api.git
cd telecom-api
```

### 2. MongoDB Atlas Setup

* [Sign in to MongoDB Atlas](https://cloud.mongodb.com)
* Create a free cluster
* Add a user with a password
* Allow IP access from anywhere or your machine IP
* Copy the connection string, e.g.,

```
mongodb+srv://<username>:<password>@<cluster>.mongodb.net/telecomdb
```

---

### 3. Environment Variables

* Create a `.env` File in the root directory (if using dotenv library)

```
MONGODB_URI=mongodb+srv://username:password@cluster.mongodb.net/telecomdb
```

## 📅 Run the App

### Local (using Maven)

```bash
./mvnw spring-boot:run
```

---

## 🔍 API Endpoints

Once running, go to: `http://localhost:8080/swagger-ui/index.html`

* `GET /api/telecom/get` – Fetch all entries
* `POST /api/telecom/create` – Create new entry
* `GET /api/telecom/get/{simNumber}` – Fetch by SIM
* `PATCH /api/telecom/modify/{simNumber}` – Modify entry by SIM

---

## 🔒 Input Validations

* SIM number, name, address, plan name, email required
* Email validated for format
* Pattern matching for SIM number, plan name
* SIM number and Email must be unique
* `voiceMinutes` stored in seconds internally
* `dataInternet` stored in bytes (converted from GB)

---

## 🌟 Author

**Bharat Aggarwal**

* GitHub: [https://github.com/bharat-dir96]

---
