package com.soshow.ssi.redis.controller;
 
import java.util.Map;
 
import org.springframework.web.servlet.ModelAndView;
 
public class BaseMultiController {
    protected ModelAndView toView(final String url,final Map<String,Object> map)
    {  
        ModelAndView  view = new ModelAndView(url);
        return view;
    }
}