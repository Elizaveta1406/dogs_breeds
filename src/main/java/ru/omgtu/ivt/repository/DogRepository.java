package ru.omgtu.ivt.repository;


import ru.omgtu.ivt.model.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findByBreedId(Long breedId); // Поиск собак по ID породы
    List<Dog> findByOwnerId(Long ownerId); // Поиск собак по ID владельца
}
