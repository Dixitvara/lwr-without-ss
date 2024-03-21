package com.withoutss.lwr.controllers;

import com.withoutss.lwr.entities.Event;
import com.withoutss.lwr.repositories.MemberRepository;
import com.withoutss.lwr.services.EventService;
import com.withoutss.lwr.utils.Utils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/lwresident/v1/events")
public class EventController {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    HttpSession session;
    @Autowired
    EventService eventService;

    @PostMapping("/register-event")
    public ResponseEntity<String> eventRegistration(@RequestBody Event event) {
        if (eventService.registerFunction(event)) {
            return Utils.getResponseEntity("Request submitted Successfully!", HttpStatus.OK);
        } else {
            return Utils.getResponseEntity("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/view-my-events")
    public List<Event> viewMyEvents() {
        Long id = (long) session.getAttribute("userId");
        return eventService.getMyEvents(id);
    }

    // problem in this api

//    @PostMapping("/checkBookings")
//    public ResponseEntity<String> checkDate(@RequestParam LocalDate date, @RequestParam LocalDate date2) {
//        if (eventService.checkDate(date, date2))
//            return new ResponseEntity<>("Bookings available", HttpStatus.OK);
//        if (!eventService.checkDate(date, date2))
//            return new ResponseEntity<>("Bookings not available", HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
