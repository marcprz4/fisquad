package com.marcin.fisquad.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamsApi {


    private TeamManager teamManager;
    private PlayerManager playerManager;

    @Autowired
    public TeamsApi(TeamManager teamManager, PlayerManager playerManager) {
        this.teamManager = teamManager;
        this.playerManager = playerManager;
    }

    @GetMapping("/all")
    public Iterable<Team> getAll() {
        return teamManager.findAll();
    }

    @GetMapping
    public Iterable<Team> getById(@RequestParam List<Long> index) {
        List<Team> result = new ArrayList<>();

        for (Long i : index) {
            result.add(teamManager.findById(i).get());
        }
        return result;
    }

    //secured////////////////////////////////////

    @PostMapping
    public Iterable<Team> addTeams(@RequestBody List<Team> teams) {
        return teamManager.save(teams);
    }

    @PutMapping
    public Team updateTeam(@RequestBody Team team) {
        return teamManager.save(team);
    }

    @DeleteMapping
    public void deleteTeam(@RequestParam Long index) {
        teamManager.deleteById(index);
    }

    //players////////////////////////////////////

    @PostMapping("/loadPlayers")
    public Iterable<Player> addPlayers(@RequestBody List<Player> players) {
        return playerManager.save(players);
    }

    @GetMapping("/allPlayers")
    public Iterable<Player> getAllPlayers() {
        return playerManager.findAll();
    }

    //merged////////////////////////////////////


}