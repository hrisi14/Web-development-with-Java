package bg.fmi.uni.eventsorganizer.service;

import bg.fmi.uni.eventsorganizer.dto.MediaContentDto;
import bg.fmi.uni.eventsorganizer.model.MediaContent;
import bg.fmi.uni.eventsorganizer.repository.MediaContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MediaContentService {
    private final MediaContentRepository mediaContentRepository;

    public List<MediaContentDto> getAllMediaContents() {
        return mediaContentRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public Optional<MediaContentDto> getMediaContentById(Integer id) {
        return mediaContentRepository.findById(id).map(this::toDto);
    }

    public MediaContentDto createMediaContent(MediaContentDto mediaContentDto) {
        MediaContent mediaContent = toEntity(mediaContentDto);
        return toDto(mediaContentRepository.save(mediaContent));
    }

    public boolean updateMediaContent(Integer id, MediaContentDto mediaContentDto) {
        if (mediaContentRepository.existsById(id)) {
            MediaContent mediaContent = toEntity(mediaContentDto);
            mediaContent.setId(id);
            mediaContentRepository.save(mediaContent);
            return true;
        }
        return false;
    }

    public boolean deleteMediaContent(Integer id) {
        if (mediaContentRepository.existsById(id)) {
            mediaContentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // New Methods
    public List<MediaContentDto> getMediaContentsByEventId(Integer eventId) {
        return mediaContentRepository.findAll().stream()
                .filter(mediaContent -> mediaContent.getEventId().equals(eventId))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<MediaContentDto> getMediaContentsByType(String type) {
        return mediaContentRepository.findAll().stream()
                .filter(mediaContent -> mediaContent.getType().equalsIgnoreCase(type))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public long countMediaContentsByEventId(Integer eventId) {
        return mediaContentRepository.findAll().stream()
                .filter(mediaContent -> mediaContent.getEventId().equals(eventId))
                .count();
    }

    private MediaContentDto toDto(MediaContent mediaContent) {
        return new MediaContentDto(
                mediaContent.getId(),
                mediaContent.getEventId(),
                mediaContent.getCaption(),
                mediaContent.getType(),
                mediaContent.getUploadDate()
        );
    }

    private MediaContent toEntity(MediaContentDto mediaContentDto) {
        MediaContent mediaContent = new MediaContent();
        mediaContent.setId(mediaContentDto.id());
        mediaContent.setEventId(mediaContentDto.eventId());
        mediaContent.setCaption(mediaContentDto.caption());
        mediaContent.setType(mediaContentDto.type());
        mediaContent.setUploadDate(mediaContentDto.uploadDate());
        return mediaContent;
    }
}