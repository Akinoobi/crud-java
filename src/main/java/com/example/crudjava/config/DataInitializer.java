package com.example.crudjava.config;

import com.example.crudjava.entity.User;
import com.example.crudjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Clear existing data
        userRepository.deleteAll();

        // Create sample users
        User user1 = new User("John Doe", "john.doe@example.com", "password123", "+1234567890");
        User user2 = new User("Jane Smith", "jane.smith@example.com", "password456", "+0987654321");
        User user3 = new User("Bob Johnson", "bob.johnson@company.com", "password789", "+1122334455");
        User user4 = new User("Alice Brown", "alice.brown@test.org", "passwordabc", "+1555666777");
        User user5 = new User("Charlie Wilson", "charlie.wilson@demo.net", "passworddef", "+1999888777");

        // Save users
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        System.out.println("Sample data initialized successfully!");
        System.out.println("Created " + userRepository.count() + " users");
    }
}
