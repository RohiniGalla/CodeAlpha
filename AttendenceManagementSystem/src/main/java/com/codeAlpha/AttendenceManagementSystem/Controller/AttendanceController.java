package com.codeAlpha.AttendenceManagementSystem.Controller;

import com.codeAlpha.AttendenceManagementSystem.Entity.Attendance;
import com.codeAlpha.AttendenceManagementSystem.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
//http://localhost:8082/api/attendance
    @PostMapping()
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance){
        Attendance createAttendance = attendanceService.createAttendance(attendance);
        return new ResponseEntity<>(createAttendance, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id){
        Attendance attendanceById = attendanceService.getAttendanceById(id);
        if(attendanceById != null){
            return   new ResponseEntity<>(attendanceById, HttpStatus.OK);

        }
        return new ResponseEntity<>(attendanceById,HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<Attendance>> getAllAttendanceByStudentId() {
        List<Attendance> allAttendance = attendanceService.getAllAttendance();
        return new ResponseEntity<>(allAttendance,HttpStatus.OK);
    }
   @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id,@RequestBody Attendance attendance){
       Attendance updateattendanceById = attendanceService.updateAttendance(id, attendance);
       if(updateattendanceById != null){
           return   new ResponseEntity<>(updateattendanceById, HttpStatus.OK);

       }
       return new ResponseEntity<>(updateattendanceById,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id){
      attendanceService.deleteAttendance(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
