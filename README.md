# Marvel API Project Documentation

## Description
This project **aims to demonstrate how a developer's skills in API implementation, database management, and user authentication are evaluated**. The project is an application that interacts with the Marvel API to retrieve information about characters and comics. Below is a general description of the main components and functionalities of the project.

- Technical test document: [click here](./src/main/resources/Prueba%20técnica%20para%20desarrollador%20backend%20v1%20-%20davivienda.docx)

## Features
The backend developer technical test project consists of developing an API **using Java technology with the Spring Boot framework**. This API aims to consume the Marvel API, whose documentation can be found **[here](https://developer.marvel.com/)**. Below are the main features of this project:

1. **Marvel API Consumption**: The developed application is responsible for consuming the Marvel API, obtaining relevant information about characters, comics, series, and more.

2. **Database Storage**: A database schema, preferably MySQL, is implemented to store all necessary information. This includes data related to characters, comics, and series.

3. **Information Supply API**: An API is created to offer various functionalities to obtain Marvel information, including:
    - Searching for Marvel characters by name, comics, and series.
    - Retrieving a list of comics associated with a specific character.
    - Accessing the image and description of a particular character.
    - A complete list of available comics.
    - Filtering comics by identifier.
    - Viewing searches related to comics performed by any user.
    - Recording specific searches of a particular user.

5. **Authentication with Spring Security**: The API implements an authentication method and scheme using Spring Security. This allows identifying which user is making searches in the Marvel information.

6. **Database Scripts**: The application's README file includes database scripts containing initial data necessary to execute the APIs for the first time.

## Configuration
Before running the application, it is necessary to configure the following properties in the `application.properties` file:

```properties
integration.marvel.public-key=<Your Marvel public key>
integration.marvel.private-key=<Your Marvel private key>
```
Make sure to obtain these keys from the Marvel API ([click to obtain](https://developer.marvel.com/)) and replace `<Your Marvel public key>` and `<Your Marvel private key>` with your actual keys.

Additionally, you must configure the corresponding properties for MySQL in the `application-dev.properties` file:
```properties
spring.datasource.url=jdbc:mysql://<Your host>:<Your port>/<Your database>
spring.datasource.username=<Your username>
spring.datasource.password=<Your password>
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
```

## Project Packages
The project is organized into the following packages:

- `com.marvel.test.dto.response`: Contains DTO classes for responses.
- `com.marvel.test.exception`: Includes classes related to custom exceptions.
- `com.marvel.test.mapper`: Contains mappers to convert between entities and DTOs.
- `com.marvel.test.util`: Provides generic utilities.
- `com.marvel.test.persistence.entity`: Defines database entities.
- `com.marvel.test.persistence.integration.marvel`: Manages integration with the Marvel API.
- `com.marvel.test.persistence.integration.marvel.dto`: Defines specific DTOs for Marvel integration.
- `com.marvel.test.persistence.integration.marvel.mapper`: Maps objects from the Marvel API to local objects.
- `com.marvel.test.persistence.integration.marvel.util`: Contains utilities for Marvel integration.
- `com.marvel.test.persistence.repository`: Defines repositories for database access.
- `com.marvel.test.security`: Contains security and authentication configurations.
- `com.marvel.test.security.validator`: Contains security validators.
- `com.marvel.test.service`: Defines service interfaces.
- `com.marvel.test.service.impl`: Implements services.
- `com.marvel.test.web.controller`: Web controllers to handle API requests.
- `com.marvel.test.web.filter`: Filters to intercept web requests.
- `com.marvel.test.web.interceptor`: Request interceptors.

## Main Classes
Below are descriptions of some of the project's main classes:

### `MarvelAPIConfig`
- Configuration class responsible for providing Marvel's public and private keys and managing authentication in Marvel API requests.

### `ComicRepository`
- Repository that interacts with the Marvel API to retrieve comic information. Provides methods to search for comics related to characters and search for comics by ID.

### `CharacterRepository`
- Repository that connects to the Marvel API to obtain character information. Contains methods to search for characters by criteria and retrieve detailed character information by ID.

### `JwtService`
- Service for generating and validating JWT tokens. Used for authentication in the application.

### `ComicService` and `CharacterService`
- Service interfaces that define operations related to comics and characters. Their implementations are found in `ComicServiceImpl` and `CharacterServiceImpl`, respectively.

### Controllers
- Controllers such as `ComicController`, `CharacterController`, and `AuthenticationController` handle HTTP requests and respond with data to clients.

### Filters and Interceptors
- Filters and interceptors, such as `JwtAuthenticationFilter` and `UserInteractionInterceptor`, add security and logging functionality to the application.

### `UserInteractionLog` and Repository
- The `UserInteractionLog` entity and its repository manage logs of user interactions with the application.

## Exception Handling
The project includes an exception handling system that ensures an appropriate response to different types of errors, such as authentication errors and request errors to the Marvel API. Exception handling is performed through the `GlobalExceptionHandler` class.

## SQL Scripts
The project includes the necessary configuration for tables to be automatically created when running the project.
By default, this configuration is commented out, but it can be enabled by uncommenting the following property:

```properties
spring.jpa.hibernate.ddl-auto=update
```

You can also execute the scripts individually:
- Table creation: [click](./src/main/resources/marvel_app.sql)
- Record creation (INSERTS): [click](./src/main/resources/data-mysql.sql)

## Spring Security: Users and Roles
The scripts include the creation of two roles and two users. These roles are **"CUSTOMER" and "AUDITOR"**, and the two users are **"lmarquez" and "gcanas" with passwords "contrasena123" and "contrasena456"**, respectively.
The permissions for the **"CUSTOMER"** role are:
- character:read-all
- character:read-detail
- comic:read-all
- comic:read-by-id
- user-interaction:read-my-interactions

The permissions for the **"AUDITOR"** role are:
- character:read-all
- character:read-detail
- comic:read-all
- comic:read-by-id
- user-interaction:read-my-interactions
- user-interaction:read-all
- user-interaction:read-by-username

## Postman
If desired, the following collection can be imported into Postman to take the author's tests as a starting point. [Click here to view the Postman collection](./src/main/resources/Marvel%20Test.postman_collection.json)

## Summary
This document provides an overview of the project structure, its key components, and how to configure the Marvel API keys. Make sure to configure the keys correctly before running the application to ensure it works properly.

