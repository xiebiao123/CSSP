package com.soshow.ssi.redis.controller;
 
import java.util.HashMap;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soshow.ssi.redis.dto.RedisDto;
import com.soshow.ssi.redis.service.RedisService;
 
@Controller
@RequestMapping(value = "/redis")
public class RedisController extends BaseMultiController {
 
    @Autowired
    private RedisService redisService;
 
    @RequestMapping(value = { "/add", "/add.html" }, method = { RequestMethod.GET })
    public ModelAndView add(HttpServletRequest request,
            HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        RedisDto Redis = new RedisDto();
        Redis.setKeyString("1");
        Redis.setValueString("guoxiaoming");
        this.redisService.add(Redis);
        return toView("add", map);
    }
 
    @RequestMapping(value = { "/add", "/add.html" }, method = { RequestMethod.POST })
    public ModelAndView addRedis(HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("Redis") RedisDto Redis) {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(Redis);
        map.put("message", "成功添加数据到库," + Redis);
        this.redisService.add(Redis);
        return toView("message", map);
    }
 
    @RequestMapping(value = { "/{id:\\d+}/query", "/{id:\\d+}/query.html" }, method = {
            RequestMethod.GET, RequestMethod.POST })
    public ModelAndView queryRedis(HttpServletRequest request,
            HttpServletResponse response, @PathVariable("id") String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(id);
        RedisDto Redis = this.redisService.get(id);
        if (null != Redis) {
            map.put("message", "查询Id=" + id + "的用户名为:" + Redis.getValueString());
        } else {
            map.put("message", "没有查询到与Id=" + id + "相关的数据");
        }
        return toView("message", map);
    }
 
    @RequestMapping(value = { "/{id:\\d+}/delete", "/{id:\\d+}/delete.html" }, method = {
            RequestMethod.GET, RequestMethod.POST })
    public ModelAndView deleteRedis(HttpServletRequest request,
            HttpServletResponse response, @PathVariable("id") String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            this.redisService.delete(id);
            map.put("message", "删除Id为" + id + "的用户成功.");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "删除Id为" + id + "的用户失败, " + e.getMessage());
        }
        return toView("message", map);
    }
 
}