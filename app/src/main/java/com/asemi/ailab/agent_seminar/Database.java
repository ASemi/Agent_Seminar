package com.asemi.ailab.agent_seminar;

/**
 * Created by Wataru on 2017/02/18.
 */

public class Database {



    public void searchAgent(AgentName agentName, AgentAttribute targetAttribute, Gender targetGender){
        switch (agentName) {
            case THE_SPEAKER:
                targetAttribute = AgentAttribute.SECRET;
                targetGender = Gender.MALE;
                break;
            case TANK:
                targetAttribute = AgentAttribute.SECRET;
                targetGender = Gender.MALE;
                break;
            case OBLIQUE_SHADOW:
                targetAttribute = AgentAttribute.SECRET;
                targetGender = Gender.FEMALE;
                break;
            case TITANIUM:
                targetAttribute = AgentAttribute.SECRET;
                targetGender = Gender.MALE;
                break;
            case LARK_LADY:
                targetAttribute = AgentAttribute.SECRET;
                targetGender = Gender.FEMALE;
                break;
            case SWAN_MAIDEN:
                targetAttribute = AgentAttribute.SECRET;
                targetGender = Gender.FEMALE;
                break;
            case HUNTLESS:
                targetAttribute = AgentAttribute.SECRET;
                targetGender = Gender.FEMALE;
                break;
            case BLACKHAND:
                targetAttribute = AgentAttribute.SECRET;
                targetGender = Gender.MALE;
                break;
            case NIGHTMARE:
                targetAttribute = AgentAttribute.SECRET;
                targetGender = Gender.FEMALE;
                break;
            case BARON_BRUMEL:
                targetAttribute = AgentAttribute.SECRET;
                targetGender = Gender.MALE;
                break;
            case MARK_JR:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case STATIC_ELECTRICITY:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.FEMALE;
                break;
            case VIPER:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case ANGEL:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.FEMALE;
                break;
            case SAVAGE_ASSASSIN:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case DOUBLE_KNIGHT:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case KWANG_KIK:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case DARK_FLOW:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case DIAMONDMAN:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case PERFUME:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.FEMALE;
                break;
            case TOUGH_GUN:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case RED_BLADE:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case ALIAS:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.FEMALE;
                break;
            case BACK_FIRE:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case TRINITY:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.FEMALE;
                break;
            case J:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
            case THE_DETECTIVE:
                targetAttribute = AgentAttribute.NOMAL;
                targetGender = Gender.MALE;
                break;
        }
    }
}
