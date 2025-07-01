package bg.fmi.uni.eventsorganizer.dto;

import java.time.LocalDateTime;

public record InvitationDto(
        Integer id,
        Integer eventId,
        String eventName,
        String senderName,
        String receiverName,
        LocalDateTime sentAt
) {}