package com.withoutss.lwr.controllers;

import com.withoutss.lwr.entities.Event;
import com.withoutss.lwr.services.EventService;
import com.withoutss.lwr.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("register-event")
    public ResponseEntity<String> eventRegistration(@RequestBody Event event) {
        if (eventService.registerFunction(event)) {
            return Utils.getResponseEntity("Request submitted Successfully!", HttpStatus.OK);
        } else {
            return Utils.getResponseEntity("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
