package com.estsoft.exproject.service;

import com.estsoft.exproject.entity.Users;
import com.estsoft.exproject.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public Users register(Users user) {
        return usersRepository.save(user);
    }

}
