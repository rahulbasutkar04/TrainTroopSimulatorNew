package org.amaap.troopsimulator.repository.impl;

import org.amaap.troopsimulator.repository.BarrackRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBarrackRepository implements BarrackRepository {
    private List<Object> troopersWaitList = new ArrayList<>();
    @Override
    public void addTrooperToBarrack(List<Object> troopers) {
        troopersWaitList.addAll(troopers);

    }
    @Override
    public List<Object> getTrooperQueueFromBarrack() {
        return  troopersWaitList;
    }
}
