package com.ajnas.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajnas.demo.dao.QuestionDao;
import com.ajnas.demo.dao.QuizDao;
import com.ajnas.demo.model.Quiz;
import com.ajnas.demo.model.Question;
import com.ajnas.demo.model.QuestionWrapper;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
       System.out.println("fjnkdfjknjnkfjndfjndfjnfdjnkdf");
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("created",HttpStatus.CREATED);


    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz =  quizDao.findById(id);
       List<Question> questionsFromDB = quiz.get().getQuestions();
       List<QuestionWrapper> questionsForUser  = new ArrayList<>();
       for(Question q : questionsFromDB) {
         QuestionWrapper qw = new  QuestionWrapper(q.getId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(), q.getQuestiontype());
         questionsForUser.add(qw);
       }

       return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }
    
}
