package com.microsoft.ssm.controller;

import com.microsoft.ssm.pojo.Schedule;
import com.microsoft.ssm.service.ScheduleService;
import com.microsoft.ssm.utils.PageBean;
import com.microsoft.ssm.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
@CrossOrigin
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{pageSize}/{currentPage}")
    public R showList(@PathVariable(name = "pageSize") int pageSize,
                      @PathVariable(name = "currentPage") int currentPage) {
        PageBean<Schedule> pageBean = scheduleService.findByPage(pageSize, currentPage);
        return R.ok(pageBean);
    }

    @PostMapping
    public R saveSchedule(@Validated @RequestBody Schedule schedule, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return R.fail("param error");
        }
        scheduleService.saveSchedule(schedule);
        return R.ok(null);
    }

    @DeleteMapping("/{id}")
    public R removeSchedule(@PathVariable Integer id){
        scheduleService.removeById(id);
        return R.ok(null);
    }

    @PutMapping
    public R changeSchedule(@Validated @RequestBody Schedule schedule, BindingResult BindingResult){
        if (BindingResult.hasErrors()) {
            return R.fail("param error");
        }
        R resault = scheduleService.updateSchedule(schedule);
        return resault;
    }
}
