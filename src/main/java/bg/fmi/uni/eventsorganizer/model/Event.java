package bg.fmi.uni.eventsorganizer.model;

import java.time.LocalDateTime;

public class Event {
    private static int eventIdCounter = 1;

    private Integer id;
    private String title;
    private String description;
    private String category;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String rules;
    private int organizerId;
    private int sponsorId;

    public Event(String title, String description, String category, String location,
                 LocalDateTime startDate, LocalDateTime endDate, String rules,
                 int organizerId, int sponsorId) {
        this.id = eventIdCounter++;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rules = rules;
        this.organizerId = organizerId;
        this.sponsorId = sponsorId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public String getRules() {
        return rules;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }
}