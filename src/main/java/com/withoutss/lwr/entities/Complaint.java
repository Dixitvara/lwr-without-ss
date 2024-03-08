package com.withoutss.lwr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {
    @Id
    @Column(name = "compid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long compId;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_mem_id")
    private Member member;

}
