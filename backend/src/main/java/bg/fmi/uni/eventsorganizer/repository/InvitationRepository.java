package bg.fmi.uni.eventsorganizer.repository;

import bg.fmi.uni.eventsorganizer.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvitationRepository extends JpaRepository<Invitation, Integer> {
    List<Invitation> findByReceiverId(Integer receiverId);
}