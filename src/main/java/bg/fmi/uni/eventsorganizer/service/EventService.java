package bg.fmi.uni.eventsorganizer.service;

import bg.fmi.uni.eventsorganizer.model.Event;
import bg.fmi.uni.eventsorganizer.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service layer for handling event operations.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    /**
     * Retrieves all events.
     * @return List of all events.
     */
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    /**
     * Adds a new event.
     * @param title The title of the event.
     * @param description The event's description.
     * @param category The category of the event.
     * @param location The location of the event.
     * @param startDate The start date and time of the event.
     * @param endDate The end date and time of the event.
     * @param rules The rules of the event.
     * @param organizerId The ID of the organizer.
     * @param sponsorId The ID of the sponsor.
     */
    public void addEvent(String title, String description, String category, String location,
                         LocalDateTime startDate, LocalDateTime endDate, String rules,
                         int organizerId, int sponsorId) {
        Event event = new Event(title, description, category, location, startDate, endDate, rules, organizerId, sponsorId);
        eventRepository.addEvent(event);
    }

    /**
     * Retrieves all events happening within a specific time range.
     * @param start The start of the time range.
     * @param end The end of the time range.
     * @return List of events within the specified time range.
     */
    public List<Event> getEventsInTimeRange(LocalDateTime start, LocalDateTime end) {
        return eventRepository.getAllEvents().stream()
                .filter(event -> !event.getStartDate().isAfter(end) && !event.getEndDate().isBefore(start))
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing event.
     * @param id The ID of the event to update.
     * @param title New title.
     * @param description New description.
     * @param category New category.
     * @param location New location.
     * @param startDate New start date and time.
     * @param endDate New end date and time.
     * @param rules Updated rules.
     * @return true if updated successfully, false otherwise.
     */
    public boolean updateEvent(Integer id, String title, String description, String category, String location,
                               LocalDateTime startDate, LocalDateTime endDate, String rules) {
        Optional<Event> existingEvent = eventRepository.getEventById(id);
        if (existingEvent.isPresent()) {
            Event event = existingEvent.get();
            event.setTitle(title);
            event.setDescription(description);
            event.setCategory(category);
            event.setLocation(location);
            event.setStartDate(startDate);
            event.setEndDate(endDate);
            event.setRules(rules);
            return eventRepository.updateEvent(event);
        }
        return false;
    }
}