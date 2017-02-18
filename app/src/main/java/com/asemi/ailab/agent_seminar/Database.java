package com.asemi.ailab.agent_seminar;

/**
 * Created by Wataru on 2017/02/18.
 */

public class Database {

    public void searchAgent(Agent targetAgent){
        switch (targetAgent.agentName) {
            case THE_SPEAKER:
                targetAgent.agentAttribute = AgentAttribute.SECRET;
                targetAgent.gender = Gender.MALE;
                break;
            case TANK:
                targetAgent.agentAttribute = AgentAttribute.SECRET;
                targetAgent.gender = Gender.MALE;
                break;
            case OBLIQUE_SHADOW:
                targetAgent.agentAttribute = AgentAttribute.SECRET;
                targetAgent.gender = Gender.FEMALE;
                break;
            case TITANIUM:
                targetAgent.agentAttribute = AgentAttribute.SECRET;
                targetAgent.gender = Gender.MALE;
                break;
            case LARK_LADY:
                targetAgent.agentAttribute = AgentAttribute.SECRET;
                targetAgent.gender = Gender.FEMALE;
                break;
            case SWAN_MAIDEN:
                targetAgent.agentAttribute = AgentAttribute.SECRET;
                targetAgent.gender = Gender.FEMALE;
                break;
            case HUNTLESS:
                targetAgent.agentAttribute = AgentAttribute.SECRET;
                targetAgent.gender = Gender.FEMALE;
                break;
            case BLACKHAND:
                targetAgent.agentAttribute = AgentAttribute.SECRET;
                targetAgent.gender = Gender.MALE;
                break;
            case NIGHTMARE:
                targetAgent.agentAttribute = AgentAttribute.SECRET;
                targetAgent.gender = Gender.FEMALE;
                break;
            case BARON_BRUMEL:
                targetAgent.agentAttribute = AgentAttribute.SECRET;
                targetAgent.gender = Gender.MALE;
                break;
            case MARK_JR:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case STATIC_ELECTRICITY:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.FEMALE;
                break;
            case VIPER:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case ANGEL:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.FEMALE;
                break;
            case SAVAGE_ASSASSIN:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case DOUBLE_KNIGHT:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case KWANG_KIK:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case DARK_FLOW:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case DIAMONDMAN:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case PERFUME:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.FEMALE;
                break;
            case TOUGH_GUN:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case RED_BLADE:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case ALIAS:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.FEMALE;
                break;
            case BACK_FIRE:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case TRINITY:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.FEMALE;
                break;
            case J:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
            case THE_DETECTIVE:
                targetAgent.agentAttribute = AgentAttribute.NOMAL;
                targetAgent.gender = Gender.MALE;
                break;
        }
    }
}
