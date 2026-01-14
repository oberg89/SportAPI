package se.lagomdevs.sportapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.lagomdevs.sportapi.dto.CreateTeamRequest;
import se.lagomdevs.sportapi.model.Team;
import se.lagomdevs.sportapi.repository.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team createTeam(CreateTeamRequest request) {
        if (request.getName() == null || request.getName().isBlank()) {
            throw new IllegalArgumentException("Team name cannot be blank");
        }

        Team team = new Team();
        team.setName(request.getName());

        return teamRepository.save(team);
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }


}