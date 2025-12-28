package com.EmailAutomation.UserService.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "UserInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String firstName;
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    @NotBlank
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Invalid Indian mobile number"
    )
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private STATUS UserStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
