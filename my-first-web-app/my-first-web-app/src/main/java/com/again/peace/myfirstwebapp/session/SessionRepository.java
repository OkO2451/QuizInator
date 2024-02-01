package com.again.peace.myfirstwebapp.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Quizz, Long> {
    @Query("select s from Quizz s where s.sessionId = ?1")
    Quizz findBySessionId(String sessionId);


}