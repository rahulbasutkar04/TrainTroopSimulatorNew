package org.amaap.troopsimulator.repository;

import java.util.List;

public  interface TroopRepository  {
     void insert(int troopCount, String troopType);

     List<Object> getBarbarians();

     List<Object> getArchers();
}
