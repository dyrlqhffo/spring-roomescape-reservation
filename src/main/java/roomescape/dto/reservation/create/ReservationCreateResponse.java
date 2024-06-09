package roomescape.dto.reservation.create;

import roomescape.dto.time.ReservationTimeResponse;

import java.time.LocalDate;

public class ReservationCreateResponse {

    private Long id;
    private LocalDate date;
    private String name;

    private ReservationTimeResponse time;

    public ReservationCreateResponse(Long id, LocalDate date, String name, ReservationTimeResponse time) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public ReservationTimeResponse getTime() {
        return time;
    }
}
