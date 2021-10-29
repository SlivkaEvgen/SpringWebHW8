package com.homework.springwebhw8.service;

import com.homework.springwebhw8.entity.EntityModel;
import com.homework.springwebhw8.repository.CrudRepositoryJDBC;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

@Service
@NoRepositoryBean
public interface BaseService<T extends EntityModel<ID>, ID> extends CrudRepositoryJDBC<T, ID> {

}
