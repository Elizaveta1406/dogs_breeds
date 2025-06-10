package ru.omgtu.ivt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.omgtu.ivt.docs.auth.AuthLoginRequest;
import ru.omgtu.ivt.docs.auth.AuthLoginResponse;
import ru.omgtu.ivt.docs.auth.AuthRegisterRequest;
import ru.omgtu.ivt.docs.auth.AuthRegisterResponse;
import ru.omgtu.ivt.docs.breeds.BreedCreateRequest;
import ru.omgtu.ivt.docs.breeds.BreedsListResponse;
import ru.omgtu.ivt.model.dto.AuthRequest;
import ru.omgtu.ivt.model.dto.AuthResponse;
import ru.omgtu.ivt.model.dto.BreedDTO;
import ru.omgtu.ivt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Безопасность", description = "API для авторизации и регистрации пользователей")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Регистрация пользователя")
    @ApiResponse(
            responseCode = "200",
            description = "Успешный ответ",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponse.class),
                    examples = @ExampleObject(
                            name = "Пример ответа успешной регистрации",
                            summary = "Созданный при регистрации токен",
                            value = AuthRegisterResponse.EXAMPLE
                    )
            )
    )
    public ResponseEntity<AuthResponse> register(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данный регистрации",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Пример запрашиваемых регистрационных данных",
                                    summary = "Пример данных регистрации",
                                    value = AuthRegisterRequest.EXAMPLE
                            )
                    )
            )
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    @Operation(summary = "Авторизация пользователя")
    @ApiResponse(
            responseCode = "200",
            description = "Успешный ответ",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponse.class),
                    examples = @ExampleObject(
                            name = "Пример ответа успешной авторизации",
                            summary = "Созданный при авторизации токен",
                            value = AuthLoginResponse.EXAMPLE
                    )
            )
    )
    public ResponseEntity<AuthResponse> login(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данный авторизации",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Пример запрашиваемых авторизационных данных",
                                    summary = "Пример данных авторизации",
                                    value = AuthLoginRequest.EXAMPLE
                            )
                    )
            )
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(authService.login(request));
    }
}
