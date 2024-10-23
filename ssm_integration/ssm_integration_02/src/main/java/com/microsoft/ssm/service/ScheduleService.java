package com.microsoft.ssm.service;

import com.microsoft.ssm.pojo.Schedule;
import com.microsoft.ssm.utils.PageBean;
import com.microsoft.ssm.utils.R;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
public interface ScheduleService {
    PageBean<Schedule> findByPage(int pageSize, int currentPage);

    void saveSchedule(Schedule schedule);

    void removeById(Integer id);

    R updateSchedule(Schedule schedule);
}
