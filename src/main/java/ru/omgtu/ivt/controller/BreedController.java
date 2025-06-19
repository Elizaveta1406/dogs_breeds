package ru.omgtu.ivt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.omgtu.ivt.docs.breeds.BreedCreateRequest;
import ru.omgtu.ivt.docs.breeds.BreedsListResponse;
import ru.omgtu.ivt.model.dto.BreedDTO;
import ru.omgtu.ivt.model.entity.Breed;
import ru.omgtu.ivt.service.BreedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breeds")
@RequiredArgsConstructor
@Tag(name = "Породы", description = "API для управления породами")
public class BreedController {
    private final BreedService breedService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @Operation(summary = "Добавление породы")
    @ApiResponse(
            responseCode = "200",
            description = "Успешный ответ",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = BreedDTO.class),
                    examples = @ExampleObject(
                            name = "Пример ответа",
                            summary = "Добавленная порода",
                            value = BreedsListResponse.EXAMPLE
                    )
            )
    )
    public ResponseEntity<BreedDTO> createBreed(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Порода для добавления",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Пример запроса",
                                    summary = "Пример новой породы",
                                    value = BreedCreateRequest.EXAMPLE
                            )
                    )
            )
            @RequestBody BreedDTO breed
    ) {
        return ResponseEntity.ok(breedService.createBreed(breed));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    @ApiResponse(
            responseCode = "200",
            description = "Успешный ответ",
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = BreedDTO.class),
                    examples = @ExampleObject(
                        name = "Пример ответа",
                        summary = "Список пород собак",
                        value = BreedsListResponse.EXAMPLE
                    )
            )
    )
    @Operation(summary = "Получение списка всех доступных пород")
    public ResponseEntity<List<BreedDTO>> getAllBreeds() {
        return ResponseEntity.ok(breedService.getAllBreeds());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Удаление породы")
    public ResponseEntity<Void> deleteBreed(
            @Parameter(description = "ID породы", example = "12")
            @PathVariable Long id
    ) {
        breedService.deleteBreed(id);
        return ResponseEntity.noContent().build();
    }
}