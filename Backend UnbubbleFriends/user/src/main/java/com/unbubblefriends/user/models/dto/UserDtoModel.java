package com.unbubblefriends.user.models.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class UserDtoModel {
    private Long Id;

    private String username;

    private String passwordHash;
}
