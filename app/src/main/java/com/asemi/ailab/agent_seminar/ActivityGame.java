package com.asemi.ailab.agent_seminar;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.LogRecord;

public class ActivityGame extends FragmentActivity implements PlayerFlagment.FlagmentListener, MovementFunc{

    private Button button1, button2;
    private TextView txt1, txt2, txtSide;
    private TextView[] txtHands = new TextView[3];

    private ImageButton imagebutton1;

    final int MAX_PLAYER = 9;
    AllDeck allDeck;
    Agent[] dealedAgents;
    Player player;
    ArrayList<Player> playerCPUs;
    PhaseControl phaseControl;
    Observer observer;

    Handler mHandler = new Handler();

    RecyclerView.Adapter adapter;
    TextView phasetxt;
    Button btn_next;


    public Agent[] showAgent(AllDeck allDeck){
        Agent[] agents =new Agent[2];

        for(int i=0; i<2; i++){
            agents[i] = allDeck.agentDeck.getFirst();
            allDeck.agentDeck.removeFirst();
        }
        return agents;
    }

    public ArrayList<Player> firstDeal(AllDeck allDeck, Agent choosedAgent, int max_player){
        Player player;
        ArrayList<Player> cPUs;
        player = firstDealforMe(allDeck, choosedAgent);
        cPUs = firstDealforCPU(allDeck, max_player-1);

        return cPUs;
    }

    public ArrayList<Player> firstDealforCPU(AllDeck allDeck, int numCPU){
        ArrayList<Player> cPUs = new ArrayList<>();
        ArrayList<StrategyCard> hands;
        for(int i=0; i<numCPU; i++){
            hands = new ArrayList<>();
            for(int j=0; j<3; j++) {
                hands.add(allDeck.strategyDeck.getFirst());
                allDeck.strategyDeck.removeFirst();
            }
            cPUs.add(new Player(false, allDeck.sideDeck.getFirst(), allDeck.agentDeck.getFirst(), hands));
            allDeck.sideDeck.removeFirst();
            allDeck.agentDeck.removeFirst();
        }
        return cPUs;
    }

    public Player firstDealforMe(AllDeck allDeck, Agent choosedAgent){
        Side side;
        ArrayList<StrategyCard> hands = new ArrayList<>();

        side = allDeck.sideDeck.getFirst();
        allDeck.sideDeck.removeFirst();

        for(int i=0; i<3; i++) {
            hands.add(allDeck.strategyDeck.getFirst());
            allDeck.strategyDeck.removeFirst();
        }

        return new Player(true, side, choosedAgent, hands);

    }

    /*  */
    @Override
    public void saveParams(TextView phasetxt, RecyclerView.Adapter adapter, Button btn_next){
        this.phasetxt = phasetxt;
        this.adapter = adapter;
        this.btn_next = btn_next;
    }

    public void savePhasetxt(TextView phasetxt){
        this.phasetxt = phasetxt;
    }

    @Override
    public TextView getPhasetxt(){
        return phasetxt;
    }

    @Override
    public RecyclerView.Adapter getAdapter(){
        return adapter;
    }

    @Override
    public Button getBtn_next(){
        return btn_next;
    }

    /* FragmentListenerの実装 */
    @Override
    public AllDeck getAllDeck(){
        return allDeck;
    }

    @Override
    public Agent[] dealTwoAgents(AllDeck allDeck){
        return showAgent(allDeck);
    }

    @Override
    public Observer setFirstDeal(AllDeck allDeck, Agent selectedAgent){
        player = firstDealforMe(allDeck, selectedAgent);
        playerCPUs = firstDealforCPU(allDeck, MAX_PLAYER-1);
        return new Observer(8, allDeck, player, playerCPUs);
    }

    @Override
    public int getAgentViewID(Agent agent){
        int id;
        id = getResources().getIdentifier(agent.agentName.toString().toLowerCase(), "drawable", getPackageName());
        return id;
    }

    @Override
    public int getStrategyViewID(StrategyCard strategyCard){
        int id;
        String strategy = strategyCard.strategy.toString().toLowerCase();
        String color = strategyCard.color.toString().toLowerCase();
        id = getResources().getIdentifier(color+strategy, "drawable", getPackageName());
        return id;
    }

