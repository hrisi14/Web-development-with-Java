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
                event.getImageUrl(),
                event.getLikes(),
                event.getStartDate(),
                event.getEndDate(),
                event.getRules(),
                event.getOrganizerId(),
                event.getSponsorId()
        );
    }

    private Event toEntity(EventDto eventDto) {
        Event event = new Event();
        event.setId(eventDto.id());
        event.setTitle(eventDto.title());
        event.setDescription(eventDto.description());
        event.setCategory(eventDto.category());
        event.setLocation(eventDto.location());
        event.setImageUrl(eventDto.imageUrl());
        event.setLikes(eventDto.likes());
        event.setStartDate(eventDto.startDate());
        event.setEndDate(eventDto.endDate());
        event.setRules(eventDto.rules());
        event.setOrganizerId(eventDto.organizerId());
        event.setSponsorId(eventDto.sponsorId());
        return event;
    }
}
