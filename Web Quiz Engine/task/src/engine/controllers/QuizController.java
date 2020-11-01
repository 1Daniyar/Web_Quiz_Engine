package engine.controllers;

import engine.models.Answer;
import engine.models.Quiz;
import engine.models.Response;
import engine.models.User;
import engine.services.quiz.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class QuizController {

    public QuizController() {}

    @Autowired
    QuizServiceImpl quizService;

    @PostMapping("/api/quizzes")
    Quiz createQuiz(@AuthenticationPrincipal User user,
                    @Valid @RequestBody Quiz quiz) {
        try {
            quiz.setUser(user);
            return quizService.createQuiz(quiz);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/quizzes/{id}")
    Quiz getQuiz(@PathVariable("id") int id) {
        Quiz quiz = quizService.getQuizById(id);
        if(quiz == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return quiz;
    }

    @GetMapping("/api/quizzes")
    List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @PostMapping("/api/quizzes/{id}/solve")
    Response solveQuiz(@PathVariable("id") int id, @RequestBody(required = false) Answer answerObj) {
        int[] newAnswer;
        if(answerObj.getAnswer() == null) {
            newAnswer = new int[0];
        } else {
            newAnswer = answerObj.getAnswer();
        }

        Quiz quiz =  quizService.getQuizById(id);
        if(quiz == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (quiz.answerEqualTo(newAnswer)) {
            return Response.CORRECT;
        } else {
            return Response.INCORRECT;
        }
    }

    @DeleteMapping("/api/quizzes/{id}")
    void deleteQuiz(@AuthenticationPrincipal User user,
            @PathVariable int id) {
        Quiz quiz = quizService.getQuizById(id);
        if(quiz == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(user.getId() == quiz.getUser().getId()) {
            quizService.deleteQuiz(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
}
