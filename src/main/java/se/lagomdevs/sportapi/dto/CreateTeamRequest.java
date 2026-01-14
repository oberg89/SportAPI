package se.lagomdevs.sportapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lagomdevs.sportapi.service.TeamService;

@Getter
@Setter
public class CreateTeamRequest {

    private String name;
    
}