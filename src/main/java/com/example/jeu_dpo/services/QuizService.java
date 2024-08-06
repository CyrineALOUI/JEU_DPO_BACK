package com.example.jeu_dpo.services;

import com.example.jeu_dpo.entities.Answer;
import com.example.jeu_dpo.entities.Question;
import com.example.jeu_dpo.entities.Quiz;

import java.util.List;

public interface QuizService {

    /* QUIZ SERVICES */
    public List<Quiz> getAllQuizzes();
    public Quiz getQuizById(Long id);

    /* QUESTION SERVICES */
    public List<Question> getAllQuestions();
    public Question getQuestionById(Long id);

    /* ANSWER SERVICES */
    public List<Answer> getAllAnswers();
    public Answer getAnswerById(Long id);
    boolean verifyAnswers(List<Long> answerIds);
}
