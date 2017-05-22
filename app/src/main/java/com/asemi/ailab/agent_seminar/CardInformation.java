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
    LOCKON, DISTRIBUTE, INTERCEPT, DECODE, COUNTERACT, TRAP/*誤導*/, PROVEDRAW, PROVEDUMP, DELETE, TRANSFER

}
enum Lockon {
    LOCKON, LOST, NORMAL
}
enum AgentAttribute {
    SECRET, PUBLIC, NORMAL
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
    SPEAKER(AgentAttribute.SECRET, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    TANK(AgentAttribute.SECRET, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    OBLIQUESHADOW(AgentAttribute.SECRET, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    TITANIUM(AgentAttribute.SECRET, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    LARKLADY(AgentAttribute.SECRET, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    SWANMAIDEN(AgentAttribute.SECRET, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    HUNTRESS(AgentAttribute.SECRET, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    BLACKHAND(AgentAttribute.SECRET, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    NIGHTMARE(AgentAttribute.SECRET, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    BARONBRUMAIRE(AgentAttribute.SECRET, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    MARKJUNIOR(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    STATICELECTRICITY(AgentAttribute.NORMAL, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    VIPER(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    ANGEL(AgentAttribute.NORMAL, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    SAVAGEASSASSIN(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    DOUBLEKNIGHT(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    KWONKIKU(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    DARKFLOW(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    DIAMONDMAN(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    PERFUME(AgentAttribute.NORMAL, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    TOUGHGUN(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    REDBLADE(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    ALIAS(AgentAttribute.NORMAL, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    BACKFIRE(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    TRINITY(AgentAttribute.NORMAL, Gender.FEMALE, Grade.NONE, Rarity.NORMAL),
    J(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),
    DETECTIVE(AgentAttribute.NORMAL, Gender.MALE, Grade.NONE, Rarity.NORMAL),

    /* オリジナルエージェント */
    CHAINER(AgentAttribute.SECRET, Gender.MALE, Grade.Y17, Rarity.RARE),
    PSYCHOPATH(AgentAttribute.NORMAL, Gender.MALE, Grade.Y17, Rarity.RARE),
    GOLDHEAD(AgentAttribute.SECRET, Gender.MALE, Grade.Y16, Rarity.RARE),
    NEUTRAL(AgentAttribute.SECRET, Gender.MALE, Grade.Y17, Rarity.SUPER),
    GAMEMASTER(AgentAttribute.NORMAL, Gender.NONE, Grade.Y17, Rarity.RARE),
    DUELIST(AgentAttribute.SECRET, Gender.FEMALE, Grade.Y17, Rarity.SUPER),
    HANDSTANDER(AgentAttribute.SECRET, Gender.MALE, Grade.Y17, Rarity.RARE),
    SMALLSPACE(AgentAttribute.SECRET, Gender.FEMALE, Grade.Y17, Rarity.SUPER),
    FILLER(AgentAttribute.NORMAL, Gender.MALE, Grade.Y17, Rarity.RARE),
    MOMENTSLEEP(AgentAttribute.NORMAL, Gender.MALE, Grade.Y17, Rarity.SUPER),
    VITARITYRECORDER(AgentAttribute.NORMAL, Gender.MALE, Grade.Y15, Rarity.SUPER),
    CHAIRMAN(AgentAttribute.SECRET, Gender.MALE, Grade.Y15, Rarity.SUPER),
    AMNESIA(AgentAttribute.NORMAL, Gender.MALE, Grade.Y15, Rarity.RARE),
    TIPSY(AgentAttribute.NORMAL, Gender.MALE, Grade.Y15, Rarity.RARE),
    PEPPER(AgentAttribute.NORMAL, Gender.NONE, Grade.NONE, Rarity.SUPER),
    JUGGLER(AgentAttribute.PUBLIC, Gender.MALE, Grade.Y16, Rarity.RARE),
    KUROSAWASENSEI(AgentAttribute.PUBLIC, Gender.MALE, Grade.PROF, Rarity.ULTRA),
    LIFEGAMER(AgentAttribute.SECRET, Gender.MALE, Grade.Y15, Rarity.SUPER),
    SUNFLOWER(AgentAttribute.SECRET, Gender.MALE, Grade.Y16, Rarity.SUPER),
    FISHCAKE(AgentAttribute.SECRET, Gender.NONE, Grade.Y16, Rarity.SUPER),
    HOST(AgentAttribute.NORMAL, Gender.MALE, Grade.Y15, Rarity.RARE),
    MORPHEUS(AgentAttribute.NORMAL, Gender.MALE, Grade.Y15, Rarity.SUPER),
    TRUMPETER(AgentAttribute.SECRET, Gender.MALE, Grade.Y16, Rarity.RARE),
    KEYBOARDER(AgentAttribute.SECRET, Gender.FEMALE, Grade.Y16, Rarity.RARE),
    JULIUS(AgentAttribute.SECRET, Gender.MALE, Grade.PROF, Rarity.ULTRA),
    FONTJUNKIE(AgentAttribute.NORMAL, Gender.MALE, Grade.Y15, Rarity.RARE),
    SPRINCAR(AgentAttribute.PUBLIC, Gender.MALE, Grade.PROF, Rarity.ULTRA),
    BLACKPEPPER(AgentAttribute.NORMAL, Gender.NONE, Grade.NONE, Rarity.RARE),
    SHELLKEAPER(AgentAttribute.NORMAL, Gender.FEMALE, Grade.Y15, Rarity.RARE),
    IPHONE(AgentAttribute.SECRET, Gender.MALE, Grade.Y17, Rarity.ULTRA),
    SUNSHINE(AgentAttribute.NORMAL, Gender.MALE, Grade.Y17, Rarity.ULTRA),
    PANDAPEPPER(AgentAttribute.NORMAL, Gender.NONE, Grade.NONE, Rarity.SUPER),
    TAKAYATSU(AgentAttribute.NORMAL, Gender.MALE, Grade.Y17, Rarity.RARE),
    RAMEN(AgentAttribute.NORMAL, Gender.NONE, Grade.NONE, Rarity.ULTRA);

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
