package ru.omgtu.ivt.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ru.omgtu.ivt.docs.dogs.DogsCreateResponse;
import ru.omgtu.ivt.docs.users.UsersCurrentResponse;
import ru.omgtu.ivt.docs.users.UsersListResponse;
import ru.omgtu.ivt.model.dto.BreedDTO;
import ru.omgtu.ivt.model.dto.UserDTO;
import ru.omgtu.ivt.model.entity.User;
import ru.omgtu.ivt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Пользователями", description = "API для управления пользователями")
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    @ApiResponse(
            responseCode = "200",
            description = "Успешный ответ",
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = UserDTO.class),
                    examples = @ExampleObject(
                            name = "Пример ответа",
                            summary = "Текущий пользователь",
                            value = UsersCurrentResponse.EXAMPLE
                    )
            )
    )
    @Operation(summary = "Получение авторизованного пользователя")
    public ResponseEntity<UserDTO> getCurrentUser() {
        return ResponseEntity.ok(UserDTO.fromEntity((User) userService.getCurrentUser()));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiResponse(
            responseCode = "200",
            description = "Успешный ответ",
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = UserDTO.class),
                    examples = @ExampleObject(
                            name = "Пример ответа",
                            summary = "Список пользователей",
                            value = UsersListResponse.EXAMPLE
                    )
            )
    )
    @Operation(summary = "Получение списка всех пользователей")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers().stream().map(UserDTO::fromEntity).toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Удаление пользователей")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "ID пользователя", example = "3")
            @PathVariable Long id
    ) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
