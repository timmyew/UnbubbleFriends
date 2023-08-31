package com.unbubblefriends.user.repositorys.db;

import com.unbubblefriends.user.models.db.UserDbModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDbModelRepository extends JpaRepository<UserDbModel, Long> {

}
