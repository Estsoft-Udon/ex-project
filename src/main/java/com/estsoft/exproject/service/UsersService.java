package com.estsoft.exproject.service;

import com.estsoft.exproject.dto.request.UsersRequest;
import com.estsoft.exproject.entity.Users;
import com.estsoft.exproject.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public Users register(UsersRequest request) {

        return usersRepository.save(new Users(request));
    }

}
