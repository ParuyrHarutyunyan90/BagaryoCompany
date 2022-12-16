package am.itspace.bagariocompanyrest.mapper;

import am.itspace.bagariocompanyrest.dto.CreateUserDto;
import am.itspace.bagariocompanyrest.dto.UserResponseDto;
import am.itspace.bagariocompanyrest.model.Order;
import am.itspace.bagariocompanyrest.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(CreateUserDto CreatUserDto);

    UserResponseDto map(User user);

    List<UserResponseDto> map(List<User> userList);
}
