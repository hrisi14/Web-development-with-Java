package bg.fmi.uni.eventsorganizer.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter  //getter, setter i nakraya ne rabotyat

public class UserSessionDto {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
