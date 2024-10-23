package com.microsoft.schedule.dao.impl;

import com.microsoft.schedule.dao.BaseDao;
import com.microsoft.schedule.dao.SysScheduleDao;
import com.microsoft.schedule.pojo.SysSchedule;

import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        String sql = "select sid, uid, title, completed from sys_schedule where uid = ?";

        return baseQuery(SysSchedule.class, sql, uid);
    }

    @Override
    public Integer addDefault(int uid) {
        String sql = "insert into sys_schedule value(default,?,'请输入日程',0)";
        return baseUpdate(sql,uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule sysSchedule) {
        String sql ="update sys_schedule set title = ? ,completed =  ? where sid =?";
        return baseUpdate(sql,sysSchedule.getTitle(),sysSchedule.getCompleted(),sysSchedule.getSid());
    }

    @Override
    public void removeItem(Integer sid) {
        String sql = "delete from sys_schedule where sid = ?";
        baseUpdate(sql, sid);
    }
}
