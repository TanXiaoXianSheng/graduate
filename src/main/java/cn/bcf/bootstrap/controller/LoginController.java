package cn.bcf.bootstrap.controller;

import cn.bcf.bootstrap.entity.UserEntity;
import cn.bcf.bootstrap.service.impl.UserServiceImpl;
import cn.bcf.bootstrap.util.ReturnObj;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @ResponseBody
    @RequestMapping("/")
    public ModelAndView login(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/login");
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ReturnObj login(@RequestBody UserEntity entity){
        ReturnObj returnObj = new ReturnObj();
        if (StringUtils.isNotEmpty(entity.getUsername()) && StringUtils.isNotEmpty(entity.getPassword())){
            entity = userService.findUsernameAndPassword(entity);
        }
        if (entity != null){
            returnObj.setMsgCode("1");
            returnObj.setEntity(entity);
            returnObj.setUrl("/index/");
        }else {
            returnObj.setMsgCode("0");
            returnObj.setUrl("/");
        }
        return returnObj;
    }

    @RequestMapping(value = "/registerPre")
    public ModelAndView registerPre(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/register");
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "/register")
    public ReturnObj register(@RequestBody UserEntity entity){
        ReturnObj returnObj = new ReturnObj();
        if (entity != null && StringUtils.isNotEmpty(entity.getUsername()) && StringUtils.isNotEmpty(entity.getPassword())){
            userService.add(entity);
            returnObj.setMsgCode("1");
            returnObj.setUrl("/");
        }else {
            returnObj.setMsgCode("0");
            returnObj.setUrl("/register");
        }
        return returnObj;
    }
}
