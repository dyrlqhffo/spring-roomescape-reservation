package roomescape.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import roomescape.domain.ReservationTime;
import roomescape.dto.time.ReservationTimeRequest;
import roomescape.dto.time.ReservationTimeResponse;
import roomescape.dto.time.create.ReservationTimeCreateRequest;
import roomescape.dto.time.create.ReservationTimeCreateResponse;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class ReservationTimeRepositoryImpl implements ReservationTimeRepository{

    private JdbcTemplate jdbcTemplate;

    public ReservationTimeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReservationTimeResponse> findTimes() {
        String sql = "select id, start_at from reservation_time";

        return jdbcTemplate.query(
                sql, (rs, rowNum) -> {
                    ReservationTimeResponse reservationTimeResponse = new ReservationTimeResponse(
                            rs.getLong("id"),
                            rs.getString("start_at")
                    );
                    return reservationTimeResponse;
                });
    }
    @Override
    public ReservationTimeCreateResponse createTime(ReservationTimeCreateRequest request) {
        String sql = "insert into reservation_time(start_at) values(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(
                    sql,new String[]{"id"});
            ps.setString(1, request.getStartAt().toString());
            return ps;
        },keyHolder);

        long id = keyHolder.getKey().longValue();
        return ReservationTimeCreateResponse.toResponseDto(id, request.getStartAt().toString());
    }

    @Override
    public ReservationTimeResponse findTimeById(Long timeId) {
        String sql = "select id, start_at from reservation_time where id = ?";
        return jdbcTemplate.queryForObject(
                sql, (rs, rowNUm) -> {
                    ReservationTimeResponse response = new ReservationTimeResponse(
                            rs.getLong("id"),
                            rs.getString("start_at")
                    );
                    return response;
                }, timeId);
    }

    @Override
    public void deleteTime(Long id) {
        String sql = "delete from reservation_time where id = ?";
        jdbcTemplate.update(sql, Long.valueOf(id));
    }
}
