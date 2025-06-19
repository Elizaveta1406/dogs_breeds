package ru.omgtu.ivt.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import ru.omgtu.ivt.model.Gender;
import ru.omgtu.ivt.model.entity.Breed;
import ru.omgtu.ivt.model.entity.Dog;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import ru.omgtu.ivt.model.entity.User;

import java.time.LocalDate;

@Schema(description = "Собака")
@Data
public class DogDTO {
    @Schema(description = "Идентификатор собаки", example = "13")
    private Long id;

    @Schema(description = "Кличка", example = "Дружок")
    @NotBlank(message = "Dog name is required")
    private String name;

    @Schema(description = "Дата рождения", example = "2022-09-18")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Schema(description = "Окрас", example = "Черный")
    private String color;

    @Schema(description = "Вес", example = "37.5")
    private Double weight;

    @Schema(description = "Пол собаки", example = "FEMALE")
    private Gender gender;

    @Schema(description = "Идентификатор породы собаки", example = "25")
    @Positive(message = "Breed ID must be positive")
    private Long breedId;

    @Schema(description = "Идентификатор пользователя - владельца собаки", example = "3")
    @Positive(message = "Owner ID must be positive")
    private Long ownerId;

    public static DogDTO fromEntity(Dog dog) {
        DogDTO dto = new DogDTO();
        dto.setId(dog.getId());
        dto.setName(dog.getName());
        dto.setBirthDate(dog.getBirthDate());
        dto.setColor(dog.getColor());
        dto.setWeight(dog.getWeight());
        dto.setGender(dog.getGender());
        dto.setBreedId(dog.getBreed() != null ? dog.getBreed().getId() : null);
        dto.setOwnerId(dog.getOwner() != null ? dog.getOwner().getId() : null);

        return dto;
    }

    public static Dog toEntity(DogDTO dto) {
        return Dog.builder()
                .id(dto.getId())
                .name(dto.getName())
                .gender(dto.getGender())
                .birthDate(dto.getBirthDate())
                .color(dto.getColor())
                .weight(dto.getWeight())
                .weight(dto.getWeight())
                .build()
        ;
    }
}
