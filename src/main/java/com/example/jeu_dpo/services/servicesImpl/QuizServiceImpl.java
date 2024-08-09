package com.example.jeu_dpo.services.servicesImpl;

import com.example.jeu_dpo.entities.Answer;
import com.example.jeu_dpo.entities.Question;
import com.example.jeu_dpo.entities.Quiz;
import com.example.jeu_dpo.repositories.AnswerRepository;
import com.example.jeu_dpo.repositories.QuestionRepository;
import com.example.jeu_dpo.repositories.QuizRepository;
import com.example.jeu_dpo.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    /* QUIZ IMPL */
    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuizById(Long id) {
        Optional<Quiz> quizOptional = quizRepository.findById(id);
        if (quizOptional.isPresent()) {
            Quiz quiz = quizOptional.get();
            quiz.getQuestions().forEach(question -> {
                question.getAnswers().size();
            });
            return quiz;
        }
        return null;
    }

    /* QUESTION IMPL */
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    /* ANSWER IMPL */
    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean verifyAnswers(List<Long> answerIds) {
        List<Answer> answers = answerRepository.findAllById(answerIds);
        return answers.stream().allMatch(Answer::isCorrect);
    }
}
