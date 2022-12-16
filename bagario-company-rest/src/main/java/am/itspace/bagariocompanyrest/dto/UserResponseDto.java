package am.itspace.bagariocompanyrest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private int id;
    private String name;
    private String surname;
    private String country;
}
