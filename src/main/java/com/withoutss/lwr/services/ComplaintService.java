package com.withoutss.lwr.services;

import com.withoutss.lwr.entities.Complaint;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComplaintService {
    Boolean registerComplaint(Complaint complaint);
    List<Complaint> getUserComplaints();
}
