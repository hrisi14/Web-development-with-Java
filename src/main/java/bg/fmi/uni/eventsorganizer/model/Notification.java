package bg.fmi.uni.eventsorganizer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_id", nullable = false)
    private Integer eventId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "is_received", nullable = false)
    private boolean isReceived;

    @Column(name = "send_at", nullable = false)
    private LocalDateTime sendAt;

    @Column(name = "message_content", nullable = false)
    private String messageContent;
}