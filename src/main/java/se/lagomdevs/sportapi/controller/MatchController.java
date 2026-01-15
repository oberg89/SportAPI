package se.lagomdevs.sportapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lagomdevs.sportapi.dto.CreateMatchRequest;
import se.lagomdevs.sportapi.dto.UpdateMatchResultRequest;
import se.lagomdevs.sportapi.model.Match;
import se.lagomdevs.sportapi.service.MatchService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody CreateMatchRequest request){
        Match created = matchService.createMatch(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Match>> getMatches(){
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @PutMapping("/{id}/result")
    public ResponseEntity<Match> updateResult(
            @PathVariable Long id,
            @RequestBody UpdateMatchResultRequest request) {
        Match updated = matchService.updateResult(id, request);
        return ResponseEntity.ok(updated);
    }
}
