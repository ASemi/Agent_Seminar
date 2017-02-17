package com.asemi.ailab.agent_seminar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Title extends AppCompatActivity implements View.OnClickListener {

    AllDeck allDeck = new AllDeck();
    private Button button1;
    //TextView textView = (TextView) findViewById(R.id.txt1);

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
