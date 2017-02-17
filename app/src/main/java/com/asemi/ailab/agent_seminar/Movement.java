package com.asemi.ailab.agent_seminar;


import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Wataru on 2017/02/17.
 */

public class Movement implements MovementFunc{

    @Override
    public ArrayList<StrategyCard> Draw(Player player, int num){
        return null;
    }

    @Override
    public void Possession(StrategyCard strategyCard, Where where) {

    }

    @Override
    public void Dump(StrategyCard strategyCard, int num) {

    }

    @Override
    public void LockOn(Player player) {

    }

    @Override
    public void Lost(Player player) {

    }

    @Override
    public void Decode(StrategyCard strategyCard) {

    }

    @Override
    public void Shuffle() {

    }

    @Override
    public void PutOnTheDeck(StrategyCard strategyCard) {

    }

    @Override
    public void Delete(StrategyCard strategyCard) {

    }

    @Override
    public ArrayList<StrategyCard> Steal(Player player, int num) {
        int index;
        ArrayList<StrategyCard> steal = new ArrayList<StrategyCard>();
        return null;
    }

    @Override
    public ArrayList<StrategyCard> Choose(Where where, int num) {
        return null;
    }

}

public interface MovementFunc {
    // 山札からドロー
    public ArrayList<StrategyCard> Draw(Player player, int num);
    // 諜略カードを保有
    public void Possession(ArrayList<StrategyCard> strategyCards);
    // 手札からカードを捨てる
    public void Dump(ArrayList<StrategyCard> strategyCards);
    // プレイヤーをロックオン状態にする
    public void LockOn(Player player);
    // プレイヤーをロスト状態にする
    public void Lost(Player player);
    // 裏側状態の送信メッセージを解読する
    public void Decode(Player player, ArrayList<StrategyCard> strategyCard);
    // 山札をシャッフルする
    public void Shuffle();
    // 手札の諜略カードを山札に戻す
    public void PutOnTheDeck(ArrayList<StrategyCard> strategyCards);
    // 保有しているカードを削除する
    public void Delete(ArrayList<StrategyCard> strategyCard);
    // 特定のプレイヤーからカードを奪う
    public ArrayList<StrategyCard> Steal(Player player, Player enemy, ArrayList<StrategyCard> strategyCards;
    // 自分もしくは相手の手札カードを選ぶ
    public ArrayList<StrategyCard> Choose(Where where, int num);
    // 保有したカードを奪う
    public ArrayList<StrategyCard> PickUp();

}
