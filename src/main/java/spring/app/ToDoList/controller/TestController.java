package spring.app.ToDoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TestController {
    @RequestMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", "Hello, world!");
        return modelAndView;
    }
}
