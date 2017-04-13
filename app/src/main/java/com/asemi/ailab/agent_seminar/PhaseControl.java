package com.asemi.ailab.agent_seminar;

import android.os.AsyncTask;

/**
 * Created by wataru on 17/02/19.
 */

public class PhaseControl {
    Observer observer;
    boolean sendflag;

    public PhaseControl(Observer observer){
        this.observer = observer;
    }




    /* フェイズ管理     *
     *                  */
/*
    public void startPhase(Observer observer){
        observer.confirmAbility();
        observer.phase = Phase.FILL;
        fillPhase(observer);
    }

    public void fillPhase(Observer observer){
        observer.confirmAbility();
        movement = new Movement();
        movement.Draw(observer.playerList.get(observer.turn), observer.playerList.get(observer.turn).draw_num, observer.deck);
        observer.phase = Phase.STRATEGY;
        strategyPhase(observer);
    }

    public void strategyPhase(Observer observer){
        observer.confirmAbility();
        if(observer.playerList.get(observer.turn).playable){

        }else{

        }
        observer.phase = Phase.SEND;
        sendPhase(observer);
    }

    public void sendPhase(Observer observer){
        observer.confirmAbility();
        if(observer.messageNum > 1){
            //observer.sendedCard =
        }else{

        }
        observer.phase = Phase.FINISH;
        finishPhase(observer);
    }

    public void finishPhase(Observer observer){
        observer.confirmAbility();
        observer.nextTurn(observer.otamo);
        startPhase(observer);
    }
*/
}

interface PhaseController{
    public void startPhase(Observer observer);
    public void fillPhase(Observer observer);
    public void strategyPhase(Observer observer);
    public void sendPhase(Observer observer);
    public void finishPhase(Observer observer);
}