package com.asemi.ailab.agent_seminar;

import java.util.ArrayList;

/**
 * Created by wataru on 17/02/17.
 */

public class Agent {
    AgentName agentName;
    AgentAttribute agentAttribute;
    Gender gender;

    public Agent(AgentName agentName){
        this.agentName = agentName;
        this.agentAttribute = agentName.agentAttribute;
        this.gender = agentName.gender;
    }

    /*
    public void searchAgentInformation(AgentName agentName){
        Agent targetAgent = new Agent(agentName);
        database.searchAgent(targetAgent);
        this.agentAttribute = targetAgent.agentAttribute;
        this.gender = targetAgent.gender;
    }
    */
}
