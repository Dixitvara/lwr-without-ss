package com.withoutss.lwr.services.impl;

import com.withoutss.lwr.entities.CheckInOut;
import com.withoutss.lwr.entities.CheckedStatus;
import com.withoutss.lwr.repositories.CheckInOutRepository;
import com.withoutss.lwr.services.CheckInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CheckInOutServiceImpl implements CheckInOutService {
    @Autowired
    private CheckInOutRepository checkInOutRepository;

    @Override
    public Boolean checkInGuest(CheckInOut data) {
        data.setCheckIn(LocalDateTime.now());
        data.setStatus(CheckedStatus.CHECKED_IN);
        checkInOutRepository.save(data);
        return true;
    }

    @Override
    public Boolean checkOutGuest(String name) {
        CheckInOut userRecord = checkInOutRepository.findByName(name);
        userRecord.setCheckOut(LocalDateTime.now());
        userRecord.setStatus(CheckedStatus.CHECKED_OUT);
        checkInOutRepository.save(userRecord);
        return true;
    }
}
