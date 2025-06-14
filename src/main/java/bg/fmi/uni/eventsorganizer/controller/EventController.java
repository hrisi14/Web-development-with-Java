package bg.fmi.uni.eventsorganizer.controller;

import bg.fmi.uni.eventsorganizer.dto.EventDto;
import bg.fmi.uni.eventsorganizer.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PutMapping("/{eventId}")
    public String updateEvent(@PathVariable Integer eventId,
                              @RequestParam String title,
                              @RequestParam String description,
                              @RequestParam String category,
                              @RequestParam String location,
                              @RequestParam LocalDateTime startDate,
                              @RequestParam LocalDateTime endDate,
                              @RequestParam String rules,
                              @RequestParam Integer organizerId,
                              @RequestParam Integer sponsorId) {
        EventDto eventDto = new EventDto(
                eventId, title, description, category, location, startDate, endDate, rules, organizerId, sponsorId
        );
        boolean isUpdated = eventService.updateEvent(eventId, eventDto);
        return isUpdated ? "Event updated successfully." : "Event update failed.";
    }
}