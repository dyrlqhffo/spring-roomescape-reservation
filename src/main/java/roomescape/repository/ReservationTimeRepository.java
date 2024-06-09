package roomescape.repository;

import roomescape.domain.ReservationTime;
import roomescape.dto.time.ReservationTimeRequest;
import roomescape.dto.time.ReservationTimeResponse;
import roomescape.dto.time.create.ReservationTimeCreateRequest;
import roomescape.dto.time.create.ReservationTimeCreateResponse;

import java.util.List;

public interface ReservationTimeRepository {

    List<ReservationTimeResponse> findTimes();

    ReservationTimeCreateResponse createTime(ReservationTimeCreateRequest request);

    ReservationTimeResponse findTimeById(Long timeId);

    void deleteTime(Long id);
}
