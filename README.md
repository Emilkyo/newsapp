# NewsApp

The NewsApp is RESTful API with Spring Boot

### Stack

- spring boot;
- spring web;
- lombok;
- Data JPA + PostgreSQL.

Проверял API через Postman.
![img.png](src%2Fmain%2Fresources%2Fstatic%2Fimg.png)

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

### Database:

Базы данных создаются при сборке, через Hibernate

Кратко, видел создание БД так:
![db.png](src%2Fmain%2Fresources%2Fstatic%2Fdb.png)

но из-за отсутсвия методов урезал до двух баз **news** и **user**.

# Part 2: Security with API token

Я сделал механизм безопасности через создание пользователя.
Например, обновить новость можно только от того юзера, от
кого была создана новость

К сожалению, это всё что получилось.