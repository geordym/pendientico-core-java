package com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper;

import com.pendientico.core.domain.model.UserModel;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);
    UserEntity toEntity(UserModel model);
    UserModel toModel(UserEntity entity);
}
