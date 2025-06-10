package ru.omgtu.ivt.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Токен доступа к ресурсам приложения")
public class AuthResponse {
    @Schema(description = "Токен доступа", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc0OTM4NjQ4NiwiZXhwIjoxNzQ5NDcyODg2fQ.mS3TTqqQIjd5zo7KU5ESgdRqavp3uCYrhrPUdpYsFhk")
    private String accessToken;
    @Schema(description = "Уровень прав доступа", example = "ADMIN")
    private String role;
    @Schema(description = "Сообщение при успешной авторизации", example = "Вы успешно авторизованы")
    private String message;
}
