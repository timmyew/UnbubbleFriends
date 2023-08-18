package com.unbubblefriends.user.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(schema = "user", name = "user")
public class UserDbModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String username;

    private String passwordHash;

}
