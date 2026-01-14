package se.lagomdevs.sportapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import se.lagomdevs.sportapi.service.TeamService;
import se.lagomdevs.sportapi.model.Team;
import se.lagomdevs.sportapi.dto.CreateTeamRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")

public class TeamController {

    private TeamService teamService;

@PostMapping
    public Team createTeam(@RequestBody CreateTeamRequest request) {
        return teamService.createTeam(request);
    }

    @GetMapping
    public List<Team> getTeams(){
        return teamService.getAllTeams();
    }
}