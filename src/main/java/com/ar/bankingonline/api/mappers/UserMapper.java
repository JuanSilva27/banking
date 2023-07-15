package com.ar.bankingonline.api.mappers;

import com.ar.bankingonline.domain.models.Account;
import com.ar.bankingonline.domain.models.User;
import com.ar.bankingonline.api.dto.UserDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class UserMapper {


    public UserDto userToDtoMap(User user){
        UserDto dto = new UserDto();
        List<Long> accountsId=new ArrayList<>();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        if (user.getAccounts()!=null)
            for (Account a:
                    user.getAccounts()) {
                Long id= a.getId();
                accountsId.add(id);
            }

        dto.setIdAccounts(accountsId);
        dto.setId(user.getId());
        return dto;
    }

    public User dtoMapToUser(UserDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setId(dto.getId());

        return user;
    }

}