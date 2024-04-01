package com.withoutss.lwr.services.impl;

import com.withoutss.lwr.entities.Event;
import com.withoutss.lwr.entities.Member;
import com.withoutss.lwr.repositories.EventRepository;
import com.withoutss.lwr.repositories.MemberRepository;
import com.withoutss.lwr.services.EventService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    @Override
    public List<Event> getMyEvents(Long fkId) {
        return eventRepository.findAllByFkMemId(fkId);
    }

    // method for checking date is available in DB or not
    @Override
    public Event checkDate(LocalDate date1, LocalDate date2) {
        var record = eventRepository.findEventByDates(date1, date2);

        if (record == null)
            return null;
        else
            return record;
    }
}
