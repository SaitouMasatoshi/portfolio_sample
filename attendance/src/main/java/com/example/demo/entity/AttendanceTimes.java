package com.example.demo.entity;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendance_times")
public class AttendanceTimes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "report_month")
    private Integer reportMonth;

    @Column(name = "work_start_at")
    private LocalDateTime workStartAt;

    @Column(name = "work_end_at")
    private LocalDateTime workEndAt;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

  //LombokのDataが効かないのでゲッターとセッターを手書き
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getReportMonth() {
		return reportMonth;
	}

	public void setReportMonth(Integer reportMonth) {
		this.reportMonth = reportMonth;
	}

	public LocalDateTime getWorkStartAt() {
		return workStartAt;
	}

	public void setWorkStartAt(LocalDateTime workStartAt) {
		this.workStartAt = workStartAt;
	}

	public LocalDateTime getWorkEndAt() {
		return workEndAt;
	}

	public void setWorkEndAt(LocalDateTime workEndAt) {
		this.workEndAt = workEndAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
    
}