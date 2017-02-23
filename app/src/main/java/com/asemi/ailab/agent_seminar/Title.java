package com.asemi.ailab.agent_seminar;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Title extends FragmentActivity implements PlayerFlagment.FlagmentListener {

    private Button button1, button2;
    private TextView txt1, txt2, txtSide;
    private TextView[] txtHands = new TextView[3];

    private ImageButton imagebutton1;

    final int MAX_PLAYER = 9;
    Movement movement;
    AllDeck allDeck;
    Agent[] dealedAgents;
    Player player;
    ArrayList<Player> playerCPUs;
    PhaseControl phaseControl;
    Observer observer;


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
        return new Observer(0, allDeck, player, playerCPUs);
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


        movement = new Movement();
        allDeck = new AllDeck();
        //dealedAgents = showAgent(allDeck);

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
