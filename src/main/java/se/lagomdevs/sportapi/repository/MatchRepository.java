package se.lagomdevs.sportapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.lagomdevs.sportapi.dto.MatchViewDto;
import se.lagomdevs.sportapi.model.Match;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("""
        SELECT new se.lagomdevs.sportapi.dto.MatchViewDto(
            m.id,
            m.homeTeam.name,
            m.awayTeam.name,
            m.homeScore,
            m.awayScore,
            m.played
        )
        FROM Match m
    """)
    List<MatchViewDto> findMatchView();
}
