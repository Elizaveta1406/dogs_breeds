package ru.omgtu.ivt.service;

import ru.omgtu.ivt.model.entity.User;
import ru.omgtu.ivt.repository.UserRepository;
import ru.omgtu.ivt.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SecurityUtils securityUtils;

    public User getCurrentUser() {
        return securityUtils.getCurrentUser()
                .orElseThrow(() -> new AccessDeniedException("User not authenticated"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
