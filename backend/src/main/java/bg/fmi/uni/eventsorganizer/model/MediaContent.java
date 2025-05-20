package bg.fmi.uni.eventsorganizer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class MediaContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_id", nullable = false)
    private Integer eventId;

    @Column(nullable = false)
    private String caption;

    @Column(nullable = false)
    private String type;

    @Column(name = "upload_date", nullable = false)
    private LocalDateTime uploadDate;
}