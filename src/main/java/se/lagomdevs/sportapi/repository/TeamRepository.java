package se.lagomdevs.sportapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lagomdevs.sportapi.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}