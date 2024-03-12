package com.withoutss.lwr.services.impl;

import com.withoutss.lwr.entities.Event;
import com.withoutss.lwr.entities.Member;
import com.withoutss.lwr.repositories.EventRepository;
import com.withoutss.lwr.repositories.MemberRepository;
import com.withoutss.lwr.services.EventService;
import com.withoutss.lwr.utils.Utils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private HttpSession session;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Boolean registerFunction(Event event) {
        try {
            Long id = (long) session.getAttribute("userId");
            Member member = memberRepository.findById(id).orElse(null);

            if (member != null) {
                event.setMember(member);
                eventRepository.save(event);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
