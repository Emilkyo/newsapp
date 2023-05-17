# NewsApp

The NewsApp is RESTful API with Spring Boot

### Stack

- spring boot;
- spring web;
- lombok;
- Data JPA + PostgreSQL.

Проверял API через Postman.

# Part 1: REST service

## Created methods

| Method | Endpoint                          | Description                  |
|--------|-----------------------------------|------------------------------|
| POST   | /users                            | Create users                 |
| GET    | /users/{userId}                   | Get user by id               |
| DEL    | /users/del?id={userId}            | Delete user by id            |
| POST   | /news?userId={userId}             | Create news by user          |
| PUT    | /news/{newsId}?userId={userId}    | Update news by id            |
| GET    | /news/{id}                        | Get news by id               |
| GET    | /news/all?page={page}&size={size} | Get all news with pagination |
| DELETE | /news/del?id={id}                 | Delete news by id            |

_Примечание: при удалении пользователя удаляются все его новости._


# Part 2: Security with API token

Я сделал механизм безопасности через создание пользователя.

К сожалению, это всё что смог.