# NewsApp

The NewsApp is a RESTful API developed with Spring Boot, powered by Java 17.

## Technology Stack
- Java 17
- Spring Boot
- Spring Web
- Lombok
- Data JPA + PostgreSQL, Hibernate

Verified API using Postman.

![API Image](src%2Fmain%2Fresources%2Fstatic%2Fimg.png)

## REST Service

### Created Methods

| Method | Endpoint                          | Description                      |
|--------|-----------------------------------|----------------------------------|
| POST   | /users                            | Create users                     |
| GET    | /users/{userId}                   | Retrieve user by ID              |
| DELETE | /users/del?id={userId}            | Delete user by ID                |
| POST   | /news?userId={userId}             | Create news by user              |
| PUT    | /news/{newsId}?userId={userId}    | Update news by ID                |
| GET    | /news/{id}                        | Retrieve news by ID              |
| GET    | /news/all?page={page}&size={size} | Retrieve all news with pagination|
| DELETE | /news/del?id={id}                 | Delete news by ID                |

**Note:** Deleting a user will also delete all associated news.

### Database:

Databases are created during the build process using Hibernate. A simplified view of the database creation is as follows:

![DB Image](src%2Fmain%2Fresources%2Fstatic%2Fdb.png)

The databases have been streamlined to two: **news** and **user**.
