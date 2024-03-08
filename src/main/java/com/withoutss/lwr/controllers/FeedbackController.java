package com.withoutss.lwr.controllers;

import com.withoutss.lwr.entities.Feedback;
import com.withoutss.lwr.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class FeedbackController {
    @Autowired
    private FeedBackService feedBackService;

    @PostMapping("/feedback")
    public ResponseEntity<String> feedback(@RequestBody Feedback request){
        return ResponseEntity.ok(feedBackService.submitFeedback(request));
    }
}
