package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@Controller
@RequestMapping("/user")
/**
 * 类上的@RequestMapping的value值为所有请求地址的公共部分，即模块名称
 */
public class MyController {

    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome() {
        System.out.println("处理doSome请求");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "spingmvcmsg");
        modelAndView.addObject("fun", "spingmvcfun");
        modelAndView.setViewName("/show");
        return modelAndView;
    }

    @RequestMapping(value = {"/other.do"}, method = RequestMethod.POST)
    public ModelAndView doOther() {
        System.out.println("处理doOther请求");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "other");
        modelAndView.addObject("fun", "otherfun");
        modelAndView.setViewName("/other");
        return modelAndView;
    }

    @RequestMapping(value = "second.do")
    public ModelAndView doSecond(HttpServletRequest request,
                                 HttpServletResponse response,
                                 HttpSession session) {
        System.out.println("处理doSecond请求");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "second"+request.getParameter("name"));
        modelAndView.addObject("fun", "otherfun");
        modelAndView.setViewName("/other");
        return modelAndView;
    }
    @RequestMapping(value = "register.do")
    public ModelAndView doRegister(User user) {
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname", user.getUsername());
        modelAndView.addObject("mypassword", user.getPassword());
        modelAndView.addObject("myUser", user);
        modelAndView.setViewName("/other");
        return modelAndView;
    }
    @RequestMapping(value = "returnString.do")
    public String doReturnString(HttpServletRequest request,
                                        String username,
                                        String password) {
        request.setAttribute("myname", username);
        request.setAttribute("mypassword", password);
        return "show";
    }
    @RequestMapping(value = "returnVoid.do")
    public void doReturnVoid(HttpServletResponse response,
                                  String username,
                                  String password) throws IOException {
        User user=new User(username,password);
        String json = "";
        if (user != null) {
            ObjectMapper om=new ObjectMapper();
            json=om.writeValueAsString(user);
            System.out.println(json);
        }
        response.setContentType("application/json;charset=utf-8");
        Writer out;
        PrintWriter pw=response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }

}
