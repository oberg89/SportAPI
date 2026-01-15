package se.lagomdevs.sportapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMatchRequest {

    private Long homeTeamId;
    private Long awayTeamId;
}
