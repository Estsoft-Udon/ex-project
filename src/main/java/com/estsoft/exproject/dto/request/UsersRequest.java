package com.estsoft.exproject.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersRequest {
    private String loginId;
    private String password;
    private String name;
    private String nickname;
    private String email;
    private String phone;
}
