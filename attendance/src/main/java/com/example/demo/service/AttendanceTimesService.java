package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AttendanceTimes;
import com.example.demo.repository.AttendanceTimesRepository;

import java.util.List;

@Service
public class AttendanceTimesService {

    @Autowired
    private AttendanceTimesRepository attendanceTimesRepository;

    public List<AttendanceTimes> getAttendanceTimesByUserIdAndReportMonth(String userId, Integer reportMonth) {
        return attendanceTimesRepository.findByUserIdAndReportMonth(userId, reportMonth);
    }
}