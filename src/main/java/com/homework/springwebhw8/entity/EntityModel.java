package com.homework.springwebhw8.entity;

import java.io.Serializable;

@FunctionalInterface
public interface EntityModel<ID> extends Serializable {

    ID getId();

}
