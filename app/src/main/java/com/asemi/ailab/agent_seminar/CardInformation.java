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

enum Grade{
    Y15, Y16, Y17, PROF ,NONE
}

enum Rarity{
    NORMAL, RARE, SUPER, ULTRA
}

enum AgentName {
    /* 既存エージェント */
    SPEAKER(AgentAttribute.SECRET, Gender.MALE, Grade.NONE, Rarity.NORMAL), TANK(AgentAttribute.SECRET, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    OBLIQUESHADOW(AgentAttribute.SECRET, Gender.FEMALE, Grade.NONE, Rarity.NORMAL), TITANIUM(AgentAttribute.SECRET, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    LARKLADY(AgentAttribute.SECRET, Gender.FEMALE, Grade.NONE, Rarity.NORMAL), SWANMAIDEN(AgentAttribute.SECRET, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    HUNTRESS(AgentAttribute.SECRET, Gender.FEMALE, Grade.NONE, Rarity.NORMAL), BLACKHAND(AgentAttribute.SECRET, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    NIGHTMARE(AgentAttribute.SECRET, Gender.FEMALE, Grade.NONE, Rarity.NORMAL), BARONBRUMAIRE(AgentAttribute.SECRET, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    MARKJUNIOR(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL), STATICELECTRICITY(AgentAttribute.NOMAL, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    VIPER(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL), ANGEL(AgentAttribute.NOMAL, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    SAVAGEASSASSIN(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL), DOUBLEKNIGHT(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    KWONKIKU(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL), DARKFLOW(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    DIAMONDMAN(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL), PERFUME(AgentAttribute.NOMAL, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    TOUGHGUN(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL), REDBLADE(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    ALIAS(AgentAttribute.NOMAL, Gender.FEMALE, Grade.NONE, Rarity.NORMAL), BACKFIRE(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    TRINITY(AgentAttribute.NOMAL, Gender.FEMALE, Grade.NONE, Rarity.NORMAL), J(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    DETECTIVE(AgentAttribute.NOMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),

    /* オリジナルエージェント */
    CHAINER(AgentAttribute.SECRET, Gender.MALE, Grade.Y17, Rarity.RARE), PSYCHOPATH(AgentAttribute.NOMAL, Gender.MALE, Grade.Y17, Rarity.RARE),
    GOLDHEAD(AgentAttribute.SECRET, Gender.MALE, Grade.Y16, Rarity.RARE), NEUTRAL(AgentAttribute.SECRET, Gender.MALE, Grade.Y17, Rarity.SUPER),
    GAMEMASTER(AgentAttribute.NOMAL, Gender.NONE, Grade.Y17, Rarity.RARE), DUELIST(AgentAttribute.SECRET, Gender.FEMALE, Grade.Y17, Rarity.SUPER),
    HANDSTANDER(AgentAttribute.SECRET, Gender.MALE, Grade.Y17, Rarity.RARE), SMALLSPACE(AgentAttribute.SECRET, Gender.FEMALE, Grade.Y17, Rarity.SUPER),
    FILLER(AgentAttribute.NOMAL, Gender.MALE, Grade.Y17, Rarity.RARE), MOMENTSLEEP(AgentAttribute.NOMAL, Gender.MALE, Grade.Y17, Rarity.SUPER),
    VITARITYRECORDER(AgentAttribute.NOMAL, Gender.MALE, Grade.Y15, Rarity.SUPER), CHAIRMAN(AgentAttribute.SECRET, Gender.MALE, Grade.Y15, Rarity.SUPER),
    AMNESIA(AgentAttribute.NOMAL, Gender.MALE, Grade.Y15, Rarity.RARE), TIPSY(AgentAttribute.NOMAL, Gender.MALE, Grade.Y15, Rarity.RARE),
    PEPPER(AgentAttribute.NOMAL, Gender.NONE, Grade.NONE, Rarity.SUPER), JUGGLER(AgentAttribute.PUBLIC, Gender.MALE, Grade.Y16, Rarity.RARE),
    KUROSAWASENSEI(AgentAttribute.PUBLIC, Gender.MALE, Grade.PROF, Rarity.ULTRA), LIFEGAMER(AgentAttribute.SECRET, Gender.MALE, Grade.Y15, Rarity.SUPER),
    SUNFLOWER(AgentAttribute.SECRET, Gender.MALE, Grade.Y16, Rarity.SUPER), FISHCAKE(AgentAttribute.SECRET, Gender.NONE, Grade.Y16, Rarity.SUPER);

    public final AgentAttribute agentAttribute;
    public final Gender gender;
    public final Grade grade;
    public final Rarity rarity;
    //public final ArrayList<String> abilities;

    private AgentName(AgentAttribute agentAttribute, Gender gender, Grade grade, Rarity rarity){
        this.agentAttribute = agentAttribute;
        this.gender = gender;
        this.grade = grade;
        this.rarity = rarity;
        //this.abilities = new ArrayList<>(Arrays.asList(abilities));
    }

}

enum Phase {
    START, FILL, STRATEGY, SEND, FINISH
}

enum ListMode{
    HANDS, POSSESSION
}
