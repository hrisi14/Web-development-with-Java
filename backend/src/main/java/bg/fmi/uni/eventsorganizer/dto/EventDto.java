package bg.fmi.uni.eventsorganizer.dto;

import java.time.LocalDateTime;

public record EventDto(
        Integer id,
        String title,
        String description,
        String category,
        String location,
        String imageUrl,
        Integer likes,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String rules,
        Integer organizerId,
        Integer sponsorId
) {}
