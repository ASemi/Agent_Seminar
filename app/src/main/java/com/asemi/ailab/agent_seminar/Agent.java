package com.asemi.ailab.agent_seminar;

/**
 * Created by wataru on 17/02/17.
 */

public class Agent {
    AgentName agentName;
    AgentAttribute agentAttribute;
    Gender gender;

    public void getAgent(AgentName agentName){
        this.agentName = agentName;
        searchAgentInformation(this.agentName);
    }

    public void searchAgentInformation(AgentName agentName){
        AgentAttribute targetAttribute;
        Gender targetGender;
        /* データベースからの検索（性別・属性） */

        this.agentAttribute = targetAttribute;
        this.gender = targetGender;
    }


}
