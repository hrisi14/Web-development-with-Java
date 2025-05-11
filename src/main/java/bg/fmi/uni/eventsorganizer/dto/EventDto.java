package bg.fmi.uni.eventsorganizer.dto;

import java.time.LocalDateTime;

public record EventDto(
        Integer id,
        String title,
        String description,
        String category,
        String location,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String rules,
        Integer organizerId,
        Integer sponsorId
) {}