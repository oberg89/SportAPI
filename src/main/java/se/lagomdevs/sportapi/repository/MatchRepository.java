package se.lagomdevs.sportapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lagomdevs.sportapi.model.Match;

import java.util.List;

@Repository

public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByHomeTeamIdOrAwayTeamId(Long homeTeamId, Long awayTeamId);
}
