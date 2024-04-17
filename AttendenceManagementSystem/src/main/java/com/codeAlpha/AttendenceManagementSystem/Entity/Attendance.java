package com.codeAlpha.AttendenceManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "AttendanceTbl")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student")
    private String userStudent;
    private String status;
    private String date;

}

