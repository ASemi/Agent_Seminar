package com.asemi.ailab.agent_seminar;

/**
 * Created by wataru on 17/02/17.
 */

public class StrategyCard {
    Strategy strategy;
    Color color;
    SendMethod sendMethod;

    public void getColor(Color color){
        this.color = color;
    }

    public void getStrategy(Strategy strategy){
        this.strategy = strategy;
        switch(strategy) {
            case TRAP:
                this.sendMethod = SendMethod.RELEASE;
                break;
            case INTERCEPT:
            case COUNTERACT:
            case DELETE:
            case TRANSFER:
                this.sendMethod = SendMethod.CONFIDENTIAL;
                break;
            default:
                this.sendMethod = SendMethod.SECRECY;
                break;
        }
    }

    /*public StrategyCard(String name, Color color){
        String name = "";
        Color color = Color.RED;
    }*/
}

/*
class StrategyCard_Secrecy extends StrategyCard{
    public StrategyCard_Secrecy(){
        this.sendMethod = SendMethod.SECRECY;
    }
}
class StrategyCard_Confidential extends StrategyCard{
    public StrategyCard_Confidential(){
        this.sendMethod = SendMethod.CONFIDENTIAL;
    }
}
class StrategyCard_Release extends StrategyCard{
    public StrategyCard_Release(){
        this.sendMethod = SendMethod.RELEASE;
        this.name = "Missguided";
    }
}
*/