package com.codeAlpha.AttendenceManagementSystem.Service.ServiceImpl;

import com.codeAlpha.AttendenceManagementSystem.Entity.Attendance;

import com.codeAlpha.AttendenceManagementSystem.Repository.AttendanceRepository;
import com.codeAlpha.AttendenceManagementSystem.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;


    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;

    }


    @Override
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }


    @Override
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance updateAttendance(Long id, Attendance updateAttendance) {
        Attendance existingAttendance = attendanceRepository.findById(id).orElse(null);
        if (existingAttendance != null) {
            existingAttendance.setUserStudent(updateAttendance.getUserStudent());
            existingAttendance.setStatus(updateAttendance.getStatus());
            existingAttendance.setDate(updateAttendance.getDate());
            return attendanceRepository.save(existingAttendance);
        }
        return null;
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    public List<Attendance> getAttendanceByUserName(String userStudent) {
        return attendanceRepository.findByUserStudent(userStudent);
    }


}
