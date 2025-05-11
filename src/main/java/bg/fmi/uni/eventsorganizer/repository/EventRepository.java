package bg.fmi.uni.eventsorganizer.repository;

import bg.fmi.uni.eventsorganizer.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repository for managing events.
 */
@Slf4j
@Repository
public class EventRepository {
    private static Map<Integer, Event> eventTable = new HashMap<>();

    /**
     * Adds a new event to the repository.
     * @param event The event to be added.
     */
    public void addEvent(Event event) {
        log.info("Adding event with ID: {}", event.getId());
        if (eventTable.values().stream().anyMatch(e -> e.getTitle().equals(event.getTitle()))) {
            throw new IllegalArgumentException(String.format("Event with title '%s' already exists in the repository", event.getTitle()));
        }
        eventTable.put(event.getId(), event);
    }

    /**
     * Deletes an event by its ID.
     * @param id The ID of the event to be deleted.
     * @return true if the event was successfully deleted, false otherwise.
     */
    public boolean deleteEventById(Integer id) {
        log.info("Deleting event with ID: {}", id);
        return eventTable.remove(id) != null;
    }

    /**
     * Retrieves an event by its ID.
     * @param id The ID of the event.
     * @return An Optional containing the event if found.
     */
    public Optional<Event> getEventById(Integer id) {
        log.info("Retrieving event with ID: {}", id);
        return Optional.ofNullable(eventTable.get(id));
    }

    /**
     * Returns all events in the repository.
     * @return List of all events.
     */
    public List<Event> getAllEvents() {
        log.info("Retrieving all events");
        return new ArrayList<>(eventTable.values());
    }

    /**
     * Updates an existing event.
     * @param updatedEvent The updated event details.
     * @return true if the update was successful, false otherwise.
     */
    public boolean updateEvent(Event updatedEvent) {
        log.info("Updating event with ID: {}", updatedEvent.getId());
        if (eventTable.containsKey(updatedEvent.getId())) {
            eventTable.put(updatedEvent.getId(), updatedEvent);
            return true;
        }
        return false;
    }
}