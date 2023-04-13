package ru.ithub.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCardDto {
    private UUID id;
    private Boolean isEnabled;
    private UUID userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
