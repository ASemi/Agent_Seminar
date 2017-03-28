package com.asemi.ailab.agent_seminar;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityGacha extends FragmentActivity implements GachaFlagment.FlagmentListener{
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 19) {
            View decor = this.getWindow().getDecorView();
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        } else {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_gacha);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container_gacha, new GachaFlagment());
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
    public int getAgentViewID(AgentName agentName, boolean already){
        int id;
        if(already) {
            id = getResources().getIdentifier(agentName.toString().toLowerCase(), "drawable", getPackageName());
        }else{
            id = R.drawable.agentback;
        }
        return id;
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
