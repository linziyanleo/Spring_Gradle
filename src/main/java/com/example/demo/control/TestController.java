package com.example.demo.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "user")
public class TestController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/users")
    public List<User> userList(){
        return userDao.findAll();
    }

    @PostMapping(value = "/addUser")
    public User userAdd(@RequestParam("name") String name, @RequestParam("age")  Integer age){
        User user=new User();
        user.setAge(age);
        user.setName(name);
        return userDao.save(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<User> delete(Long id) {
        userDao.deleteById(id);
        return userDao.findAll();
    }

    @PutMapping(value = "/update")
    public List<User> userUpdate(User user) {
        userDao.save(user);
        return userDao.findAll();
    }
}