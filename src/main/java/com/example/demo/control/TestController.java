package com.example.demo.control;

import com.example.demo.model.User;
import com.example.demo.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class TestController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userDao.findAll());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("user/list", "userModel", model);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userDao.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("user/view", "userModel", model);
    }

    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("user/form", "userModel", model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        user = userDao.save(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        userDao.delete(id);
        return new ModelAndView("redirect:/users");// 重定向到list页面
    }
    
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        User user = userDao.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("user/form", "userModel", model);
    }


}