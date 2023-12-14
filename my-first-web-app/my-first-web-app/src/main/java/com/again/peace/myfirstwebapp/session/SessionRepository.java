package com.again.peace.myfirstwebapp.session;

import com.again.peace.myfirstwebapp.session.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Session, String> {
    @Query("select s from Session s where s.sessionId = ?1")
    Session findBySessionId(String sessionId);


}