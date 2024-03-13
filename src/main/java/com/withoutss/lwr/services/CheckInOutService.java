package com.withoutss.lwr.services;

import com.withoutss.lwr.entities.CheckInOut;

public interface CheckInOutService {
    Boolean checkInGuest(CheckInOut data);
    Boolean checkOutGuest(String name);
}
