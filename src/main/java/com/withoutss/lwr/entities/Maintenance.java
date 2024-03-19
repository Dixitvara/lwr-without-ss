package com.withoutss.lwr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Month;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Month month;

    @Column(nullable = false, name = "due_date")
    private LocalDate dueDate;

    @Column(nullable = false, name = "paid_date")
    private LocalDate paidDate;

    @Column(nullable = false)
    private double penalties;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_mem_id")
    private Member member;
}