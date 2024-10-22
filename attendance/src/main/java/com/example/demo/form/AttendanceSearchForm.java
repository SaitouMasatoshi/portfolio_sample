package com.example.demo.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AttendanceSearchForm {

    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "User IDは英数字のみです。")
    private String userId;

    @Min(value = 1, message = "Report Monthは1以上である必要があります。")
    @Max(value = 12, message = "Report Monthは12以下である必要があります。")
    private Integer reportMonth;

    //またLombokのDataが効かない...
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
}