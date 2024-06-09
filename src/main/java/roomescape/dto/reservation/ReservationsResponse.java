package roomescape.dto.reservation;

import roomescape.dto.time.ReservationTimeResponse;

public class ReservationsResponse {

    private Long id;

    private String name;
    private String date;

    private ReservationTimeResponse time;


    public ReservationsResponse() {
    }

    public ReservationsResponse(Long id, String name, String date, Long timeId, String startAt) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = new ReservationTimeResponse(timeId, startAt);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public ReservationTimeResponse getTime() {
        return time;
    }
}
