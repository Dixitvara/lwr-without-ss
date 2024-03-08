package com.withoutss.lwr.services.impl;

import com.withoutss.lwr.entities.Feedback;
import com.withoutss.lwr.repositories.FeedbackRepository;
import com.withoutss.lwr.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public String submitFeedback(Feedback feedBack) {
        try {
            feedbackRepository.save(feedBack);
            return "Feedback successfully submitted!";
        } catch (Exception e) {
            System.out.println("Internal server error in feedback form");
        }
        return "Internal server error(FeedBack)";
    }
}
