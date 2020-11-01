package engine.services.quiz;

import engine.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository repository;

    @Override
    public List<Quiz> getAllQuizzes() {
        return repository.findAll();
    }

    @Override
    public Quiz getQuizById(int id) {
        if(repository.findById(id).isPresent())
            return repository.findById(id).get();
        return null;
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    @Override
    public void deleteQuiz(int id) {
        repository.deleteById(id);
    }
}
