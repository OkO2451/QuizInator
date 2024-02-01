package com.again.peace.myfirstwebapp.session;

import com.again.peace.myfirstwebapp.user.User;
import com.again.peace.myfirstwebapp.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller("/Quizz")
public class QuizController {

    public QuizController() {
    }

    QuizController(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    private SessionRepository sessionRepository;

    @PostMapping("/findQuiz")
    public ResponseEntity<Quizz> createUser(@RequestBody Quizz quizz) {
        Quizz savedQuiz = sessionRepository.save(quizz);
        return ResponseEntity.ok(savedQuiz);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<Quizz> findByid(@PathVariable Long sessionId) {
        Optional<Quizz> quizz = sessionRepository.findById(sessionId);
        return quizz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}