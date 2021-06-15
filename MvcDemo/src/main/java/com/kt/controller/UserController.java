package com.kt.controller;


import com.kt.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("Executing");
        //模拟从数据库查询出user对象
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123");
        user.setAge(23);
        //model对象
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Executing");
        //编写请求转发的程序
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        // response.sendRedirect(request.getContextPath()+"/index.jsp");
        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接会进行响应
        response.getWriter().print("你好");
        return;
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mv = new ModelAndView();
        System.out.println("ok!");
        User user = new User();
        user.setUsername("Roy");
        user.setPassword("123456");
        user.setAge(23);
        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("ok!");
        return "redirect:/index.jsp";
    }

    //Ajax请求方式,模拟异步请求响应
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("Executing");
        //客户端发送ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应模拟查询数据库
        user.setUsername("hello");
        user.setAge(33);
        //做响应
        return user;
    }
}
