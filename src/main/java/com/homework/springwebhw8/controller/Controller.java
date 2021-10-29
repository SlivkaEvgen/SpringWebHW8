package com.homework.springwebhw8.controller;

import com.homework.springwebhw8.entity.EntityModel;

import java.util.List;
import java.util.Optional;

public interface Controller<T extends EntityModel<ID>,ID> {

    List<T> findAll();

    Optional<T> findById(Optional<ID> id);

    List<T> findByName(String name);

    T save(T t);

    void deleteById(ID id);

//    T changeName(ID id,String name);

}
