package com.codeAlpha.AttendenceManagementSystem.Service;

import com.codeAlpha.AttendenceManagementSystem.Entity.Attendance;


import java.util.List;

public interface AttendanceService {

    public Attendance createAttendance(Attendance attendance);
    public Attendance getAttendanceById (Long id);
    public List<Attendance> getAllAttendance();
    public Attendance updateAttendance(Long id, Attendance updateAttendance);
    public void deleteAttendance(Long id);

}
