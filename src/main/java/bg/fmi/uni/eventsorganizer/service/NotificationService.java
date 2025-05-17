package bg.fmi.uni.eventsorganizer.service;

import bg.fmi.uni.eventsorganizer.dto.NotificationDto;
import bg.fmi.uni.eventsorganizer.model.Notification;
import bg.fmi.uni.eventsorganizer.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public List<NotificationDto> getUnreadNotificationsByUserId(Integer userId) {
        return notificationRepository.findAll().stream()
                .filter(notification -> notification.getUserId().equals(userId) && !notification.isReceived())
                .map(this::toDto)
                .toList();
    }

    public boolean markNotificationAsReceived(Integer id) {
        Optional<Notification> notificationOpt = notificationRepository.findById(id);
        if (notificationOpt.isPresent()) {
            Notification notification = notificationOpt.get();
            notification.setReceived(true);
            notificationRepository.save(notification);
            return true;
        }
        return false;
    }

    public void deleteAllNotificationsByUserId(Integer userId) {
        notificationRepository.findAll().stream()
                .filter(notification -> notification.getUserId().equals(userId))
                .forEach(notification -> notificationRepository.deleteById(notification.getId()));
    }

    public List<NotificationDto> getNotificationsByUserId(Integer userId) {
        return notificationRepository.findAll().stream()
                .filter(notification -> notification.getUserId().equals(userId))
                .map(this::toDto)
                .toList();
    }

    private NotificationDto toDto(Notification notification) {
        return new NotificationDto(
                notification.getId(),
                notification.getEventId(),
                notification.getUserId(),
                notification.isReceived(),
                notification.getSendAt(),
                notification.getMessageContent()
        );
    }
}