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
public class HistoryPaymentDto {
    private Long id;
    private UUID providedOfferId;
    private UUID userId;
    private LocalDateTime dateOfPay;
    private LocalDateTime createdAt;
}
