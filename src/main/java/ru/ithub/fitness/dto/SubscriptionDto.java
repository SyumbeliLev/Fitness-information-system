package ru.ithub.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto {
    private Long id;
    private String name;
    private String description;
    private Set<Long> includedOfferIds = new HashSet<>();
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
