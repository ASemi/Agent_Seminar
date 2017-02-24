package com.asemi.ailab.agent_seminar;

/**
 * Created by wataru on 17/02/19.
 */

public class PhaseControl {
    Observer observer;
    Movement movement = new Movement();
    boolean sendflag;

    public PhaseControl(Observer observer){
        this.observer = observer;
    }

    public void startPhase(Observer observer){
        observer.confirmAbility();
        observer.phase = Phase.FILL;
    }

    public void fillPhase(Observer observer){
        observer.confirmAbility();
        movement.Draw(observer.playerList.get(observer.turn), observer.playerList.get(observer.turn).draw_num, observer.deck);
        observer.phase = Phase.STRATEGY;
    }

    public void strategyPhase(Observer observer){
        if(observer.playerList.get(observer.turn).playable){

        }else{

        }
        observer.phase = Phase.SEND;
    }

    public void sendPhase(Observer observer){
        observer.confirmAbility();
        if(observer.messageNum > 1){

        }else{

        }
        observer.phase = Phase.FINISH;
        sendflag = false;
    }

    public void finishPhase(Observer observer){
        observer.nextTurn(observer.otamo);
    }

}
