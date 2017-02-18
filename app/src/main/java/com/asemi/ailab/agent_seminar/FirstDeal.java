package com.asemi.ailab.agent_seminar;

import java.util.ArrayList;

/**
 * Created by Wataru on 2017/02/18.
 */

public class FirstDeal {
    ArrayList<StrategyCard> first_hands = new ArrayList<>();

    public FirstDeal(AllDeck deck){
        for(int i=0; i<3; i++) {
            this.first_hands.add(deck.alldeck.getFirst());
            deck.alldeck.removeFirst();
        }
    }

}
