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

    public void searchAgentInformation(AgentName agentName, Database database){
        AgentAttribute targetAttribute = AgentAttribute.NOMAL;
        Gender targetGender = Gender.NONE;
        /* データベースからの検索（性別・属性） */
        database.searchAgent(agentName, targetAttribute, targetGender);
        this.agentAttribute = targetAttribute;
        this.gender = targetGender;
    }


}
