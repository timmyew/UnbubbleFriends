package com.unbubblefriends.user.components.gateways.db;

import com.unbubblefriends.core.component.gateways.db.AbstractDbGateway;
import com.unbubblefriends.user.models.db.UserDbModel;
import com.unbubblefriends.user.models.dto.UserDtoModel;
import com.unbubblefriends.user.repositorys.db.UserDbModelRepository;
import org.modelmapper.ModelMapper;

public class UserDbGateway extends AbstractDbGateway<UserDbModel, UserDtoModel> {
    public UserDbGateway(UserDbModelRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, UserDtoModel.class, UserDbModel.class);
    }
}
