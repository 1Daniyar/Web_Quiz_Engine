# Web_Quiz_Engine
In this project, I will develop a multi-users web service for creating and solving quizzes.

1) Develop a simple JSON API that always returns the same quiz to be solved. 
The API supports two operations: getting the quiz and solving it by passing an answer.
To test my API I'm using a rest client postman.
1.1) To create a new quiz, the client needs to send a JSON as the request's body via 
POST to /api/quizzes.
1.2)To solve the quiz, the client sends a POST request to /api/quizzes/{id}/solve and passes 
the answer parameter in the content.
If the specified quiz does not exist, the server returns the 404 (Not found) status code.
1.3) Validate data in the API
title: required;
text: required;
options: an array of strings, required, should contain at least 2 items;
2) Moving quizzes to DB, so that after restarting the service we will not lose all quizzes 
created by the users.
3) User authorization.
Here are two operations to be added:
- register a new user, which accepts an email as the login and a password;
- deleting a quiz created by the current user.

In this project, I studied REST API, an embedded database, security, and other technologies.

Stack of technologies: Java, Spring, Spring Security, REST API, Jackson, JPA, H2 database
