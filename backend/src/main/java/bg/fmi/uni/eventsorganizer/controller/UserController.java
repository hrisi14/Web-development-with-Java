package bg.fmi.uni.eventsorganizer.controller;

import bg.fmi.uni.eventsorganizer.dto.UserDto;
import bg.fmi.uni.eventsorganizer.dto.UserSessionDto;
import bg.fmi.uni.eventsorganizer.service.UserService;
import bg.fmi.uni.eventsorganizer.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
        System.out.println("Incoming dto: " + dto);
        UserDto created = userService.addUser(dto);
        System.out.println("Created dto: " + dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Integer>> login(@RequestBody UserSessionDto userLoginDto) {
        Integer userId = userService.authenticate(userLoginDto.getUsername(), userLoginDto.getPassword());

        if (userId != null) {
            return ResponseEntity.ok(Map.of("userId", userId));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("Invalid credentials", null));
    }

    @GetMapping("/{id}/liked-events")
    public ResponseEntity<Set<Event>> getLikedEvents(@PathVariable Integer id) {
        return userService.getUserById(id)
                .map(userDto -> {
                    Set<Event> liked = userService.getLikedEvents(id);
                    return ResponseEntity.ok(liked);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/followed-events")
    public ResponseEntity<Set<Event>> getFollowedEvents(@PathVariable Integer id) {
        return userService.getUserById(id)
                .map(userDto -> {
                    Set<Event> followed = userService.getFollowedEvents(id);
                    return ResponseEntity.ok(followed);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/visited-events")
    public ResponseEntity<Set<Event>> getVisitedEvents(@PathVariable Integer id) {
        return userService.getUserById(id)
                .map(userDto -> {
                    Set<Event> visited = userService.getVisitedEvents(id);
                    return ResponseEntity.ok(visited);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto dto) {
        return userService.updateUser(id, dto)
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
