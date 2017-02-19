package com.asemi.ailab.agent_seminar;

/**
 * Created by wataru on 17/02/19.
 */

public class PhaseControl {
    Observer observer;
    Movement movement = new Movement();
    PhaseController phaseController;

    public PhaseControl(Observer observer, PhaseController phaseController){
        this.observer = observer;
        this.phaseController = phaseController;
    }

    public interface PhaseController{
        public void startPhase(Observer observer);
        public void fillPhase(Observer observer);
        public void strategyPhase(Observer observer);
        public void sendPhase(Observer observer);
        public void finishPhase(Observer observer);
    }

    /*
    public void startPhase(Observer observer){
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
        observer.phase = Phase.FINISH;
    }

    public void finishPhase(Observer observer){
        observer.nextTurn(observer.otamo);
    }
    */
}
