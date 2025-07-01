package bg.fmi.uni.eventsorganizer.service;

import bg.fmi.uni.eventsorganizer.dto.UserDto;
import bg.fmi.uni.eventsorganizer.model.User;
import bg.fmi.uni.eventsorganizer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import bg.fmi.uni.eventsorganizer.model.Event;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }


    public Integer authenticate(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                return user.getId();
            }
        }

        return null;
    }

    public Optional<UserDto> getUserByUsername(String username) {
        return userRepository.findByUsername(username).map(this::toDto);
    }

    public Optional<UserDto> getUserById(Integer id) {
        return userRepository.findById(id).map(this::toDto);
    }

    public UserDto addUser(UserDto userDto) {
        User user = toEntity(userDto);
        System.out.println("User service processing user");
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

    public Set<Event> getLikedEvents(Integer userId) {
        return userRepository.findById(userId)
                .map(User::getLikedEvents)
                .orElse(Set.of());
    }

    public Set<Event> getFollowedEvents(Integer userId) {
        return userRepository.findById(userId)
                .map(User::getFollowedEvents)
                .orElse(Set.of());
    }

    public Set<Event> getVisitedEvents(Integer userId) {
        return userRepository.findById(userId)
                .map(User::getVisitedEvents)
                .orElse(Set.of());
    }

    private UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getRole(),
                user.getLikedEvents() != null
                    ? user.getLikedEvents().stream().map(Event::getId).collect(Collectors.toSet())
                    : Set.of(),
                user.getFollowedEvents() != null
                    ? user.getFollowedEvents().stream().map(Event::getId).collect(Collectors.toSet())
                    : Set.of(),
                user.getVisitedEvents() != null
                    ? user.getVisitedEvents().stream().map(Event::getId).collect(Collectors.toSet())
                    : Set.of()
        );
    }

    private User toEntity(UserDto userDto) {
        User user = new User(
                userDto.id(),
                userDto.email(),
                userDto.password(),
                userDto.firstName(),
                userDto.lastName(),
                userDto.username(),
                userDto.role()
        );
        // likedEvents се сетва само при нужда, за да се избегнат излишни заявки
        return user;
    }
}
