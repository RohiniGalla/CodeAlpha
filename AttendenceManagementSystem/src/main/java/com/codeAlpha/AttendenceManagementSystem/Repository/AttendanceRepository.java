package com.codeAlpha.AttendenceManagementSystem.Repository;

import com.codeAlpha.AttendenceManagementSystem.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    public List<Attendance> findByUserStudent(String student);

}
