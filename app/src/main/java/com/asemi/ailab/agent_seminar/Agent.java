package com.asemi.ailab.agent_seminar;

/**
 * Created by wataru on 17/02/17.
 */

public class Agent {
    AgentName agentName;
    AgentAttribute agentAttribute;
    Gender gender;

    public Agent(Database database, AgentName agentName){
        this.agentName = agentName;
        searchAgentInformation(this.agentName, database);
    }

    public Agent(AgentName agentName){
        this.agentName = agentName;
    }

    public void searchAgentInformation(AgentName agentName, Database database){
        Agent targetAgent = new Agent(agentName);
        /* データベースからの検索（性別・属性） */
        database.searchAgent(targetAgent);
        this.agentAttribute = targetAgent.agentAttribute;
        this.gender = targetAgent.gender;
    }
}
