package com.microsoft.schedule.service;

import com.microsoft.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleService {
    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule sysSchedule);

    void removeItem(Integer sid);
}
