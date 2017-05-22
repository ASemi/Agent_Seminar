package com.asemi.ailab.agent_seminar;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Wataru on 2017/02/17.
 */

/*
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



    public void imputation(){

    }
}
*/

interface MovementFunc {
    // 山札からドロー
    void Draw(Player player, int num, AllDeck deck);
    // 諜略カードを保有
    void Possession(Player possessPlayer, ArrayList<StrategyCard> possessCards);
    // 手札からカードを捨てる
    void Dump(Player dumpPlayer, ArrayList<StrategyCard> dumpCards);
    // プレイヤーをロックオン状態にする
    void LockOn(Player player);
    // プレイヤーをロスト状態にする
    void Lost(Player player);
    // 裏側状態の送信メッセージを解読する
    void Decode(Player player, ArrayList<StrategyCard> strategyCard);
    // 山札をシャッフルする
    void Shuffle(AllDeck deck);
    // 手札の諜略カードを山札に戻す
    void PutOnTheDeck(ArrayList<StrategyCard> strategyCards, AllDeck deck);
    // 保有しているカードを削除する
    void Delete(Player deletePlayer, ArrayList<StrategyCard> deletedCards);
    // 特定のプレイヤーからカードを奪う
    void Steal(Player player, Player enemy, ArrayList<StrategyCard> strategyCards);

    // 自分もしくは相手の手札カードを選ぶ
    //public void Choose(ArrayList<StrategyCard> strategyCards);
    // 保有したカードを奪う
    //public void PickUp();

}
