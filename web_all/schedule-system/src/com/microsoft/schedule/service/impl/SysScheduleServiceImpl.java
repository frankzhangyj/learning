package com.microsoft.schedule.service.impl;

import com.microsoft.schedule.dao.SysScheduleDao;
import com.microsoft.schedule.dao.impl.SysScheduleDaoImpl;
import com.microsoft.schedule.pojo.SysSchedule;
import com.microsoft.schedule.service.SysScheduleService;

import java.util.List;

public class SysScheduleServiceImpl implements SysScheduleService {
    private SysScheduleDao scheduleDao = new SysScheduleDaoImpl();

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        return scheduleDao.findItemListByUid(uid);
    }

    @Override
    public Integer addDefault(int uid) {
        return scheduleDao.addDefault(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule sysSchedule) {
        return scheduleDao.updateSchedule(sysSchedule);
    }

    @Override
    public void removeItem(Integer sid) {
        scheduleDao.removeItem(sid);
    }
}
