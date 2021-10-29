package com.homework.springwebhw8.controller;//package org.slivka.WebMarket.controller;

import com.homework.springwebhw8.entity.Manufacturer;
import com.homework.springwebhw8.service.BaseService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "manufacturer")
public class ManufacturerController extends ControllerImpl<Manufacturer, Long> {

    private final BaseService<Manufacturer, Long> baseService;

    public ManufacturerController(BaseService<Manufacturer, Long> baseService) {
        super(baseService);
        this.baseService = baseService;
    }

    @PutMapping("name")//http://localhost:8080/manufacturer/name?id=1&name=Apple5
    public Manufacturer changeName(@RequestParam(name = "id", defaultValue = "1") Long id,
                                   @ApiParam(required = true, name = "name", defaultValue = "Apple")
                                   @RequestParam(name = "name") String name) {
        return baseService.findById(id)
                .map(manufacturer -> {
                    manufacturer.setName(name);
                    return baseService.save(manufacturer);
                })
                .orElse(null);
    }
}
