package com.unbubblefriends.user.repositorys.db;

import com.unbubblefriends.user.models.db.UserDbModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDbModelRepository extends JpaRepository<UserDbModel, Long> {

}
