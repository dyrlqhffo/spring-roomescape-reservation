package roomescape.domain;

import java.time.LocalDate;

public class Reservation {

    private Long id;
    private String name;
    private LocalDate date;

    private ReservationTime time;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public ReservationTime getTime() {
        return time;
    }
}
