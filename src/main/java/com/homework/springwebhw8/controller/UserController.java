package com.homework.springwebhw8.controller;//package org.slivka.WebMarket.controller;

import com.homework.springwebhw8.entity.Role;
import com.homework.springwebhw8.entity.User;
import com.homework.springwebhw8.service.BaseService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "user")
public class UserController extends ControllerImpl<User, Long> {

    private final BaseService<User, Long> baseService;

    public UserController(BaseService<User, Long> baseService) {
        super(baseService);
        this.baseService = baseService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @RequestBody User user) {
        baseService.save(user);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = baseService.findById(id).get();
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam Long id) {
        baseService.deleteById(id);
        return "redirect:/";
    }

//    @RequestMapping("/search")
//    public ModelAndView search(@RequestParam String keyword) {
//        List<User> result = baseService.search(keyword);
//        ModelAndView mav = new ModelAndView("search");
//        mav.addObject("result", result);
//
//        return mav;
//    }

    @PutMapping("name")//http://localhost:8080/user/name?id=1&name=Olia
    public User changeName(@ApiParam(required = true, name = "id", defaultValue = "1")
                           @RequestParam(name = "id") Long id,
                           @ApiParam(required = true, name = "name", defaultValue = "Kevin")
                           @RequestParam(name = "name") String name) {
        return baseService.findById(id)
                .map(user -> {
                    user.setName(name);
                    return baseService.save(user);
                })
                .orElse(null);
    }

    @PutMapping("lastName")//http://localhost:8080/user/lastName?id=2&lastName=Swinger2
    public User changeLastName(@RequestParam(name = "id", defaultValue = "1") Long id,
                               @ApiParam(required = true, name = "lastName", defaultValue = "Swinger")
                               @RequestParam(name = "lastName") String lastName) {
        return baseService.findById(id)
                .map(user -> {
                    user.setLastName(lastName);
                    return baseService.save(user);
                })
                .orElse(null);
    }

    @PutMapping("gender")//http://localhost:8080/user/gender?gender=female&id=1
    public User changeGender(
            @RequestParam(name = "id", defaultValue = "1") Long id,
            @RequestParam(name = "gender") String gender) {
        return baseService.findById(id)
                .map(user -> {
                    user.setGender(gender);
                    return baseService.save(user);
                })
                .orElse(null);
    }

    @PutMapping("role")//http://localhost:8080/user/role?id=2&role=2
    public User changeRole(
            @RequestParam(name = "id", defaultValue = "1") Long id,
            @RequestParam(name = "role") Role role) {
        return baseService.findById(id)
                .map(user -> {
                    user.setRole(role);
                    return baseService.save(user);
                })
                .orElse(null);
    }

    @PutMapping("email")//http://localhost:8080/user/email?email=user%40swagger2&id=2
    public User changeEmail(
            @RequestParam(name = "id", defaultValue = "1") Long id,
            @RequestParam(name = "email", defaultValue = "user@swagger") String email) {
        return baseService.findById(id)
                .map(user -> {
                    user.setEmail(email);
                    return baseService.save(user);
                })
                .orElse(null);
    }

    @PutMapping("password")//http://localhost:8080/user/password?id=1&password=11111111
    public User changePassword(
            @RequestParam(name = "id", defaultValue = "1") Long id,
            @RequestParam(name = "password", defaultValue = "0000") String password) {
        return baseService.findById(id)
                .map(user -> {
                    user.setPassword(password);
                    return baseService.save(user);
                })
                .orElse(null);
    }
}
