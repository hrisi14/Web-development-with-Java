package bg.fmi.uni.eventsorganizer.service;

import bg.fmi.uni.eventsorganizer.dto.EventDto;
import bg.fmi.uni.eventsorganizer.model.Event;
import bg.fmi.uni.eventsorganizer.model.User;
import bg.fmi.uni.eventsorganizer.repository.EventRepository;
import bg.fmi.uni.eventsorganizer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

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

    @Transactional
    public boolean toggleLike(Integer eventId, Integer userId) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        boolean liked;
        if (user.getLikedEvents().contains(event)) {
            user.getLikedEvents().remove(event);
            event.setLikes(event.getLikes() != null ? event.getLikes() - 1 : 0);
            liked = false;
        } else {
            user.getLikedEvents().add(event);
            event.setLikes(event.getLikes() != null ? event.getLikes() + 1 : 1);
            liked = true;
        }
        userRepository.save(user);
        eventRepository.save(event);
        return liked;
    }

    @Transactional
    public boolean toggleFollow(Integer eventId, Integer userId) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        boolean followed;
        if (user.getFollowedEvents().contains(event)) {
            user.getFollowedEvents().remove(event);
            event.setFollowers(event.getFollowers() != null ? event.getFollowers() - 1 : 0);
            followed = false;
        } else {
            user.getFollowedEvents().add(event);
            event.setFollowers(event.getFollowers() != null ? event.getFollowers() + 1 : 1);
            followed = true;
        }
        userRepository.save(user);
        eventRepository.save(event);
        return followed;
    }

    @Transactional
    public boolean toggleVisit(Integer eventId, Integer userId) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        boolean visited;
        if (user.getVisitedEvents().contains(event)) {
            user.getVisitedEvents().remove(event);
            event.setVisitors(event.getVisitors() != null ? event.getVisitors() - 1 : 0);
            visited = false;
        } else {
            user.getVisitedEvents().add(event);
            event.setVisitors(event.getVisitors() != null ? event.getVisitors() + 1 : 1);
            visited = true;
        }
        userRepository.save(user);
        eventRepository.save(event);
        return visited;
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
                event.getFollowers(),
                event.getVisitors(),
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
        event.setFollowers(eventDto.followers());
        event.setVisitors(eventDto.visitors());
        event.setStartDate(eventDto.startDate());
        event.setEndDate(eventDto.endDate());
        event.setRules(eventDto.rules());
        event.setOrganizerId(eventDto.organizerId());
        event.setSponsorId(eventDto.sponsorId());
        return event;
    }
}
