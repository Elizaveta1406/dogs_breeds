package ru.omgtu.ivt.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.omgtu.ivt.model.Role;
import ru.omgtu.ivt.model.entity.User;
import lombok.Data;

@Schema(description = "Пользователь")
@Data
public class UserDTO {

    @Schema(description = "Идентификатор", example = "1")
    private Long id;
    @Schema(description = "Логин", example = "sidorova")
    private String username;
    @Schema(description = "Роль", example = "ADMIN")
    private Role role;

    public static UserDTO fromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setRole(dto.getRole());
        return user;
    }

}
