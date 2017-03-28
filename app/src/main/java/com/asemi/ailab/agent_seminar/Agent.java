package com.asemi.ailab.agent_seminar;

import java.util.ArrayList;

/**
 * Created by wataru on 17/02/17.
 */

public class Agent {
    AgentName agentName;
    AgentAttribute agentAttribute;
    Gender gender;
    Ability ability;
    Grade grade;
    Rarity rarity;
    boolean open; //エージェント公開状態になっているかどうか

    public Agent(AgentName agentName){
        this.agentName = agentName;
        this.agentAttribute = agentName.agentAttribute;
        this.gender = agentName.gender;
        this.ability = new Ability(agentName);
        this.grade = agentName.grade;
        this.rarity = agentName.rarity;
        if(agentName.agentAttribute == AgentAttribute.SECRET){
            this.open = false;
        }else{
            this.open = true;
        }
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
