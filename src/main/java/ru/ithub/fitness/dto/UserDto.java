package ru.ithub.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String fio;
    private String email;
    private String password;
    private Long phone;
    private LocalDate birthDate;
    private Long authorityId;
    private Boolean isActive;
    private UUID userCardId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
