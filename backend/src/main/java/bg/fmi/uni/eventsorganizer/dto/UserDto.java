package bg.fmi.uni.eventsorganizer.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Set;

public record UserDto(
        Integer id,
        String email,
        String password,
        String firstName,
        String lastName,
        String username,
        String role,
        Set<Integer> likedEventIds // добавено поле
) {}
