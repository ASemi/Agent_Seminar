package com.asemi.ailab.agent_seminar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wataru on 2017/03/28.
 */

public class Gacha {
    private int rarity_num;
    private List<AgentName> mLotBallList;
    Map<AgentName, Integer> gachaMap  = new HashMap<>();

    public Gacha(ArrayList<AgentName> agentNames) {
        for(int i=0; i<agentNames.size(); i++){

            switch (agentNames.get(i).rarity){
                case NORMAL:
                    rarity_num = 10;
                    break;
                case RARE:
                    rarity_num = 5;
                    break;
                case SUPER:
                    rarity_num = 3;
                    break;
                case ULTRA:
                    rarity_num = 2;
                    break;
            }
            gachaMap.put(agentNames.get(i), rarity_num);
        }
        mLotBallList = createGacha(gachaMap);
    }

    /**
     * ガラポンを回してアイテムNoを一つ取得する。
     *
     * @return int
     */
    public AgentName playGacha() {
        Collections.shuffle(mLotBallList);
        return  mLotBallList.get(0);
    }

    private static List<AgentName> createGacha(Map<AgentName, Integer> gachaMap) {
        List<AgentName> lotBalls = new ArrayList<AgentName>();
        for (AgentName key : gachaMap.keySet()) {
            for (int i = 0; i < gachaMap.get(key); i++) {
                lotBalls.add(key);
            }
        }
        return lotBalls;
    }
}
