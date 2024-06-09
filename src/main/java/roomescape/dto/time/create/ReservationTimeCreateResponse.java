package roomescape.dto.time.create;

import java.time.LocalTime;

public class ReservationTimeCreateResponse {

    private Long id;
    private LocalTime startAt;

    public static ReservationTimeCreateResponse toResponseDto(Long id, String startAt) {
        return new ReservationTimeCreateResponse(id, startAt);
    }

    public ReservationTimeCreateResponse(Long id, String startAt) {
        this.id = id;
        this.startAt = LocalTime.parse(startAt);
    }

    public Long getId() {
        return id;
    }

    public LocalTime getStartAt() {
        return startAt;
    }
}
