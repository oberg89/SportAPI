package se.lagomdevs.sportapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.lagomdevs.sportapi.dto.CreateMatchRequest;
import se.lagomdevs.sportapi.dto.UpdateMatchResultRequest;
import se.lagomdevs.sportapi.model.Match;
import se.lagomdevs.sportapi.repository.MatchRepository;
import se.lagomdevs.sportapi.repository.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MatchService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    public Match createMatch(CreateMatchRequest request){

        if (request.getHomeTeamId().equals(request.getAwayTeamId())) {
            throw new IllegalArgumentException("Ett lag kan inte möta sig själv");
        }

        var homeTeam = teamRepository.findById(request.getHomeTeamId())
                .orElseThrow(() -> new IllegalArgumentException("Hemmalag finns inte"));

        var awayTeam = teamRepository.findById(request.getAwayTeamId())
                .orElseThrow(() -> new IllegalArgumentException("Bortalag finns inte"));

        var match = new Match();
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setPlayed(false);
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches(){
        return matchRepository.findAll();
    }

    public Match updateResult(Long matchId, UpdateMatchResultRequest request) {
        var match = matchRepository.findById(matchId)
                .orElseThrow(() -> new IllegalArgumentException("Match finns inte"));

        if (request.getHomeScore() < 0 || request.getAwayScore() < 0) {
            throw new IllegalArgumentException("Resultat kan inte vara negativt");

        }

        match.setHomeScore(request.getHomeScore());
        match.setAwayScore(request.getAwayScore());
        match.setPlayed(true);
        return matchRepository.save(match);

    }

}
