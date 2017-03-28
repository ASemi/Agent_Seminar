package com.asemi.ailab.agent_seminar;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wataru on 2017/03/28.
 */

public class GachaList {
    //ArrayList<Map<AgentName, Boolean>> agentGachaList;
    Map<AgentName, Boolean> gachaMap;
    //AgentName agentName;

    public GachaList(){
        gachaMap = new HashMap<>();
        for(AgentName agentName : AgentName.values()) {
            gachaMap.put(agentName, false);
            //agentGachaList.add(new HashMap<AgentName, Boolean>(){});
        }
    }
}
