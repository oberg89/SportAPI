package se.lagomdevs.sportapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class UpdateMatchResultRequest {
    private Integer homeScore;
    private Integer awayScore;
}
