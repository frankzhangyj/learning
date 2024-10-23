package com.microsoft.schedule.controller;

import com.microsoft.schedule.commen.Result;
import com.microsoft.schedule.pojo.SysSchedule;
import com.microsoft.schedule.service.SysScheduleService;
import com.microsoft.schedule.service.impl.SysScheduleServiceImpl;
import com.microsoft.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    private SysScheduleService scheduleService = new SysScheduleServiceImpl();

    // 加载所有日程到前端
    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        //  调用服务层方法,查询所有日程
        List<SysSchedule> itemList = scheduleService.findItemListByUid(uid);
        // 将日程信息装入result,转换JSON给客户端
        Map<String,Object> data =new HashMap<>();
        data.put("itemList",itemList);
        WebUtil.writeJson(resp,Result.ok(data));
    }

    // 添加一个默认日程
    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        //  调用服务层方法,为当前用户新增一个默认空数据
        scheduleService.addDefault(uid);

        WebUtil.writeJson(resp,Result.ok(null));
    }

    // 更新一个日程
    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        // 调用服务层方法,更新数据
        scheduleService.updateSchedule(sysSchedule);

        // 响应成功
        WebUtil.writeJson(resp,Result.ok(null));
    }

    // 删除一个日程
    protected void removeItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer sid = Integer.parseInt(req.getParameter("sid"));
        scheduleService.removeItem(sid);
        WebUtil.writeJson(resp,Result.ok(null));
    }
}
