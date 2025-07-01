package bg.fmi.uni.eventsorganizer.repository;

import bg.fmi.uni.eventsorganizer.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {
    Optional<Event> findByTitle(String title);
}