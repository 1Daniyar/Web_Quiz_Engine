package engine.services.quiz;

import engine.models.Quiz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuizRepository extends CrudRepository<Quiz, Integer> {

    @Override
    List<Quiz> findAll();

    @Override
    Quiz save(Quiz quiz);
}
