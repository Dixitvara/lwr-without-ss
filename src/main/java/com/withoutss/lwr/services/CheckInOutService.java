package com.withoutss.lwr.services;

import com.withoutss.lwr.entities.CheckInOut;
import org.hibernate.annotations.Check;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CheckInOutService {
    Boolean checkInGuest(CheckInOut data);
    Boolean checkOutGuest(String name);
    List<CheckInOut> findCheckedInGuest();
}
