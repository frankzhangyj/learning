package com.microsoft.news.contorller;

import com.microsoft.news.pojo.Type;
import com.microsoft.news.pojo.vo.PortalVo;
import com.microsoft.news.service.HeadlineService;
import com.microsoft.news.service.TypeService;
import com.microsoft.news.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/22
 */
@RestController
@RequestMapping("/portal")
@CrossOrigin
public class PortalController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private HeadlineService headlineService;

    @GetMapping("/findAllTypes")
    public Result findAllTypes() {
        List<Type> list = typeService.list();
        return Result.ok(list);
    }

    /**
     * 首页分页查询
     * @return
     */
    @PostMapping("/findNewsPage")
    public Result findNewPage(@RequestBody PortalVo portalVo){
        Result result = headlineService.findNewPage(portalVo);
        return result;
    }

    @PostMapping("showHeadlineDetail")
    public Result showHeadlineDetail(@RequestParam("hid") Integer hid) {
        Result result = headlineService.getNewsDetail(hid);
        return result;
    }
}
