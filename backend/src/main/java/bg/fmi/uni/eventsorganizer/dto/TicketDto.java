package bg.fmi.uni.eventsorganizer.dto;

public record TicketDto(
        Integer id,
        Integer eventId,
        Integer price
) {}