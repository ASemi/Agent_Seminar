package com.asemi.ailab.agent_seminar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by wataru on 17/02/17.
 */

public class Observer {
    int turn;
    Phase phase;
    ArrayList<Player> playerList;
    Player player;

    AllDeck deck;

    StrategyCard sendedCard;
    // 黒沢先生を実装するならばリストにする必要あり
    // ArrayList<StrategyCard> sendingCards;

    boolean sendedCardState = false; // 表：true   裏：false

    StrategyCard workedCard;         // 現在、効果を発動しているカード
    boolean counteract = false;      // 阻止発動時：true   それ以外、または阻止＋阻止：false
    boolean otamo = false;

    public Observer(int primary_num, AllDeck deck, Player player, ArrayList<Player> playerCPU){
        this.turn = primary_num;
        this.deck = deck;
        this.phase = Phase.START;
        this.player = player;

        playerCPU.add(player);
        Collections.shuffle(playerCPU);
        this.playerList = playerCPU;

    }

    /* 次の人にターンを渡す */
    public void nextTurn(boolean otamo){
        if(!otamo){
            if(turn >= playerList.size()-1){
                turn = 0;
            }else {
                turn++;
            }
        }else{
            if(turn <= 0){
                turn = playerList.size()-1;
            }else {
                turn--;
            }
        }
    }

    public void confirmAbility(){

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
