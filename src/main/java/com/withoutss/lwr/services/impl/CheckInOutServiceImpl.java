package com.withoutss.lwr.services.impl;

import com.withoutss.lwr.entities.CheckInOut;
import com.withoutss.lwr.entities.CheckedStatus;
import com.withoutss.lwr.repositories.CheckInOutRepository;
import com.withoutss.lwr.services.CheckInOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class CheckInOutServiceImpl implements CheckInOutService {
    @Autowired
    private CheckInOutRepository checkInOutRepository;

    @Override
    public Boolean checkInGuest(CheckInOut data) {
        data.setCheckIn(LocalDateTime.now());
        data.setStatus(CheckedStatus.CHECKED_IN);
        checkInOutRepository.save(data);
        log.info("user checked in!");
        return true;
    }

    @Override
    public Boolean checkOutGuest(Long id) {
        CheckInOut userRecord = checkInOutRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        userRecord.setCheckOut(LocalDateTime.now());
        userRecord.setStatus(CheckedStatus.CHECKED_OUT);
        checkInOutRepository.save(userRecord);
        return true;
    }

    @Override
    public List<CheckInOut> findAllGuest() {
        return checkInOutRepository.findAll();
    }

    @Override
    public List<CheckInOut> findCheckedInGuest() {
        return checkInOutRepository.findAllByStatus();
    }
}