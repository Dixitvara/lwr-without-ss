package com.withoutss.lwr.services.impl;

import com.withoutss.lwr.entities.Complaint;
import com.withoutss.lwr.entities.Member;
import com.withoutss.lwr.repositories.ComplaintRepository;
import com.withoutss.lwr.repositories.MemberRepository;
import com.withoutss.lwr.services.ComplaintService;
import com.withoutss.lwr.utils.Utils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private HttpSession session;

    @Override
    public String registerComplaint(Complaint complaint) {

        // getting the logged in user id
        long id = (long) session.getAttribute("userId");
        Member member = memberRepository.findById(id).orElse(null);

        if (member != null) {
            complaint.setMember(member);
            complaintRepository.save(complaint);

            // saving the complaint to the database
            return "Complaint registered successfully";
        } else {
            return "Internal server error";
        }

    }
}
