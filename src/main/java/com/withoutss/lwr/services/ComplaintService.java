package com.withoutss.lwr.services;

import com.withoutss.lwr.entities.Complaint;

import java.util.List;

public interface ComplaintService {
    String registerComplaint(Complaint complaint);
    List<Complaint> getUserComplaints(long id);
}
