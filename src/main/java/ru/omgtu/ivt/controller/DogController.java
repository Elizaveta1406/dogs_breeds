package ru.omgtu.ivt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.omgtu.ivt.docs.breeds.BreedCreateRequest;
import ru.omgtu.ivt.docs.breeds.BreedsListResponse;
import ru.omgtu.ivt.docs.dogs.DogsCreateRequest;
import ru.omgtu.ivt.docs.dogs.DogsCreateResponse;
import ru.omgtu.ivt.docs.dogs.DogsListResponse;
import ru.omgtu.ivt.model.dto.BreedDTO;
import ru.omgtu.ivt.model.dto.DogDTO;
import ru.omgtu.ivt.model.entity.Dog;
import ru.omgtu.ivt.model.entity.User;
import ru.omgtu.ivt.repository.DogRepository;
import ru.omgtu.ivt.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dogs")
@RequiredArgsConstructor
@Tag(name = "Собаки", description = "API для управления собаками")
public class DogController {
    private final DogService dogService;
    private final DogRepository dogRepository;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    @ApiResponse(
            responseCode = "200",
            description = "Успешный ответ",
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = DogDTO.class),
                    examples = @ExampleObject(
                            name = "Пример ответа",
                            summary = "Список собак",
                            value = DogsCreateResponse.EXAMPLE
                    )
            )
    )
    @Operation(summary = "Добавление собаки")
    public ResponseEntity<DogDTO> createDog(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Порода для добавления",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Пример запроса",
                                    summary = "Пример данных добавляемой собаки",
                                    value = DogsCreateRequest.EXAMPLE
                            )
                    )
            )
            @RequestBody DogDTO dog
    ) {
        return ResponseEntity.ok(dogService.createDog(dog));
    }

    @GetMapping
    @ApiResponse(
            responseCode = "200",
            description = "Успешный ответ",
            content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = DogDTO.class),
                    examples = @ExampleObject(
                            name = "Пример ответа",
                            summary = "Список собак",
                            value = DogsListResponse.EXAMPLE
                    )
            )
    )
    @Operation(summary = "Получение списка собак")
    public ResponseEntity<List<DogDTO>> getAllDogs() {
        return ResponseEntity.ok(dogService.getAllDogs());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR') or @securityService.isDogOwner(#id)")
    @Operation(summary = "Удаление собаки")
    public ResponseEntity<Void> deleteDog(
            @Parameter(description = "ID собаки", example = "45")
            @PathVariable Long id
    ) {
        Optional<Dog> dogSR = dogRepository.findById(id);
        if(dogSR.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Dog dog = dogSR.get();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!dog.getOwner().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }
        dogService.deleteDog(id);
        return ResponseEntity.noContent().build();
    }
}
