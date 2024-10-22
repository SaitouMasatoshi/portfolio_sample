package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.AttendanceTimes;
import com.example.demo.form.AttendanceSearchForm;
import com.example.demo.service.AttendanceTimesService;

import java.util.List;



@Controller
public class AttendanceTimesController {

    @Autowired
    private AttendanceTimesService attendanceTimesService;

    // 検索フォームを表示
    @GetMapping("/attendance/form")
    public String showSearchForm() {
        return "search_form";
    }

    // POSTでフォームから検索条件を受け取る
    @PostMapping("/attendance/search")
    public String searchAttendanceTimes(
    		@Validated @ModelAttribute AttendanceSearchForm form,
    		BindingResult result,
    		Model model) {
        
        if (result.hasErrors()) {
            // バリデーションエラーがあった場合、エラーメッセージを返す
        	if(result.hasErrors()) {
        		model.addAttribute("validationErrors", result.getAllErrors());
        	}
            return "search_form"; // エラーがある場合、フォームに戻す
        }
        List<AttendanceTimes> attendanceTimes = attendanceTimesService.getAttendanceTimesByUserIdAndReportMonth(form.getUserId(), form.getReportMonth());
        
        //検索結果が0件であった場合の処理
        if(attendanceTimes.isEmpty()) {
        	model.addAttribute("message","検索結果に一致するデータがありません。");
        	return "search_form"; //検索結果が0件の場合、フォームに戻す
        }
        
        model.addAttribute("attendanceList", attendanceTimes);
        return "attendance_list";
    }
}