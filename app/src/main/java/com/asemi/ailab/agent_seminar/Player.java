package com.asemi.ailab.agent_seminar;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;

/**
 * Created by wataru on 17/02/17.
 */

public class Player {
    boolean playable;
    Side side;
    Agent agent;
    ArrayList<StrategyCard> possession = new ArrayList<>();
    ArrayList<StrategyCard> hands;
    Lockon lockon = Lockon.NORMAL;
    int draw_num = 2;
    boolean death = false;
    boolean win = false;


    public Player(boolean playable, Side side, Agent agent, ArrayList<StrategyCard> hands) {
        this.playable = playable;
        this.side = side;
        this.agent = agent;
        this.hands = new ArrayList<StrategyCard>(hands);
    }

    public void checkLose(){
        /*switch (){

        }*/
    }

    public void checkWin(){
        switch (this.side){
            case KDR:
                break;
            case FRS:
                break;
            default:
                break;
        }
    }

    public void changeAgent(Agent ownAgent, Agent oppAgent){
        Agent tmp;
        tmp = ownAgent;
        ownAgent = oppAgent;
        oppAgent = tmp;
    }

    public void changeSide(Side ownSide, Side oppSide){
        Side tmp;
        tmp = ownSide;
        ownSide = oppSide;
        oppSide = tmp;
    }

}
