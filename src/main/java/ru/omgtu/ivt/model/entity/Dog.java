package ru.omgtu.ivt.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.omgtu.ivt.model.Gender;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "breed_id", nullable = false)
    private Breed breed;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(length = 50)
    private String color;

    @Column(name = "weight_kg")
    private Double weight;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    // Дополнительные методы
    public int getAge() {
        if (birthDate == null) return 0;
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public static DogBuilder builder() {
        return new DogBuilder();
    }

    public static class DogBuilder {
        private String name;
        private Breed breed;
        private User owner;
        private LocalDate birthDate;
        private String color;
        private Double weight;
        private Gender gender;

        public DogBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DogBuilder breed(Breed breed) {
            this.breed = breed;
            return this;
        }

        public DogBuilder owner(User owner) {
            this.owner = owner;
            return this;
        }

        public DogBuilder gender(Gender gender){
            this.gender = gender;
            return this;
        }

        public DogBuilder color(String color){
            this.color = color;
            return this;
        }

        public DogBuilder weight(Double weight){
            this.weight = weight;
            return this;
        }

        public DogBuilder birthDate(LocalDate birthDate){
            this.birthDate = birthDate;
            return this;
        }

        public Dog build() {
            Dog dog = new Dog();
            dog.setName(this.name);
            dog.setBreed(this.breed);
            dog.setOwner(this.owner);
            dog.setBirthDate(this.birthDate);
            dog.setColor(this.color);
            dog.setWeight(this.weight);
            dog.setGender(this.gender);

            return dog;
        }
    }
}
