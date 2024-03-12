package com.withoutss.lwr.controllers;

import com.withoutss.lwr.entities.Complaint;
import com.withoutss.lwr.services.ComplaintService;
import com.withoutss.lwr.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/register-complaint")
    public ResponseEntity<String> registerComplaint(@RequestBody Complaint complaint) {
        if (complaintService.registerComplaint(complaint)) {
            return Utils.getResponseEntity("Complaint registered successfully", HttpStatus.OK);
        } else {
            return Utils.getResponseEntity("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/view-my-complaints")
    public List<Complaint> getComplaint() {
        return complaintService.getUserComplaints();
    }

}
