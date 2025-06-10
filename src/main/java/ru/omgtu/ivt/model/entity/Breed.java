package ru.omgtu.ivt.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.omgtu.ivt.model.Size;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "breeds")
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String originCountry;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "avg_lifespan_years")
    private int avgLifespan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Size size;

    @Column(nullable = false)
    private String temperament;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "breed",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dog> dogs;

    // Дополнительные методы
    public String getSizeDescription() {
        return switch (this.size) {
            case TOY -> "Very small companion dog";
            case SMALL -> "Compact size, suitable for apartments";
            case MEDIUM -> "Versatile family dog";
            case LARGE -> "Needs more space and exercise";
            case GIANT -> "Requires significant space and care";
        };
    }

    // Билдер для удобного создания объектов
    public static BreedBuilder builder() {
        return new BreedBuilder();
    }

    public static class BreedBuilder {
        private String name;
        private String originCountry;
        private String description;
        private int avgLifespan;
        private Size size;
        private String temperament;
        private String imageUrl;

        public BreedBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BreedBuilder originCountry(String originCountry) {
            this.originCountry = originCountry;
            return this;
        }

        public BreedBuilder description(String description) {
            this.description = description;
            return this;
        }

        public BreedBuilder size(Size size) {
            this.size = size;
            return this;
        }

        public BreedBuilder avgLifespan(int avgLifespan) {
            this.avgLifespan = avgLifespan;
            return this;
        }

        public BreedBuilder temperament(String temperament) {
            this.temperament = temperament;
            return this;
        }

        public BreedBuilder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Breed build() {
            Breed breed = new Breed();
            breed.setName(this.name);
            breed.setOriginCountry(this.originCountry);
            breed.setDescription(this.description);
            breed.setSize(this.size);
            breed.setTemperament(this.temperament);
            breed.setAvgLifespan(this.avgLifespan);
            breed.setImageUrl(this.imageUrl);
            return breed;
        }
    }
}