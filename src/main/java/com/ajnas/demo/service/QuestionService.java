package com.ajnas.demo.service;
import com.ajnas.demo.Question;
import com.ajnas.demo.dao.QuestionDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }
    public String addQuestion(Question question) {
       questionDao.save(question);
       return "success";
    }
}
