package se.lagomdevs.sportapi.dto;

public record MatchViewDto(
        Long id,
        String homeTeam,
        String awayTeam,
        Integer homeScore,
        Integer awayScore,
        boolean played
) {}
