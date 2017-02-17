package com.asemi.ailab.agent_seminar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Title extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    //TextView textView = (TextView) findViewById(R.id.txt1);
    final int MAX_PLAYER = 1;
    Movement movement = new Movement();
    AllDeck allDeck = new AllDeck();

    /* 初期準備を行うクラスが必要 */

    Database database = new Database();
    Agent agent = new Agent(database, AgentName.ALIAS);

    Player player = new Player(Side.FRS, agent, /* 初期準備インスタンス */.hands);

    Observer observer = new Observer(player, allDeck);



    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.button:
                StrategyCard sc = allDeck.alldeck.getFirst();
                System.out.println(sc);
                //textView.setText("button!");
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(this);
    }
}
