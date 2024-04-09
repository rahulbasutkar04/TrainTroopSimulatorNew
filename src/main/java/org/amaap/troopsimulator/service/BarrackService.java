package org.amaap.troopsimulator.service;

import org.amaap.troopsimulator.domain.model.Archer;
import org.amaap.troopsimulator.domain.model.Barbarian;
import org.amaap.troopsimulator.repository.BarrackRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BarrackService {
    private BarrackRepository barrackRepository;
    private List<Object> trooperQueueInBarrack = new ArrayList<>();
    private TroopService troopService;
    private Queue<Object> trainedTroops = new LinkedList<>();
    private final int maxCapacity = 10;

    public Queue<Object> getTrainedTroops() {
        return trainedTroops;
    }

    public BarrackService(TroopService troopService, BarrackRepository barrackRepository) {
        this.barrackRepository = barrackRepository;
        this.troopService = troopService;
    }

    public List<Object> getTrooperQueueFromBarrack() {
        return barrackRepository.getTrooperQueueFromBarrack();
    }

    public void addTrooperToBarrack(List<Object> troopers) {
        barrackRepository.addTrooperToBarrack(troopers);

    }

    public void train() {
        List<Object> troopQueue = getTrooperQueueFromBarrack();

        while (!troopQueue.isEmpty()) {
            List<Object> batchToTrain = troopQueue.subList(0, Math.min(maxCapacity, troopQueue.size()));

            System.out.println("Training batch...");
            for (int i = 0; i < batchToTrain.size(); i++) {
                Object trooper = batchToTrain.get(i);
                if (trooper instanceof Archer) {
                    Archer archer = (Archer) trooper;
                    try {
                        Thread.sleep(archer.getTrainingTime() * 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    trainedTroops.add(archer);
                } else if (trooper instanceof Barbarian) {
                    Barbarian barbarian = (Barbarian) trooper;
                    try {
                        Thread.sleep(barbarian.getTrainingTime() * 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    trainedTroops.add(barbarian);
                }
            }
            troopQueue.removeAll(batchToTrain);
        }
    }

    //TODO:now data data is getting stored here in trainedTroop we need to implement an storage in repository->DB

}