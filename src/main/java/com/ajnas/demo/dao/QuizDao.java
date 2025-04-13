package com.ajnas.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajnas.demo.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer>{

    
    // @Autowired
    // QuizDao quizDao;
}
