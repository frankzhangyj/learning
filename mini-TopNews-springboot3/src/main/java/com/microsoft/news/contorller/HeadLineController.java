package com.microsoft.news.contorller;

import com.microsoft.news.pojo.Headline;
import com.microsoft.news.service.HeadlineService;
import com.microsoft.news.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/23
 */
@RestController
@RequestMapping("/headline")
public class HeadLineController {
    @Autowired
    private HeadlineService headlineService;

    @PostMapping("/publish")
    public Result publish(@RequestBody Headline headline, @RequestHeader String token) {
        Result result = headlineService.saveNews(headline, token);
        return result;
    }

    @PostMapping("/findHeadlineByHid")
    public Result findHeadlineByHid(@RequestParam("hid")Integer hid) {
        Result result = headlineService.getNewsByHid(hid);
        return result;
    }

    @PostMapping("/update")
    public Result updateNews(@RequestBody Headline headline) {
        Result result = headlineService.updateNews(headline);
        return result;
    }

    @PostMapping("/removeByHid")
    public Result removeByHid(@RequestParam("hid") Integer hid) {
        headlineService.removeById(hid);
        return Result.ok(null);
    }
}
