package bg.fmi.uni.eventsorganizer.controller;

import bg.fmi.uni.eventsorganizer.dto.MediaContentDto;
import bg.fmi.uni.eventsorganizer.service.MediaContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/media-contents")
public class MediaContentController {
    private final MediaContentService mediaContentService;

    @Autowired
    public MediaContentController(MediaContentService mediaContentService) {
        this.mediaContentService = mediaContentService;
    }

    @GetMapping
    public List<MediaContentDto> getAllMediaContents() {
        return mediaContentService.getAllMediaContents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaContentDto> getMediaContentById(@PathVariable Integer id) {
        return mediaContentService.getMediaContentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MediaContentDto> createMediaContent(@RequestBody MediaContentDto dto) {
        MediaContentDto created = mediaContentService.createMediaContent(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MediaContentDto> updateMediaContent(@PathVariable Integer id, @RequestBody MediaContentDto dto) {
        return mediaContentService.updateMediaContent(id, dto)
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMediaContent(@PathVariable Integer id) {
        if (mediaContentService.deleteMediaContent(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/event/{eventId}")
    public List<MediaContentDto> getMediaContentsByEventId(@PathVariable Integer eventId) {
        return mediaContentService.getMediaContentsByEventId(eventId);
    }

    @GetMapping("/type/{type}")
    public List<MediaContentDto> getMediaContentsByType(@PathVariable String type) {
        return mediaContentService.getMediaContentsByType(type);
    }

    @GetMapping("/count/event/{eventId}")
    public long countMediaContentsByEventId(@PathVariable Integer eventId) {
        return mediaContentService.countMediaContentsByEventId(eventId);
    }
}