package ru.omgtu.ivt.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(description = "Авторизационный запрос")
@Data
public class AuthRequest {
    @Schema(description = "Логин", example = "sidorova")
    @NotBlank(message = "Username is required")
    private String username;

    @Schema(description = "Пароль", example = "fMw3ZSClFS5vzqGq")
    @NotBlank(message = "Password is required")
    private String password;
}
