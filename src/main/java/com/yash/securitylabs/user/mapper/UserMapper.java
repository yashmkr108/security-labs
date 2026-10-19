package com.yash.securitylabs.user.mapper;

import com.yash.securitylabs.user.dto.UserResponse;
import com.yash.securitylabs.user.enitity.User;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserMapper {
    public UserResponse toResponse(User user, int status,Instant timestamp){
        return new UserResponse(status,user.getId(), user.getEmail(),timestamp );
    }
}
