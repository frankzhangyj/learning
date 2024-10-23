package com.microsoft.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.microsoft.ssm.mapper.ScheduleMapper;
import com.microsoft.ssm.pojo.Schedule;
import com.microsoft.ssm.service.ScheduleService;
import com.microsoft.ssm.utils.PageBean;
import com.microsoft.ssm.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
@Slf4j
@Service
public class ScheduleImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public PageBean<Schedule> findByPage(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage, pageSize);
        List<Schedule> list = scheduleMapper.queryPage();
        PageInfo<Schedule> schedulePageInfo1 = new PageInfo<>(list);
        PageBean<Schedule> pageBean = new PageBean<>(schedulePageInfo1.getPageNum(), schedulePageInfo1.getPageSize(), schedulePageInfo1.getTotal(),
                schedulePageInfo1.getList());
        log.info("分页结果: {}", pageBean);
        return pageBean;
    }

    @Override
    public void saveSchedule(Schedule schedule) {
        scheduleMapper.insert(schedule);
    }

    /**
     * 移除学习计划
     *
     * @param id
     */
    @Override
    public void removeById(Integer id) {
        scheduleMapper.delete(id);
    }

    @Override
    public R updateSchedule(Schedule schedule) {
        if (schedule.getId() == null) {
            return R.fail("id null");
        }
        int rows = scheduleMapper.update(schedule);
        if (rows > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }
}
