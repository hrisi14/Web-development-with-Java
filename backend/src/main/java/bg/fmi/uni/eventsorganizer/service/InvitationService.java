package bg.fmi.uni.eventsorganizer.service;

import bg.fmi.uni.eventsorganizer.dto.InvitationDto;
import bg.fmi.uni.eventsorganizer.model.Event;
import bg.fmi.uni.eventsorganizer.model.Invitation;
import bg.fmi.uni.eventsorganizer.model.User;
import bg.fmi.uni.eventsorganizer.repository.EventRepository;
import bg.fmi.uni.eventsorganizer.repository.InvitationRepository;
import bg.fmi.uni.eventsorganizer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvitationService {
    private final InvitationRepository invitationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    //newly added
    public InvitationDto sendInvitation(Integer senderId, Integer receiverId, Integer eventId) {
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender not found with id: " + senderId));
        User receiver = userRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver not found with id: " + receiverId));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));

        Invitation invitation = new Invitation();
        invitation.setSender(sender);
        invitation.setReceiver(receiver);
        invitation.setEvent(event);
        invitation.setStatus("PENDING");
        invitation.setSentAt(LocalDateTime.now());
        Invitation saved = invitationRepository.save(invitation);
        return toDto(saved);
    }


    public List<InvitationDto> getAllInvitations() {
        return invitationRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public Optional<InvitationDto> getInvitationById(Integer id) {
        return invitationRepository.findById(id).map(this::toDto);
    }

    public InvitationDto createInvitation(InvitationDto invitationDto) {
        Invitation invitation = toEntity(invitationDto);
        return toDto(invitationRepository.save(invitation));
    }

    public boolean updateInvitation(Integer id, InvitationDto invitationDto) {
        if (invitationRepository.existsById(id)) {
            Invitation invitation = toEntity(invitationDto);
            invitation.setId(id);
            invitationRepository.save(invitation);
            return true;
        }
        return false;
    }

    public boolean deleteInvitation(Integer id) {
        if (invitationRepository.existsById(id)) {
            invitationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public InvitationDto toDto(Invitation invitation) {
        return new InvitationDto(
                invitation.getId(),
                invitation.getEvent().getId(),
                invitation.getSender().getId(),
                invitation.getReceiver().getId(),
                invitation.getSentAt()
        );
    }

    public Invitation toEntity(InvitationDto dto) {
        User sender = userRepository.findById(dto.senderId())
                .orElseThrow(() -> new RuntimeException("Sender not found!"));
        User receiver = userRepository.findById(dto.receiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found!"));
        Event event = eventRepository.findById(dto.eventId())
                .orElseThrow(() -> new RuntimeException("Event not found!"));

        Invitation invitation = new Invitation();
        invitation.setEvent(event);
        invitation.setSender(sender);
        invitation.setReceiver(receiver);
        invitation.setSentAt(dto.sentAt() != null ? dto.sentAt() : LocalDateTime.now());
        return invitation;
    }
}