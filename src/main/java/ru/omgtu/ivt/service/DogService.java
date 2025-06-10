package ru.omgtu.ivt.service;

import ru.omgtu.ivt.model.dto.DogDTO;
import ru.omgtu.ivt.model.entity.Breed;
import ru.omgtu.ivt.model.entity.Dog;
import ru.omgtu.ivt.model.entity.User;
import ru.omgtu.ivt.repository.BreedRepository;
import ru.omgtu.ivt.repository.DogRepository;
import ru.omgtu.ivt.repository.UserRepository;
import ru.omgtu.ivt.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogService {
    private final DogRepository dogRepository;
    private final BreedRepository breedRepository;
    private final SecurityUtils securityUtils;
    private final UserRepository userRepository;

    @Transactional
    public DogDTO createDog(DogDTO dto) {
        User owner = userRepository.findById(securityUtils.getCurrentUser().get().getId()).get();

        Dog dog = DogDTO.toEntity(dto);
        dog.setOwner(owner);

        Optional<Breed> breedSearchResult = breedRepository.findById(dto.getBreedId());
        if (breedSearchResult.isPresent()) {
            Breed breed = breedSearchResult.get();
            dog.setBreed(breed);
        }

        dogRepository.save(dog);
        return DogDTO.fromEntity(dog);
    }

    public List<DogDTO> getAllDogs() {
        return dogRepository
                .findAll()
                .stream()
                .map(DogDTO::fromEntity)
                .toList();
    }

    @Transactional
    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }
}
