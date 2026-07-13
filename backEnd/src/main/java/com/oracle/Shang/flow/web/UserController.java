package com.oracle.Shang.flow.web;

import com.oracle.Shang.flow.entiy.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 类：UserController
 * 描述：TODO
 *
 * @author Shang
 * @version 1.0
 * @date 2026-07-10 16:07:14
 */
@CrossOrigin(origins="*")
@RestController
public class UserController {
    @GetMapping("/show")
    public List show(){
        User shang=new User();
        shang.setId(1);
        shang.setUsername("shang");
        shang.setPassword("123");
        shang.setRealname("shangX");

        List<User> list=new ArrayList();
        list.add(shang);
        return list;
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable int id){
        System.out.println("id:"+id);
        return "OK";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user);
        return "OK";
    }

}
