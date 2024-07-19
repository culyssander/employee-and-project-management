package com.culysoft.usermodule.controller;

import com.culysoft.usermodule.dto.UserDto;
import com.culysoft.usermodule.dto.UserRegister;
import com.culysoft.usermodule.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("register")
    public UserDto register(@Validated @RequestBody UserRegister userRegister) {
        return userService.register(userRegister);
    }
}
