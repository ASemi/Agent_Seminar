package com.asemi.ailab.agent_seminar;

import java.util.ArrayList;

/**
 * Created by Wataru on 2017/02/24.
 */

public class Ability {
    //boolean invocation;
    ArrayList<Phase> actPhases;
    AbilityEffect abilityEffect;
    ArrayList<String> abilities;


    public Ability(AgentName agentName){
        //this.abilities = agentName.abilities;
        //this.invocation = false;
        setAbilities(agentName);
    }

    public void setAbilities(AgentName agentName){
        switch (agentName){
            case SPEAKER:
                //actPhases.add(Phase.SEND);
                //actPhases.add(Phase.FINISH);
                break;
            case TANK:
                break;
            case OBLIQUESHADOW:
                break;
            case TITANIUM:
                break;
            case LARKLADY:
                break;
            case SWANMAIDEN:
                break;
            case HUNTRESS:
                break;
            case BLACKHAND:
                break;
            case NIGHTMARE:
                break;
            case BARONBRUMAIRE:
                break;
            case MARKJUNIOR:
                break;
            case STATICELECTRICITY:
                break;
            case VIPER:
                break;
            case ANGEL:
                break;
            case SAVAGEASSASSIN:
                break;
            case DOUBLEKNIGHT:
                break;
            case KWONKIKU:
                break;
            case DARKFLOW:
                break;
            case DIAMONDMAN:
                break;
            case PERFUME:
                break;
            case TOUGHGUN:
                break;
            case REDBLADE:
                break;
            case ALIAS:
                break;
            case BACKFIRE:
                break;
            case TRINITY:
                break;
            case J:
                break;
            case DETECTIVE:
                break;

            case CHAINER:
                break;
            case PSYCHOPATH:
                break;
            case GOLDHEAD:
                break;
            case NEUTRAL:
                break;
            case GAMEMASTER:
                break;
            case DUELIST:
                break;
            case HANDSTANDER:
                break;
            case SMALLSPACE:
                break;
            case FILLER:
                break;
            case MOMENTSLEEP:
                break;
            case VITARITYRECORDER:
                break;
            case CHAIRMAN:
                break;
            case AMNESIA:
                break;
            case TIPSY:
                break;
            case PEPPER:
                break;
            case JUGGLER:
                break;
            case KUROSAWASENSEI:
                break;
            case LIFEGAMER:
                break;
            case SUNFLOWER:
                break;
            case FISHCAKE:
                break;

        }
    }


/*
    public void useAbility(Observer observer, Player player, String ability){
        try {
            //movement = new Movement();
            //movement.getClass().getMethod(ability);
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }
    }
*/
}
