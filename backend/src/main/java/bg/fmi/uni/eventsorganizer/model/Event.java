package bg.fmi.uni.eventsorganizer.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String category;
    private String location;
    private String imageUrl; //a newly-added element because of event rendering
    private Integer likes;
    private Integer followers;
    private Integer visitors;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    private String rules;

    @Column(name = "organizer_id")
    private Integer organizerId;


    @Column(name = "sponsor_id")
    private Integer sponsorId;

    public Event(Integer id, String title, String description, String category, String location,
                 String imageUrl, Integer likes, Integer followers, Integer visitors,
                 LocalDateTime startDate, LocalDateTime endDate, String rules, Integer organizerId, Integer sponsorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.imageUrl = imageUrl;
        this.likes = likes;
        this.followers = followers;
        this.visitors = visitors;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rules = rules;
        this.organizerId = organizerId;
        this.sponsorId = sponsorId;
    }
}