# Marketplace API - Java 18

![GitHub language count](https://img.shields.io/github/languages/count/deverebor/marketplace-api?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/deverebor/marketplace-api?style=for-the-badge)
![GitHub issues](https://img.shields.io/github/issues/deverebor/marketplace-api?style=for-the-badge)
![GitHub pull requests](https://img.shields.io/github/issues-pr/deverebor/marketplace-api?style=for-the-badge)

---

> This is a simple API made with SpringBoot with deploy on heroku.

## About project

This API came as part of professor Nélio Alves' JAVA course. 
Where I went further and created unit tests and restructured some endpoints.

## Feature list

Marketplace returns the following status codes in its API:

| Functionality                                                | Verb     | Description           | Authentication |
|:-------------------------------------------------------------|:---------|:----------------------|:---------------|
| https://api-marketplace-course.herokuapp.com/user            | `GET`    | Lists all users.      | `FALSE`        |
| https://api-marketplace-course.herokuapp.com/user/{id}       | `GET`    | Lists a user.         | `FALSE`        |
| https://api-marketplace-course.herokuapp.com/order/          | `GET`    | Lists all orders.     | `FALSE`        |
| https://api-marketplace-course.herokuapp.com/order/{id}      | `GET`    | List an order.        | `FALSE`        |
| https://api-marketplace-course.herokuapp.com/categories      | `GET`    | Lists all categories. | `FALSE`        |
| https://api-marketplace-course.herokuapp.com/categories/{id} | `GET`    | Lists a category.     | `FALSE`        |
| https://api-marketplace-course.herokuapp.com/product/        | `GET`    | Lists all products.   | `FALSE`        |
| https://api-marketplace-course.herokuapp.com/product/{id}    | `GET`    | Lists a product.      | `FALSE`        |
| https://api-marketplace-course.herokuapp.com/user/{id}       | `DELETE` | Removes a user.       | `FALSE`        |
| https://api-marketplace-course.herokuapp.com/user/{id}       | `POST`   | Adds a user.          | `FALSE`        |
| https://api-marketplace-course.herokuapp.com/user/{id}       | `PUT`    | Updates a user.       | `FALSE`        |

### Adjustments and improvements

The project is concluded but there are some points of improvement:

- [X] Migrate the database structure to postgresql
- [ ] Add unit tests to routes and their dependencies
- [X] Deploy on HEROKU.

## 💻 Prerequisites

Before you begin, make sure that you have met the following requirements:
* You have installed the version of 'java 18'.
* You have Postman installed to view how the API works ([CLICK HERE to access JSON with requests](./docs/postman)).

## 📫 Contribute to the project
Follow this steps to contribute to the project:

1. Fork this repository.
2. Create a branch: `git checkout -b feat: <nome_branch>`.
3. Make your changes and confirm them: `git commit -m 'feat: <commit>'`.
4. Send to the original branch: `git push deverebor/fastapi-blog-api`
5. Create the pull request.

Alternatively, see the GitHub documentation at https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-requests).

[⬆ Voltar ao topo](#fastapi-blog-api)