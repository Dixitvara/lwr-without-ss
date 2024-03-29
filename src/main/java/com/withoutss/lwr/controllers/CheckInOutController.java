package com.withoutss.lwr.controllers;

import com.withoutss.lwr.entities.CheckInOut;
import com.withoutss.lwr.services.CheckInOutService;
import com.withoutss.lwr.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("lwresident/v1/guest-user")
public class CheckInOutController {

    @Autowired
    private CheckInOutService checkInOutService;

    @PostMapping("/check-in")
    public ResponseEntity<String> checkIn(@RequestBody CheckInOut data) {
        if (checkInOutService.checkInGuest(data)) {
            return Utils.getResponseEntity("Guest user checked in!", HttpStatus.OK);
        } else {
            return Utils.getResponseEntity("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/check-out/{id}")
    public ResponseEntity<String> checkOut(@PathVariable long id)
    {
        if(checkInOutService.checkOutGuest(id))
        {
            return Utils.getResponseEntity("Guest user checked out!", HttpStatus.OK);
        }
        return Utils.getResponseEntity("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/view-checkIn-guest")
    public List<CheckInOut> viewCheckedInGuest()
    {
        return checkInOutService.findCheckedInGuest();
    }

    @GetMapping("/view-guests")
    public List<CheckInOut> viewAllGuest()
    {
        return checkInOutService.findAllGuest();
    }

}