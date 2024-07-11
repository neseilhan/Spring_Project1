package dev.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/")
public class TestController {

    @GetMapping("/")
    public String home(){
        return "Anasayfa";
    }

    @GetMapping("/about")
    public String about(){
        return "Hakkimizda sayfasi";
    }

    @GetMapping("/user/{userId}/{userName}")
    public String getUser(@PathVariable("userId") int user_id, @PathVariable("userName") String uname){ //Pathvariable ile dinamik sekilde veri aliyoruz.
        return "User id : " + user_id + "-- User Name : " + uname;
    }

    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable("userId") int user_id){ //Hangi url girilirse onu calistirir.
        return "User id : " + user_id;
    }

}
