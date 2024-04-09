package org.amaap.troopsimulator.repository;

import java.util.List;

public interface BarrackRepository {
    void addTrooperToBarrack(List<Object> troopers);


    List<Object> getTrooperQueueFromBarrack();
}
