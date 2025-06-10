package ru.omgtu.ivt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.omgtu.ivt.model.Size;
import ru.omgtu.ivt.model.entity.Breed;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed, Long> {
    List<Breed> findBySize(Size size); // Поиск пород по размеру
    List<Breed> findByOriginCountry(String country); // Поиск пород по стране происхождения
}
