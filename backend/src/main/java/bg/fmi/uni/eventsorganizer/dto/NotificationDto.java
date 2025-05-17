package bg.fmi.uni.eventsorganizer.dto;

import java.time.LocalDateTime;

public record NotificationDto(
        Integer id,
        Integer eventId,
        Integer userId,
        boolean isReceived,
        LocalDateTime sendAt,
        String messageContent
) {}