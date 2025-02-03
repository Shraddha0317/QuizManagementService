# QuizManagementService
Quiz-Management(admin)






USER-
For QuizTakingService:-

1)Start a Quiz Attempt
Request
POST http://localhost:8080/quiz-taking/start/{quizId}
-Get jwt token by login 
-To authenticate the request:Add the Authorization Header
-Go to the Headers tab.

Key: Authorization
Value: JWT_TOKEN
By heat the rquest we get json respose -
[
{
"id": "attempt-id",
"userId": "user-id",
"quizId": "quiz-id",
"score": 0,
"completed": false
}

]


2)Submit an Answer:

Request
POST http://localhost:8080/quiz-taking/submit
Add Authorization header with JWT Token.
and pass param {
"attemptId": "attempt-id",
"questionId": "question-id",
"answer": "selected-answer"
}


we get reponse like :
{
"id": "attempt-id",
"userId": "user-id",
"quizId": "quiz-id",
"score": 1,
"completed": false
}
