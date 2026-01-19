package se.lagomdevs.sportapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class MatchViewDto {


    private Long id;
    private String homeTeam;
    private String awayTeam;
    private Integer homeScore;
    private Integer awayScore;
    private boolean played;


    public MatchViewDto(
            Long id,
            String homeTeam,
            String awayTeam,
            Integer homeScore,
            Integer awayScore,
            boolean played
    ) {
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.played = played;
    }

    // getters (eller Lombok @Getter)
}
