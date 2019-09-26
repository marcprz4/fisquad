package com.marcin.fisquad.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerManager {

    private PlayerRepo playerRepo;

    @Autowired
    public PlayerManager(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Iterable<Player> findAll() {
        return playerRepo.findAll();
    }

    public Iterable<Player> save(List<Player> players) {
        return playerRepo.saveAll(players);
    }
}
