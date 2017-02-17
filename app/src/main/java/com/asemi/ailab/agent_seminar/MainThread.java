package com.asemi.ailab.agent_seminar;

/**
 * Created by wataru on 17/02/17.
 */

public class MainThread extends Thread{

    public static void main(String[] args){
        Observer observer = new Observer();
        final int MAX_PLAYER = 9;
        Player[] players = new Player[MAX_PLAYER];
        AllDeck allDeck = new AllDeck();
        observer.setInit(players[0], allDeck);
    }

}
