package bg.fmi.uni.eventsorganizer.repository;

import bg.fmi.uni.eventsorganizer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}