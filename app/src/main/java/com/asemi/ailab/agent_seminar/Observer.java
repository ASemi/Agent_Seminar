package com.asemi.ailab.agent_seminar;

import java.util.ArrayList;

/**
 * Created by wataru on 17/02/17.
 */

public class Observer {
    Player turn;
    Phase phase;

    AllDeck deck;

    StrategyCard sendedCard;
    // 黒沢先生を実装するならばリストにする必要あり
    // ArrayList<StrategyCard> sendingCards;

    boolean sendedCardState = false; // 表：true   裏：false

    StrategyCard workedCard;         // 現在、効果を発動しているカード
    boolean counteract = false;      // 阻止発動時：true   それ以外、または阻止＋阻止：false


    public Observer(Player firstPlayer, AllDeck deck){
        this.deck = deck;
        this.turn = firstPlayer;
        this.phase = Phase.START;
    }

    /* 次の人にターンを渡す */
    public void nextTurn(){

    }

    /* 送信されたメッセージが公開であれば状態を表に、それ以外であれば裏にする */
    public void getCardState(StrategyCard sendedCard){
        if(sendedCard.sendMethod==SendMethod.RELEASE){
            this.sendedCardState = true;
        }else{
            this.sendedCardState = false;
        }
    }



}