    @Override
    public int getSideViewID(Side side){
        int id;
        id = getResources().getIdentifier(side.toString().toLowerCase(), "drawable", getPackageName());
        return id;
    }

    @Override
    public int getCPUImageButtonID(int num){
        int id;
        System.out.println("btn_cpu"+String.valueOf(num)+"agent");
        id = getResources().getIdentifier("btn_cpu"+String.valueOf(num)+"agent", "id", getPackageName());
        return id;
    }
    @Override
    public void setPhasetxt(Phase phase, TextView phasetxt){
        phasetxt.setText(phase.toString());
    }


    @Override
    public void startPhase(Observer observer, TextView phasetxt, RecyclerView.Adapter adapter, Button btn_next){
        //observer.confirmAbility();
        setPhasetxt(observer.phase, phasetxt);
        observer.phase = Phase.FILL;
        saveParams(phasetxt, adapter, btn_next);
        fillPhase(observer, phasetxt, adapter, btn_next);
    }

    @Override
    public void fillPhase(Observer observer, TextView phasetxt, RecyclerView.Adapter adapter, Button btn_next){
        //observer.confirmAbility();
        setPhasetxt(observer.phase, phasetxt);
        Draw(observer.playerList.get(observer.turn), observer.playerList.get(observer.turn).draw_num, observer.deck);
        addItem(adapter);
        observer.phase = Phase.STRATEGY;
        btn_next.setEnabled(true);
        savePhasetxt(phasetxt);
        strategyPhase(observer, phasetxt, adapter, btn_next);
    }

    @Override
    public void strategyPhase(Observer observer, TextView phasetxt, RecyclerView.Adapter adapter,Button btn_next){
        setPhasetxt(observer.phase, phasetxt);
        if(observer.turn != 8){
            /*try {
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }*/
            sendPhase(observer, phasetxt, adapter, btn_next);
        }
    }
    @Override
    public void sendPhase(Observer observer, TextView phasetxt, RecyclerView.Adapter adapter,Button btn_next){
        Random rnd = new Random();
        int rnd_num = rnd.nextInt(observer.playerList.get(observer.turn).hands.size());
        setPhasetxt(observer.phase, phasetxt);
        if(observer.player != observer.playerList.get(observer.turn)){
            //try {
                //Thread.sleep(1000);
                selectPossess(observer.playerList.get(observer.turn+1), observer.playerList.get(observer.turn).hands.get(rnd_num), observer);
                observer.playerList.get(observer.turn).hands.remove(rnd_num);
                finishPhase(observer, phasetxt, adapter, btn_next);
            //} catch(InterruptedException e){
            //    e.printStackTrace();
            //}
        }
    }
    @Override
    public void finishPhase(Observer observer, TextView phasetxt, RecyclerView.Adapter adapter,Button btn_next){
        final Observer ob = observer;
        final TextView pt = phasetxt;
        final RecyclerView.Adapter ad = adapter;
        final Button bn = btn_next;

        setPhasetxt(observer.phase, phasetxt);
        observer.nextTurn(observer.otamo);
        observer.phase = Phase.START;
        PhaseControl pc = new PhaseControl(this, observer, new PhaseControl.AsyncTaskCallback(){

            @Override
            public String preExecute(){

                return "";
            }

            @Override
            public void onExecuteFill(Observer observer){
            }

            @Override
            public void onExecuteSend(Observer observer, int rnd_num){
                final Observer ob = observer;
                final int rn = rnd_num;
                mHandler.post(new Runnable() {
                    public void run() {
                        selectPossess(ob.playerList.get(ob.turn+1), ob.playerList.get(ob.turn).hands.get(rn), ob);
                        ob.playerList.get(ob.turn).hands.remove(rn);
                    }
                });

            }

            @Override
            public void postExecute(){
                startPhase(ob, pt, ad, bn);
            }

        });
        pc.execute();

    }

    protected void addItem(/*StrategyCard strategyCard*/ RecyclerView.Adapter adapter) {
        //hands.add(strategyCard);
        adapter.notifyDataSetChanged();
    }

