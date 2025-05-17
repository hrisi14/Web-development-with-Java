package bg.fmi.uni.eventsorganizer.dto;

import java.time.LocalDateTime;

public record MediaContentDto(
        Integer id,
        Integer eventId,
        String caption,
        String type,
        LocalDateTime uploadDate
) {}