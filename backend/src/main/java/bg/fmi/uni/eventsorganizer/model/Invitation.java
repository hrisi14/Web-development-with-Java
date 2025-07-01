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

    @ManyToOne
    private Event event;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "receiver_id") // optional: defines the column name
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Column(name = "sent_at")
    private LocalDateTime sentAt; // = LocalDateTime.now();


}