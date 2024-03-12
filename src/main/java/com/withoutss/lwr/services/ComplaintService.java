package com.withoutss.lwr.services;

import com.withoutss.lwr.entities.Complaint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ComplaintService {
    Boolean registerComplaint(Complaint complaint);
    List<Complaint> getUserComplaints();
    List<Complaint> getAllComplaints();

    Boolean deleteComplaint(Long compId);
}
