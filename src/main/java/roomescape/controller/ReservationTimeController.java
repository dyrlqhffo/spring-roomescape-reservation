package roomescape.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roomescape.domain.ReservationTime;
import roomescape.dto.time.ReservationTimeRequest;
import roomescape.dto.time.ReservationTimeResponse;
import roomescape.dto.time.create.ReservationTimeCreateRequest;
import roomescape.dto.time.create.ReservationTimeCreateResponse;
import roomescape.repository.ReservationTimeRepository;

import java.util.List;

@RestController
@RequestMapping("/times")
public class ReservationTimeController {

    ReservationTimeRepository reservationTimeRepository;

    public ReservationTimeController(ReservationTimeRepository reservationTimeRepository) {
        this.reservationTimeRepository = reservationTimeRepository;
    }

    @GetMapping
    public ResponseEntity<List<ReservationTimeResponse>> findTimes() {
        List<ReservationTimeResponse> list = reservationTimeRepository.findTimes();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ReservationTimeCreateResponse> createTime(@RequestBody ReservationTimeCreateRequest request) {
        ReservationTimeCreateResponse time = reservationTimeRepository.createTime(request);
        return ResponseEntity.ok().body(time);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTime(@PathVariable Long id) {
        reservationTimeRepository.deleteTime(id);
        return ResponseEntity.ok().build();
    }

    @PostConstruct
    public void init() {
        createTime(new ReservationTimeCreateRequest("22:00"));
        createTime(new ReservationTimeCreateRequest("23:00"));
    }
}
