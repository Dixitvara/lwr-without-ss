package com.withoutss.lwr.controllers;

import com.withoutss.lwr.entities.Feedback;
import com.withoutss.lwr.services.FeedBackService;
import com.withoutss.lwr.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class FeedbackController {
    @Autowired
    private FeedBackService feedBackService;

    @PostMapping("/feedback")
    public ResponseEntity<String> feedback(@RequestBody Feedback request) {
        if(feedBackService.submitFeedback(request)) {
            return Utils.getResponseEntity("Feedback submitted successfully", HttpStatus.OK);
        }
        else{
            return Utils.getResponseEntity("Internal server error", HttpStatus.OK);
        }
    }
}
