package com.javaunit3.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MovieController {
    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }
    
}
