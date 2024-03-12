package com.withoutss.lwr.services;

import com.withoutss.lwr.entities.Event;
import org.springframework.http.ResponseEntity;

public interface EventService {
    Boolean registerFunction(Event event);
}
