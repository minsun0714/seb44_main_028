package com.ftiland.travelrental.reservation.dto;

import com.ftiland.travelrental.reservation.status.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowReservationDto {

    private String reservationId;
    private String image;
    private String title;

    private LocalDate startDate;
    private LocalDate endDate;
    private ReservationStatus status;
}
