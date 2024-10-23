package com.microsoft.ssm.mapper;

import com.microsoft.ssm.pojo.Schedule;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
public interface ScheduleMapper {
    List<Schedule> queryPage();

    void insert(Schedule schedule);

    void delete(Integer id);

    int update(Schedule schedule);
}
