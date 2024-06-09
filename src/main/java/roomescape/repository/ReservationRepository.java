package roomescape.repository;

import roomescape.dto.reservation.ReservationsResponse;
import roomescape.dto.reservation.create.ReservationCreateRequest;
import roomescape.dto.reservation.create.ReservationCreateResponse;
import roomescape.dto.time.ReservationTimeResponse;

import java.util.List;

public interface ReservationRepository {

    List<ReservationsResponse> findReservations();

    ReservationCreateResponse create(ReservationCreateRequest request, ReservationTimeResponse tiomResponse);

    void deleteReservation(Long id);
}
