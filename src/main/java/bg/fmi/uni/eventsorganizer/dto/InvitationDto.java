package bg.fmi.uni.eventsorganizer.dto;

import java.time.LocalDateTime;

public record InvitationDto(
        Integer id,
        Integer eventId,
        String status,
        LocalDateTime sendAt
) {}