package bg.fmi.uni.eventsorganizer.dto;

import java.time.LocalDateTime;

public record APIErrorDto(
        String message,
        int status,
        LocalDateTime timestamp
) {}