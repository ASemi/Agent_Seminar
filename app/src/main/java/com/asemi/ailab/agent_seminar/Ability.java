package com.asemi.ailab.agent_seminar;

import java.util.ArrayList;

/**
 * Created by Wataru on 2017/02/24.
 */

public class Ability {
    boolean invocation;
    AbilityEffect abilityEffect;
    ArrayList<String> abilities;
    Movement movement;

    public Ability(AgentName agentName){
        //this.abilities = agentName.abilities;
        this.invocation = false;
    }

    public void useAbility(Observer observer, Player player, String ability){
        try {
            movement = new Movement();
            movement.getClass().getMethod(ability);
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }
    }
}
