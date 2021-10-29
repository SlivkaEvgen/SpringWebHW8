package com.homework.springwebhw8.repository;

import com.homework.springwebhw8.entity.EntityModel;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CrudRepositoryJDBC<T extends EntityModel<ID>, ID> extends JpaRepository<T, ID> {

    @Query("select c from #{#entityName} c where c.name=?1")
    List<T> findByName(String name);

//        @Query(value = "SELECT u FROM User u WHERE u.name LIKE '%' ||:keyword || '%'" +
//                " OR u.email LIKE '%' || :keyword || '%'"
//            + " OR u.lastName LIKE '%' || :keyword || '%'"
//            + " OR u.gender LIKE '%' || :keyword || '%'"
//            + " OR u.role_id LIKE '%' || :keyword || '%'")
//    List<User> search(@Param("keyword") String keyword);

}
