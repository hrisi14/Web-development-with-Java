package bg.fmi.uni.eventsorganizer.service;

import bg.fmi.uni.eventsorganizer.dto.UserDto;
import bg.fmi.uni.eventsorganizer.model.User;
import bg.fmi.uni.eventsorganizer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public Optional<UserDto> getUserById(Integer id) {
        return userRepository.findById(id).map(this::toDto);
    }

    public UserDto addUser(UserDto userDto) {
        User user = toEntity(userDto);
        return toDto(userRepository.save(user));
    }

    public boolean updateUser(Integer id, UserDto userDto) {
        if (userRepository.existsById(id)) {
            User user = toEntity(userDto);
            user.setId(id);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getRole()
        );
    }

    private User toEntity(UserDto userDto) {
        return new User(
                userDto.id(),
                userDto.email(),
                userDto.password(),
                userDto.firstName(),
                userDto.lastName(),
                userDto.username(),
                userDto.role()
        );
    }
}