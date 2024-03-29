package com.withoutss.lwr.services.impl;

import com.withoutss.lwr.entities.Maintenance;
import com.withoutss.lwr.entities.Member;
import com.withoutss.lwr.entities.Status;
import com.withoutss.lwr.repositories.MaintenanceRepository;
import com.withoutss.lwr.repositories.MemberRepository;
import com.withoutss.lwr.services.MaintenanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Component
public class MaintenanceServiceImpl implements MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    // schedule for 1st date of every month at 10 o clock
    // format : seconds minutes hours date month dayOfWeek year
    //    @Scheduled(cron = "0 0 10 1 * ?")
    @Scheduled(fixedRate = 5000)
    public Maintenance generateMaintenance() {

        LocalDate generateDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
        LocalDate dueDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1 + 19);

        Maintenance maintenance = new Maintenance();

        maintenance.setAmount(1000.00);
        maintenance.setMonth(LocalDate.now().getMonth());
        maintenance.setPenalties(0.00);
        maintenance.setDueDate(dueDate);
        maintenance.setDueAmount(1000);
        maintenance.setPaidDate(null);
        maintenance.setStatus(Status.UNPAID);

        return maintenance;
    }

    // method that returns all available member IDs from database
    private List<Long> getAllMemberIds() {
        return memberRepository.getAllId();
    }

    public Maintenance checkMaintenanceValue(String email) {
        Member member = memberRepository.findByEmail(email);
        return null;
    }

}