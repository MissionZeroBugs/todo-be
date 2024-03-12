package com.missionzerobugs.todobe.Dto;


import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class TodoTask {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String taskName;

}
