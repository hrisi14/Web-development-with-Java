package bg.fmi.uni.eventsorganizer.service;

import bg.fmi.uni.eventsorganizer.dto.EventDto;
import bg.fmi.uni.eventsorganizer.model.Event;
import bg.fmi.uni.eventsorganizer.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public Optional<EventDto> getEventById(Integer id) {
        return eventRepository.findById(id).map(this::toDto);
    }

    public EventDto addEvent(EventDto eventDto) {
        Event event = toEntity(eventDto);
        return toDto(eventRepository.save(event));
    }

    public boolean updateEvent(Integer id, EventDto eventDto) {
        if (eventRepository.existsById(id)) {
            Event event = toEntity(eventDto);
            event.setId(id);
            eventRepository.save(event);
            return true;
        }
        return false;
    }

    public boolean deleteEvent(Integer id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private EventDto toDto(Event event) {
        return new EventDto(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getCategory(),
                event.getLocation(),
                event.getStartDate(),
                event.getEndDate(),
                event.getRules(),
                event.getOrganizerId(),
                event.getSponsorId()
        );
    }

    private Event toEntity(EventDto eventDto) {
        return new Event(
                eventDto.id(),
                eventDto.title(),
                eventDto.description(),
                eventDto.category(),
                eventDto.location(),
                eventDto.startDate(),
                eventDto.endDate(),
                eventDto.rules(),
                eventDto.organizerId(),
                eventDto.sponsorId()
        );
    }
}