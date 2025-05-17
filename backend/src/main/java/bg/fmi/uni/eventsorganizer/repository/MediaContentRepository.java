package bg.fmi.uni.eventsorganizer.repository;

import bg.fmi.uni.eventsorganizer.model.MediaContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaContentRepository extends JpaRepository<MediaContent, Integer> {
}