package com.homework.springwebhw8.controller;

import com.homework.springwebhw8.entity.Role;
import com.homework.springwebhw8.service.BaseService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "role")
public class RoleController extends ControllerImpl<Role, Long> {

    private final BaseService<Role, Long> baseService;

    public RoleController(BaseService<Role, Long> baseService) {
        super(baseService);
        this.baseService = baseService;
    }

    @PutMapping("name")//http://localhost:8080/role/name?id=2&name=User
    public Role changeName(@RequestParam(name = "id", defaultValue = "1") Long id,
                           @ApiParam(required = true, name = "name", defaultValue = "User")
                           @RequestParam(name = "name") String name) {
        return baseService.findById(id)
                .map(role -> {
                    role.setName(name);
                    return baseService.save(role);
                })
                .orElse(null);
    }
}
