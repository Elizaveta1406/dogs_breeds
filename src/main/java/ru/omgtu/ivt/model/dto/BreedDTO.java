package ru.omgtu.ivt.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import ru.omgtu.ivt.model.Size;
import ru.omgtu.ivt.model.entity.Breed;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Schema(description = "Порода собаки")
@Data
public class BreedDTO {
    @Schema(description = "Название породы", example = "Ротвейлер")
    @NotBlank(message = "Breed name is required")
    private String name;

    @Schema(description = "Страна происхождения", example = "Германия")
    @NotBlank(message = "Origin country is required")
    private String originCountry;

    @Schema(description = "Описание породы", example = "Легко обучаемая порода с крепким телосложением")
    private String description;

    @Schema(description = "Средний срок жизни", example = "11")
    @Positive(message = "Lifespan must be positive")
    private int avgLifespan;

    @Schema(description = "Размер", example = "LARGE")
    private Size size;

    @Schema(description = "Характер", example = "Защитный, уверенный, преданный")
    private String temperament;

    @Schema(description = "Иллюстрация", example = "https://example.com/images/rottweiler.jpg")
    private String imageUrl;

    // Конвертация DTO в сущность
    public static Breed toEntity(BreedDTO dto) {
        Breed breed = new Breed();
        breed.setName(dto.name);
        breed.setOriginCountry(dto.originCountry);
        breed.setDescription(dto.description);
        breed.setAvgLifespan(dto.avgLifespan);
        breed.setSize(dto.size);
        breed.setTemperament(dto.temperament);
        breed.setImageUrl(dto.imageUrl);
        return breed;
    }

    // Конвертация сущность в DTO
    public static BreedDTO fromEntity(Breed breed) {
        BreedDTO dto = new BreedDTO();
        dto.setName(breed.getName());
        dto.setOriginCountry(breed.getOriginCountry());
        dto.setDescription(breed.getDescription());
        dto.setAvgLifespan(breed.getAvgLifespan());
        dto.setSize(breed.getSize());
        dto.setTemperament(breed.getTemperament());
        dto.setImageUrl(breed.getImageUrl());
        return dto;
    }

}