    public boolean selectPossess(Player player, StrategyCard strategyCard, Observer observer){
        boolean accept = false;
        /* Player(CPU)が受け取るかどうか判断 */
        if(player == observer.player) return true;

        if(true) { //現状、受け取るかどうかの部分は未実装のため、trueをとる
            switch (strategyCard.color) {
                case RED:
                    player.possessView[player.possession.size()].setBackgroundColor(android.graphics.Color.parseColor("#ff0000"));
                    player.possession.add(strategyCard);
                    accept = true;
                    break;
                case BLUE:
                    player.possessView[player.possession.size()].setBackgroundColor(android.graphics.Color.parseColor("#0000ff"));
                    player.possession.add(strategyCard);
                    accept = true;
                    break;
                case BLACK:
                    player.possessView[player.possession.size()].setBackgroundColor(android.graphics.Color.parseColor("#000000"));
                    player.possession.add(strategyCard);
                    accept = true;
                    break;
                default:
                    break;
            }
        }

        return accept;
    }

    /* MovementFunc 実装 */
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


/*
    @Override
    public void onClickList(int index){
        System.out.println(index);

    }
*/

/*
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btn1:
                player = firstDealforMe(allDeck, dealedAgents[0]);
                playerCPUs = firstDealforCPU(allDeck, MAX_PLAYER-1);
                //txt1.setText(dealedAgents[0].agentName.toString());

                //txt1.setText(allDeck.strategyDeck.getFirst().strategy.toString());
                //txt2.setText(allDeck.strategyDeck.getFirst().color.toString());
                //allDeck.strategyDeck.removeFirst();

                break;
            case R.id.btn2:
                player = firstDealforMe(allDeck, dealedAgents[1]);
                playerCPUs = firstDealforCPU(allDeck, MAX_PLAYER-1);
                //txt1.setText(dealedAgents[1].agentName.toString());
                break;
            case R.id.imageButton1:
                txt1.setText("証拠なし……か");
                break;
        }
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        for(int i=0; i<3; i++){
            //txtHands[i].setText(player.hands.get(i).color.toString()+"\n"+player.hands.get(i).strategy.toString());
        }
        //txtSide.setText(player.side.toString());
        observer = new Observer(0, allDeck, player, playerCPUs);
    }
*/
    /*  フェーズを管理するコントローラーの実装　フラグメント実装時に確認を行う予定
    while(true) {
        phaseControl = new PhaseControl(observer, new PhaseControl.PhaseController(){
            @Override
            public void startPhase(Observer observer){
                observer.confirmAbility();
                observer.phase = Phase.FILL;
            }
            @Override
            public void fillPhase(Observer observer){
                observer.confirmAbility();
                movement.Draw(observer.playerList.get(observer.turn), observer.playerList.get(observer.turn).draw_num, observer.deck);
                observer.phase = Phase.STRATEGY;
            }
            @Override
            public void strategyPhase(Observer observer){
                if(observer.playerList.get(observer.turn).playable){

                }else{

                }
                observer.phase = Phase.SEND;
            }
            @Override
            public void sendPhase(Observer observer){
                observer.confirmAbility();
                observer.phase = Phase.FINISH;
            }
            @Override
            public void finishPhase(Observer observer){
                observer.nextTurn(observer.otamo);
                observer.phase = Phase.START;
            }

        });
    }
    */



    public void confirmAbility(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 19) {
            View decor = this.getWindow().getDecorView();
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        } else {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_player);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, new PlayerFlagment());
        transaction.commit();

        //txt1 = (TextView) findViewById(R.id.txt1);
        //txt2 = (TextView) findViewById(R.id.txt2);
        //txtSide = (TextView) findViewById(R.id.txtSide);
        //txtHands[0] = (TextView) findViewById(R.id.txtHand1);
        //txtHands[1] = (TextView) findViewById(R.id.txtHand2);
        //txtHands[2] = (TextView) findViewById(R.id.txtHand3);

        //button1 = (Button) findViewById(R.id.btn1);
        //button1.setOnClickListener(this);
        //button2 = (Button) findViewById(R.id.btn2);
        //button2.setOnClickListener(this);

        //imagebutton1 = (ImageButton) findViewById(R.id.imageButton1);
        //imagebutton1.setOnClickListener(this);
        //txt1 = (TextView) findViewById(R.id.txt1);

        allDeck = new AllDeck();
        //dealedAgents = showAgent(allDeck);

    }

    @Override
    protected void onPause(){
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 19) {
            View decor = this.getWindow().getDecorView();
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
