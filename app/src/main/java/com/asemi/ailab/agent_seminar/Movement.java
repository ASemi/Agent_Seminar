package com.asemi.ailab.agent_seminar;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Wataru on 2017/02/17.
 */

public class Movement implements MovementFunc {
    Observer observer;
    AllDeck allDeck;
    Player player;

    public Movement(){

    }

    public Movement(Agent agent){

    }
    public Movement(StrategyCard strategyCard){

    }

    @Override
    public void Draw(Player player, int num, AllDeck deck) {
        for(int i=0; i<num; i++) {
            player.hands.add(deck.strategyDeck.getFirst());
            deck.strategyDeck.removeFirst();
        }
    }

    @Override
    public void Possession(Player possessPlayer, ArrayList<StrategyCard> possessCards) {
        for (int i = 0; i < possessCards.size(); i++) {
            possessPlayer.possession.add(possessCards.get(i));
        }
    }

    @Override
    public void Dump(Player dumpPlayer, ArrayList<StrategyCard> dumpCards) {
        for(int i=0; i<dumpCards.size(); i++){
            dumpPlayer.hands.remove(dumpCards);
        }
    }

    @Override
    public void LockOn(Player player) {
        player.lockon = Lockon.LOCKON;
    }

    @Override
    public void Lost(Player player) {
        player.lockon = Lockon.LOST;
    }

    @Override
    public void Decode(Player player, ArrayList<StrategyCard> turnedCard) {

    }

    @Override
    public void Shuffle(AllDeck deck) {
        Collections.shuffle(deck.strategyDeck);
    }

    @Override
    public void PutOnTheDeck(ArrayList<StrategyCard> strategyCards, AllDeck deck) {
        for(int i=0;i<strategyCards.size();i++){
            deck.strategyDeck.addFirst(strategyCards.get(i));
        }
    }

    @Override
    public void Delete(Player deletePlayer, ArrayList<StrategyCard> deletedCards) {
        deletePlayer.possession.remove(deletedCards);
    }

    @Override
    public void Steal(Player player, Player enemy, ArrayList<StrategyCard> stealedCards) {
        enemy.hands.remove(stealedCards);
        player.hands.addAll(stealedCards);
    }

    public void imputation(){

    }
}

interface MovementFunc {
    // 山札からドロー
    public void Draw(Player player, int num, AllDeck deck);
    // 諜略カードを保有
    public void Possession(Player possessPlayer, ArrayList<StrategyCard> possessCards);
    // 手札からカードを捨てる
    public void Dump(Player dumpPlayer, ArrayList<StrategyCard> dumpCards);
    // プレイヤーをロックオン状態にする
    public void LockOn(Player player);
    // プレイヤーをロスト状態にする
    public void Lost(Player player);
    // 裏側状態の送信メッセージを解読する
    public void Decode(Player player, ArrayList<StrategyCard> strategyCard);
    // 山札をシャッフルする
    public void Shuffle(AllDeck deck);
    // 手札の諜略カードを山札に戻す
    public void PutOnTheDeck(ArrayList<StrategyCard> strategyCards, AllDeck deck);
    // 保有しているカードを削除する
    public void Delete(Player deletePlayer, ArrayList<StrategyCard> deletedCards);
    // 特定のプレイヤーからカードを奪う
    public void Steal(Player player, Player enemy, ArrayList<StrategyCard> strategyCards);
    // 自分もしくは相手の手札カードを選ぶ
    //public void Choose(ArrayList<StrategyCard> strategyCards);
    // 保有したカードを奪う
    //public void PickUp();

}
