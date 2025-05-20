package bg.fmi.uni.eventsorganizer.dto;


import lombok.Builder;
import lombok.Data;

public record UserDto(
        Integer id,
        String email,
        String password,
        String firstName,
        String lastName,
        String username,
        String role
) {}