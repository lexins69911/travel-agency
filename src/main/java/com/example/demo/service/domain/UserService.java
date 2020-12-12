package com.example.demo.service.domain;

import com.example.demo.dao.domain.dto.UserDto;
import com.example.demo.dao.domain.model.UserEntity;
import com.example.demo.dao.domain.repo.UserRepo;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.InsufficientDataException;
import com.example.demo.service.base.BaseService;
import com.example.demo.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserEntity, UserDto> {

    private final UserRepo userRepo;
    private final UserMapper mapper;


    public UserEntity findByLogin(String login) {
        Optional<UserEntity> byLogin = userRepo.findByLogin(login);
        if (byLogin.isPresent()) {
            return byLogin.get();
        } else
            throw new EntityNotFoundException("Can't find user with login: "+login);
    }

    @Override
    public UserEntity create(UserDto dto) {
        UserEntity userEntity = mapper.toEntity(dto);
        return userRepo.save(userEntity);
    }

    @Override
    public UserEntity save(UserEntity entity) {
        return userRepo.save(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        userRepo.delete(entity);
    }

    @Override
    public boolean isExist(UserEntity entity) {
        try {
            if (entity.getId() != null) {
                findByLogin(entity.getLogin());
                return true;
            }
            if (entity.getLogin()!=null) {
                findByLogin(entity.getLogin());
                return true;
            }
        } catch (EntityNotFoundException e) {
            return false;
        }
        throw new InsufficientDataException("Entity don't have login and id");
    }

    @Override
    public UserEntity findById(Long id) {
        Optional<UserEntity> byId = userRepo.findById(id);
        if (byId.isPresent())
            return byId.get();
        else
            throw new EntityNotFoundException("Can't find user with id: "+ id);
    }

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepo.findAll();
    }
}
