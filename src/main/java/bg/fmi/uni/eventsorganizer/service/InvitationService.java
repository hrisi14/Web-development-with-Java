package bg.fmi.uni.eventsorganizer.service;

import bg.fmi.uni.eventsorganizer.dto.InvitationDto;
import bg.fmi.uni.eventsorganizer.model.Invitation;
import bg.fmi.uni.eventsorganizer.repository.InvitationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvitationService {
    private final InvitationRepository invitationRepository;

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

    private InvitationDto toDto(Invitation invitation) {
        return new InvitationDto(
                invitation.getId(),
                invitation.getEventId(),
                invitation.getStatus(),
                invitation.getSendAt()
        );
    }

    private Invitation toEntity(InvitationDto invitationDto) {
        Invitation invitation = new Invitation();
        invitation.setId(invitationDto.id());
        invitation.setEventId(invitationDto.eventId());
        invitation.setStatus(invitationDto.status());
        invitation.setSendAt(invitationDto.sendAt());
        return invitation;
    }
}