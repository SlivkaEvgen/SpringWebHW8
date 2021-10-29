package com.homework.springwebhw8.controller;

import com.homework.springwebhw8.entity.EntityModel;
import com.homework.springwebhw8.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ControllerImpl<T extends EntityModel<ID>, ID> implements Controller<T, ID> {

    private final BaseService<T, ID> baseService;

    public ControllerImpl(BaseService<T, ID> baseService) {
        this.baseService = baseService;
    }

    @Override
    @GetMapping////http://localhost:8080/beanName
    public List<T> findAll() {////http://localhost:8080/beanName
        return baseService.findAll();
    }

    @Override
    @GetMapping({"/{id}"})////http://localhost:8080/beanName/1
    public Optional<T> findById(@PathVariable(name = "id") Optional<ID> id) {
        return id.map(baseService::findById).orElseGet(() -> baseService.findById((ID) id));
    }

    @Override
    @GetMapping("/name/{name}")////http://localhost:8080/beanName/name/apple
    public List<T> findByName(@PathVariable(name = "name")String name) {
        return name.isEmpty() ? null : baseService.findByName(name);
    }

    @Override
        @Operation(
            description = "Add New Object")
    @ApiResponses
    @PostMapping//http://localhost:8080/beanName
    public T save(@RequestBody T t) {
        return baseService.save(t);
    }



    @Override
    @DeleteMapping("{id}")////http://localhost:8080/beanName/4
    public void deleteById(@PathVariable(name = "id")ID id) {
        baseService.deleteById(id);
    }
}
