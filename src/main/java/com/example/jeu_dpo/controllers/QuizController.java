package com.example.jeu_dpo.controllers;

import com.example.jeu_dpo.entities.Answer;
import com.example.jeu_dpo.entities.Question;
import com.example.jeu_dpo.entities.Quiz;
import com.example.jeu_dpo.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    /* QUIZ */
    @GetMapping("/listQuizzes")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        return ResponseEntity.ok(quiz);
    }

    /* QUESTION */
    @GetMapping("/listQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = quizService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/getQuestion/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = quizService.getQuestionById(id);
        return ResponseEntity.ok(question);
    }

    /* ANSWER */
    @GetMapping("/listAnswers")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = quizService.getAllAnswers();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/getAnswer/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        Answer answer = quizService.getAnswerById(id);
        return ResponseEntity.ok(answer);
    }

    @PostMapping("/verifyAnswers")
    public ResponseEntity<Boolean> verifyAnswers(@RequestBody List<Long> answerIds) {
        boolean result = quizService.verifyAnswers(answerIds);
        return ResponseEntity.ok(result);
    }

}
