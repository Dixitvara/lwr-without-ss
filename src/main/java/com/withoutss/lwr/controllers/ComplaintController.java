package com.withoutss.lwr.controllers;

import com.withoutss.lwr.entities.Complaint;
import com.withoutss.lwr.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("api/v1/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/register-complaint")
    public ResponseEntity<String> registerComplaint(@RequestBody Complaint complaint)
    {
        return ResponseEntity.ok(complaintService.registerComplaint(complaint));
    }

    @GetMapping("/view-my-complaints")
    public List<Complaint> getComplaint(long id)
    {
        return complaintService.getUserComplaints(id);
    }
}
