package com.example.jeu_dpo.services.servicesImpl;

import com.example.jeu_dpo.entities.Answer;
import com.example.jeu_dpo.entities.Question;
import com.example.jeu_dpo.entities.Quiz;
import com.example.jeu_dpo.repositories.AnswerRepository;
import com.example.jeu_dpo.repositories.QuestionRepository;
import com.example.jeu_dpo.repositories.QuizRepository;
import com.example.jeu_dpo.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;


    /* QUIZ IMPL */
    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
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
}
