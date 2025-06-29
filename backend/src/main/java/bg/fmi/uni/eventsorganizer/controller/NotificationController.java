package bg.fmi.uni.eventsorganizer.controller;

import bg.fmi.uni.eventsorganizer.dto.NotificationDto;
import bg.fmi.uni.eventsorganizer.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public List<NotificationDto> getNotificationsByUserId(@RequestParam Integer userId) {
        return notificationService.getNotificationsByUserId(userId);
    }

    @GetMapping("/notifications/unread")
    public List<NotificationDto> getUnreadNotificationsByUserId(@RequestParam Integer userId) {
        return notificationService.getUnreadNotificationsByUserId(userId);
    }

    @PutMapping("/notifications/{id}/mark-received")
    public ResponseEntity<Void> markNotificationAsReceived(@PathVariable Integer id) {
        if (notificationService.markNotificationAsReceived(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/notifications")
    public ResponseEntity<Void> deleteAllNotificationsByUserId(@RequestParam Integer userId) {
        notificationService.deleteAllNotificationsByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}