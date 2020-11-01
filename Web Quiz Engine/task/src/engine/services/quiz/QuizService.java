package engine.services.quiz;

import engine.models.Quiz;

import java.util.List;

public interface QuizService {

    List<Quiz> getAllQuizzes();

    Quiz getQuizById(int id);

    Quiz createQuiz(Quiz quiz);

    void deleteQuiz(int id);
}
