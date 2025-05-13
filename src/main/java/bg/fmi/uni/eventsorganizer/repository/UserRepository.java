package bg.fmi.uni.eventsorganizer.repository;

import bg.fmi.uni.eventsorganizer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}