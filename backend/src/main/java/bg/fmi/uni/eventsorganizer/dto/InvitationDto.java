package bg.fmi.uni.eventsorganizer.dto;

import java.time.LocalDateTime;

public record InvitationDto(
        Integer id,
        Integer eventId,
        Integer senderId,
        String receiverName,
        LocalDateTime sentAt
) {}