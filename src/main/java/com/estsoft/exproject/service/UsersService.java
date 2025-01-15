package com.estsoft.exproject.service;

import com.estsoft.exproject.dto.request.UsersRequest;
import com.estsoft.exproject.entity.Users;
import com.estsoft.exproject.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Users register(UsersRequest request) {
        Users user = new Users(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return usersRepository.save(user);
    }


}
