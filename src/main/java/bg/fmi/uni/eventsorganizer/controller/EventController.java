package bg.fmi.uni.eventsorganizer.controller;

import bg.fmi.uni.eventsorganizer.model.Event;
import bg.fmi.uni.eventsorganizer.service.EventService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controller for event operations.
 */
@Component
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * Displays all available events.
     */
    public void displayAllEvents() {
        List<Event> events = eventService.getAllEvents();
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            events.forEach(event -> System.out.println("Event: " + event.getTitle() + ", Location: " + event.getLocation()));
        }
    }

    /**
     * Retrieves events happening within a specific time range.
     * @param start The start of the time range.
     * @param end The end of the time range.
     * @return List of events within the specified time range.
     */
    public List<Event> getEventsInTimeRange(LocalDateTime start, LocalDateTime end) {
        return eventService.getEventsInTimeRange(start, end);
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
     */
    public void updateEvent(Integer id, String title, String description, String category, String location,
                            LocalDateTime startDate, LocalDateTime endDate, String rules) {
        boolean success = eventService.updateEvent(id, title, description, category, location, startDate, endDate, rules);
        if (success) {
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Update failed. Event not found.");
        }
    }
}