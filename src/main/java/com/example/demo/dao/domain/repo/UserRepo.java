package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.UserEntity;
import com.example.demo.dao.domain.schema.enums.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByLogin (String login);
    List<UserEntity> findAllByRole (Role role);

}
