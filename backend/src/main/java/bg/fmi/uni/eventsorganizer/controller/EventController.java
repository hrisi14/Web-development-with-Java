package bg.fmi.uni.eventsorganizer.controller;

import bg.fmi.uni.eventsorganizer.dto.EventDto;
import bg.fmi.uni.eventsorganizer.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/events")
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
                              @RequestParam String imageUrl,
                              @RequestParam Integer likes,
                              @RequestParam LocalDateTime startDate,
                              @RequestParam LocalDateTime endDate,
                              @RequestParam String rules,
                              @RequestParam Integer organizerId,
                              @RequestParam Integer sponsorId) {
        EventDto eventDto = new EventDto(
                eventId, title, description, category, location, imageUrl, likes, startDate, endDate, rules, organizerId, sponsorId
        );
        boolean isUpdated = eventService.updateEvent(eventId, eventDto);
        return isUpdated ? "Event updated successfully." : "Event update failed.";
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Integer eventId) {
        return eventService.getEventById(eventId)
                .map(eventDto -> {
                    return ResponseEntity.ok(eventDto);
                })
                .orElseGet(() -> {
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public EventDto addEvent(@RequestBody EventDto eventDto) {
        return eventService.addEvent(eventDto);
    }

    @PostMapping("/{eventId}/like")
    public ResponseEntity<?> toggleLike(
            @PathVariable Integer eventId,
            @RequestParam Integer userId) {
        boolean liked = eventService.toggleLike(eventId, userId);
        return ResponseEntity.ok().body(liked ? "liked" : "unliked");
    }
}
