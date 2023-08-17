package com.unbubblefriends.user.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(catalog = "user", schema = "user", name = "user")
public class UserDbModel {

    @Id
    private Long Id;

    private String username;

    private String passwordHash;

}
