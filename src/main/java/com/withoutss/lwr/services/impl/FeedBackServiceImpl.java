package com.withoutss.lwr.services.impl;

import com.withoutss.lwr.entities.Feedback;
import com.withoutss.lwr.repositories.FeedbackRepository;
import com.withoutss.lwr.services.FeedBackService;
import com.withoutss.lwr.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Boolean submitFeedback(Feedback feedBack) {
        try {
            feedbackRepository.save(feedBack);
            return true;
        } catch (Exception e) {
            System.out.println("Internal server error in feedback form");
        }
        return false;
    }

}
