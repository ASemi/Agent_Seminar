package com.asemi.ailab.agent_seminar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * Created by wataru on 17/02/19.
 */

public class PhaseControl extends AsyncTask<String, Integer, String> implements MovementFunc{
    Observer observer;
    boolean sendflag;
    Context context;
    Phase phase;
    TextView phase_txt;


    private AsyncTaskCallback callback = null;

    public interface AsyncTaskCallback {
        String preExecute();
        void onExecuteStart(Observer observer);
        void onExecuteFill(Observer observer);
        void onExecuteSend(Observer observer, int rnd_num);
        void postExecute(Observer observer);
    }


    public PhaseControl(Context context, Observer observer, AsyncTaskCallback callback) {
        super();
        this.context = context;
        this.observer = observer;
        this.callback = callback;
    }

    /* 非同期処理を実行する前に行う処理 */
    @Override
    protected void onPreExecute() {
        this.phase = observer.phase;
        //phase_txt.setText(phase.toString());
        callback.preExecute();
    }


    /* 非同期処理の内部(実際に通信を行う部分) */
    @Override
    protected String doInBackground(String... params) {
        while(observer.playerList.get(observer.turn) != observer.player) {
            switch (phase) {
                case START:
                /*                                 *
                 * エージェントの能力確認（未実装）*
                 *                                 */
                    callback.onExecuteStart(observer);
                    phase = Phase.FILL;
                    break;
                case FILL:
                    Draw(observer.playerList.get(observer.turn), observer.playerList.get(observer.turn).draw_num, observer.deck);
                    callback.onExecuteFill(observer);
                    phase = Phase.STRATEGY;
                    break;
                case STRATEGY:
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    phase = Phase.SEND;
                    break;
                case SEND:
                    try {
                        Random rnd = new Random();
                        int rnd_num = rnd.nextInt(observer.playerList.get(observer.turn).hands.size());
                        callback.onExecuteSend(observer, rnd_num);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    phase = Phase.FINISH;
                    break;
                case FINISH:
                    observer.nextTurn(observer.otamo);
                    phase = Phase.START;
                    break;
                default:
                    break;
            }
            observer.phase = phase;
        }
        return "player's turn...";
    }


    /* 未実装　キャンセルを押し、doInBackgroundを抜けた直後の処理 */
    @Override
    protected void onCancelled() {
        Log.d("HttpAsyncConnection1", "onCancelled");
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        //callback.onExecute(progress[0]);
    }


    /* 通信終了時の処理 */
    @Override
    protected void onPostExecute(String result) {
        Log.d("HttpAsyncConnection1", "onPostExecute - " + result);
        callback.postExecute(observer);
    }

    /* 未実装　「戻る」ボタン等によるキャンセルの対応 */
    //@Override
    public void onCancel(DialogInterface dialog) {
        this.cancel(true);
    }


    @Override
    public void Draw(Player player, int num, AllDeck deck) {
        for (int i = 0; i < num; i++) {
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
        for (int i = 0; i < dumpCards.size(); i++) {
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
        for (int i = 0; i < strategyCards.size(); i++) {
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
}