package com.homework.springwebhw8.service;

import com.homework.springwebhw8.entity.User;
import org.springframework.stereotype.Service;

//@RequiredArgsConstructor // будет добавлен конструктор для всех полей final
@Service
public interface UserService extends BaseService<User, Long> {

//    public List<User> search(String keyword);

}
