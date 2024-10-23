package com.microsoft.schedule.dao;

import com.microsoft.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {

    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule sysSchedule);

    void removeItem(Integer sid);
}
