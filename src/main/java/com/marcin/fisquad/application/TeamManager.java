package com.marcin.fisquad.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamManager {

    private TeamRepo teamRepo;

    @Autowired
    public TeamManager(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public Optional<Team> findById(Long id) {
        return teamRepo.findById(id);
    }

    public Iterable<Team> findAll() {
        return teamRepo.findAll();
    }

    public Team save(Team team) {
        return teamRepo.save(team);
    }

    public Iterable<Team> save(List<Team> teams) {
        return teamRepo.saveAll(teams);
    }

    public void deleteById(Long id) {
        teamRepo.deleteById(id);
    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB() {
//        save(new Team(1L,"REAL MADRID",1));
//        save(new Team(2L,"BARCELONA",1));
//        save(new Team(3L,"BARCELONA",1));
//        save(new Team(4L,"BARCELONA",1));
//        save(new Team(5L,"BARCELONA",1));
//    }

}
