package com.asemi.ailab.agent_seminar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Title extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private TextView txt1, txt2;
    final int MAX_PLAYER = 1;
    Movement movement = new Movement();
    AllDeck allDeck = new AllDeck();
    Agent agent = new Agent(AgentName.ALIAS);
    FirstDeal firstDeal = new FirstDeal(allDeck);
    Player player = new Player(Side.FRS, agent, firstDeal.first_hands);
    Observer observer = new Observer(player, allDeck);


    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.button:
                txt1.setText(allDeck.alldeck.getFirst().strategy.toString());
                txt2.setText(allDeck.alldeck.getFirst().color.toString());
                allDeck.alldeck.removeFirst();
                //textView.setText("button!");
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(this);
    }
}
