package bg.fmi.uni.eventsorganizer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EventsOrganizerApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(EventsOrganizerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 Application started successfully!");
        System.out.println("---------------------------------------");
    }
}
