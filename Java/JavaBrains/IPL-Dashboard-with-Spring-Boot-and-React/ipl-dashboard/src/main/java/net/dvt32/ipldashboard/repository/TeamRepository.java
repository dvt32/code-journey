package net.dvt32.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import net.dvt32.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
    
    Team findByTeamName(String teamName);

}
