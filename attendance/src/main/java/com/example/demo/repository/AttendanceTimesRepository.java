package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AttendanceTimes;

import java.util.List;

@Repository
public interface AttendanceTimesRepository extends JpaRepository<AttendanceTimes, Long> {
    List<AttendanceTimes> findByUserIdAndReportMonth(String userId, Integer reportMonth);
}