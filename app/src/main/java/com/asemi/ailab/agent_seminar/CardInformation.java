package com.asemi.ailab.agent_seminar;

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
    LOCKON, DISTRIBUTE, INTERCEPT, DECODE, COUNTERACT, TRAP/*誤導*/, PROVE, DELETE, TRANSFER

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
    SPEAKER(AgentAttribute.SECRET, Gender.MALE), TANK(AgentAttribute.SECRET, Gender.MALE),
    OBLIQUE_SHADOW(AgentAttribute.SECRET, Gender.FEMALE), TITANIUM(AgentAttribute.SECRET, Gender.MALE),
    LARKLADY(AgentAttribute.SECRET, Gender.FEMALE), SWANMAIDEN(AgentAttribute.SECRET, Gender.FEMALE),
    HUNTLESS(AgentAttribute.SECRET, Gender.FEMALE), BLACKHAND(AgentAttribute.SECRET, Gender.MALE),
    NIGHTMARE(AgentAttribute.SECRET, Gender.FEMALE), BARONBRUMEL(AgentAttribute.SECRET, Gender.MALE),
    MARKJUNIOR(AgentAttribute.NOMAL, Gender.MALE), STATICELECTRICITY(AgentAttribute.NOMAL, Gender.FEMALE),
    VIPER(AgentAttribute.NOMAL, Gender.MALE), ANGEL(AgentAttribute.NOMAL, Gender.FEMALE),
    SAVAGEASSASSIN(AgentAttribute.NOMAL, Gender.MALE), DOUBLEKNIGHT(AgentAttribute.NOMAL, Gender.MALE),
    KWONGKIKU(AgentAttribute.NOMAL, Gender.MALE), DARKFLOW(AgentAttribute.NOMAL, Gender.MALE),
    DIAMONDMAN(AgentAttribute.NOMAL, Gender.MALE), PERFUME(AgentAttribute.NOMAL, Gender.FEMALE),
    TOUGHGUN(AgentAttribute.NOMAL, Gender.MALE), REDBLADE(AgentAttribute.NOMAL, Gender.MALE),
    ALIAS(AgentAttribute.NOMAL, Gender.FEMALE), BACKFIRE(AgentAttribute.NOMAL, Gender.MALE),
    TRINITY(AgentAttribute.NOMAL, Gender.FEMALE), J(AgentAttribute.NOMAL, Gender.MALE),
    DETECTIVE(AgentAttribute.NOMAL, Gender.MALE),

    /* オリジナルエージェント */
    CHAINER(AgentAttribute.SECRET, Gender.MALE), PSYCHOPATH(AgentAttribute.NOMAL, Gender.MALE),
    GOLDHEAD(AgentAttribute.SECRET, Gender.MALE), NEUTRAL(AgentAttribute.SECRET, Gender.MALE),
    GAMEMASTER(AgentAttribute.NOMAL, Gender.NONE), DUELIST(AgentAttribute.NOMAL, Gender.FEMALE),
    HANDSTANDER(AgentAttribute.SECRET, Gender.MALE), SMALLSPACE(AgentAttribute.NOMAL, Gender.FEMALE),
    FILLER(AgentAttribute.NOMAL, Gender.MALE), MOMENT_SLEEP(AgentAttribute.NOMAL, Gender.MALE),
    BITARITY_RECORDER(AgentAttribute.NOMAL, Gender.MALE), CHAIRMAN(AgentAttribute.SECRET, Gender.MALE),
    AMNESIA(AgentAttribute.NOMAL, Gender.MALE), TIPSY(AgentAttribute.NOMAL, Gender.MALE),
    PEPPER(AgentAttribute.NOMAL, Gender.NONE), JUGGLER(AgentAttribute.PUBLIC, Gender.MALE),
    KUROSAWA_SENSEI(AgentAttribute.PUBLIC, Gender.MALE), LIFEGAMER(AgentAttribute.SECRET, Gender.MALE),
    SUNFLOWER(AgentAttribute.SECRET, Gender.MALE), FISHCAKE(AgentAttribute.NOMAL, Gender.NONE);

    public final AgentAttribute agentAttribute;
    public final Gender gender;

    private AgentName(AgentAttribute agentAttribute, Gender gender){
        this.agentAttribute = agentAttribute;
        this.gender = gender;
    }

}

enum Phase {
    START, FILL, STRATEGY, SEND, FINISH
}

enum ListMode{
    HANDS, POSSESSION
}
