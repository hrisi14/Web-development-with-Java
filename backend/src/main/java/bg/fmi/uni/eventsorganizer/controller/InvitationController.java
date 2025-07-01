package bg.fmi.uni.eventsorganizer.controller;

import bg.fmi.uni.eventsorganizer.dto.InvitationDto;
import bg.fmi.uni.eventsorganizer.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/invitations")
public class InvitationController {
    private final InvitationService invitationService;

    @Autowired
    public InvitationController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @GetMapping
    public List<InvitationDto> getAllInvitations() {
        return invitationService.getAllInvitations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvitationDto> getInvitationById(@PathVariable Integer id) {
        return invitationService.getInvitationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<InvitationDto> getInvitationsForUser(@PathVariable Integer userId) {
        System.out.println("User invitations got!");
        System.out.println(invitationService.getInvitationsForUser(userId));
        return invitationService.getInvitationsForUser(userId);
    }

    @PostMapping
    public ResponseEntity<InvitationDto> createInvitation(@RequestBody InvitationDto dto) {
        InvitationDto created = invitationService.createInvitation(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvitationDto> updateInvitation(@PathVariable Integer id, @RequestBody InvitationDto dto) {
        return invitationService.updateInvitation(id, dto)
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvitation(@PathVariable Integer id) {
        if (invitationService.deleteInvitation(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/send")
    public ResponseEntity<InvitationDto> sendInvitation(@RequestBody InvitationDto dto) {
        System.out.println(dto);
        InvitationDto sent = invitationService.sendInvitation(dto.senderId(), dto.receiverName(), dto.eventId());
        return ResponseEntity.ok(sent);
    }
}