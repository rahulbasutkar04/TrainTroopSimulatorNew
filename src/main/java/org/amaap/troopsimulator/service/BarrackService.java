package org.amaap.troopsimulator.service;

import org.amaap.troopsimulator.repository.BarrackRepository;
import org.amaap.troopsimulator.repository.impl.InMemoryBarrackRepository;

import java.util.ArrayList;
import java.util.List;

public class BarrackService {
    private BarrackRepository barrackRepository;
    private List<Object> trooperQueueInBarrack = new ArrayList<>();
    private TroopService troopService;

    public BarrackService(TroopService troopService, BarrackRepository barrackRepository) {
        this.barrackRepository = barrackRepository;
        this.troopService = troopService;
    }

    public List<Object> getTrooperQueueInBarrack() {
        return trooperQueueInBarrack;
    }

    public void addTrooperToBarrack(List<Object> troopers) {
        barrackRepository.addTrooperToBarrack(troopers);

    }

    public void train() {
        // convert list to queue and clear the list then will get all the troops in the queue, and
        // then we are passing the troops
        // batch and adding that data to repo and removing from queue till it gts empty

    }

}
