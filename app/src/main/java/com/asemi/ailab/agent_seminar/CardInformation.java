package com.asemi.ailab.agent_seminar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wataru on 17/02/17.
 */

//public enum CardInformation {
//}

enum Side {
    KDR, FRS, MOF
}
enum Color {
    RED, BLUE, BLACK
}
enum SendMethod {
    SECRECY, CONFIDENTIAL, RELEASE
}
enum Strategy{
    LOCKON, DISTRIBUTE, INTERCEPT, DECODE, COUNTERACT, TRAP/*誤導*/, PROVEDRAW, PROVEDUMP, DELETE, TRANSFER

}
enum Lockon {
    LOCKON, LOST, NORMAL
}
enum AgentAttribute {
    SECRET, PUBLIC, NOMAL
}
enum AbilityEffect {
    RESIDENT, MOMENT
}
enum Gender {
    MALE, FEMALE, NONE
}
enum AgentName {
    /* 既存エージェント */
    SPEAKER(AgentAttribute.SECRET, Gender.MALE, "imputation", ""), TANK(AgentAttribute.SECRET, Gender.MALE),
    OBLIQUESHADOW(AgentAttribute.SECRET, Gender.FEMALE), TITANIUM(AgentAttribute.SECRET, Gender.MALE),
    LARKLADY(AgentAttribute.SECRET, Gender.FEMALE), SWANMAIDEN(AgentAttribute.SECRET, Gender.FEMALE),
    HUNTRESS(AgentAttribute.SECRET, Gender.FEMALE), BLACKHAND(AgentAttribute.SECRET, Gender.MALE),
    NIGHTMARE(AgentAttribute.SECRET, Gender.FEMALE), BARONBRUMAIRE(AgentAttribute.SECRET, Gender.MALE),
    MARKJUNIOR(AgentAttribute.NOMAL, Gender.MALE), STATICELECTRICITY(AgentAttribute.NOMAL, Gender.FEMALE),
    VIPER(AgentAttribute.NOMAL, Gender.MALE), ANGEL(AgentAttribute.NOMAL, Gender.FEMALE),
    SAVAGEASSASSIN(AgentAttribute.NOMAL, Gender.MALE), DOUBLEKNIGHT(AgentAttribute.NOMAL, Gender.MALE),
    KWONKIKU(AgentAttribute.NOMAL, Gender.MALE), DARKFLOW(AgentAttribute.NOMAL, Gender.MALE),
    DIAMONDMAN(AgentAttribute.NOMAL, Gender.MALE), PERFUME(AgentAttribute.NOMAL, Gender.FEMALE),
    TOUGHGUN(AgentAttribute.NOMAL, Gender.MALE), REDBLADE(AgentAttribute.NOMAL, Gender.MALE),
    ALIAS(AgentAttribute.NOMAL, Gender.FEMALE), BACKFIRE(AgentAttribute.NOMAL, Gender.MALE),
    TRINITY(AgentAttribute.NOMAL, Gender.FEMALE), J(AgentAttribute.NOMAL, Gender.MALE),
    DETECTIVE(AgentAttribute.NOMAL, Gender.MALE),

    /* オリジナルエージェント */
    CHAINER(AgentAttribute.SECRET, Gender.MALE), PSYCHOPATH(AgentAttribute.NOMAL, Gender.MALE),
    GOLDHEAD(AgentAttribute.SECRET, Gender.MALE), NEUTRAL(AgentAttribute.SECRET, Gender.MALE),
    GAMEMASTER(AgentAttribute.NOMAL, Gender.NONE), DUELIST(AgentAttribute.SECRET, Gender.FEMALE),
    HANDSTANDER(AgentAttribute.SECRET, Gender.MALE), SMALLSPACE(AgentAttribute.SECRET, Gender.FEMALE),
    FILLER(AgentAttribute.NOMAL, Gender.MALE), MOMENTSLEEP(AgentAttribute.NOMAL, Gender.MALE),
    VITARITYRECORDER(AgentAttribute.NOMAL, Gender.MALE), CHAIRMAN(AgentAttribute.SECRET, Gender.MALE),
    AMNESIA(AgentAttribute.NOMAL, Gender.MALE), TIPSY(AgentAttribute.NOMAL, Gender.MALE),
    PEPPER(AgentAttribute.NOMAL, Gender.NONE), JUGGLER(AgentAttribute.PUBLIC, Gender.MALE),
    KUROSAWASENSEI(AgentAttribute.PUBLIC, Gender.MALE), LIFEGAMER(AgentAttribute.SECRET, Gender.MALE),
    SUNFLOWER(AgentAttribute.SECRET, Gender.MALE), FISHCAKE(AgentAttribute.SECRET, Gender.NONE);

    public final AgentAttribute agentAttribute;
    public final Gender gender;
    public final ArrayList<String> abilities;

    private AgentName(AgentAttribute agentAttribute, Gender gender, String...abilities){
        this.agentAttribute = agentAttribute;
        this.gender = gender;
        this.abilities = new ArrayList<>(Arrays.asList(abilities));
    }

}

enum Phase {
    START, FILL, STRATEGY, SEND, FINISH
}

enum ListMode{
    HANDS, POSSESSION
}
