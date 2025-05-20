package bg.fmi.uni.eventsorganizer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_id", nullable = false)
    private Integer eventId;

    @Column(nullable = false)
    private String status;

    @Column(name = "send_at", nullable = false)
    private LocalDateTime sendAt;

}