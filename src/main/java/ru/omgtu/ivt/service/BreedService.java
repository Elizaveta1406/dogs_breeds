package ru.omgtu.ivt.service;

import ru.omgtu.ivt.model.dto.BreedDTO;
import ru.omgtu.ivt.model.entity.Breed;
import ru.omgtu.ivt.repository.BreedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BreedService {
    private final BreedRepository breedRepository;

    @Transactional
    public BreedDTO createBreed(BreedDTO dto) {
        Breed breed = BreedDTO.toEntity(dto);
        breedRepository.save(breed);
        return BreedDTO.fromEntity(breed);
    }

    public List<BreedDTO> getAllBreeds() {
        return breedRepository
                .findAll()
                .stream()
                .map(BreedDTO::fromEntity)
                .toList();
    }

    @Transactional
    public void deleteBreed(Long id) {
        breedRepository.deleteById(id);
    }
}
