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

}
enum Phase {
    START, FILL, STRATEGY, SEND, FINISH
}