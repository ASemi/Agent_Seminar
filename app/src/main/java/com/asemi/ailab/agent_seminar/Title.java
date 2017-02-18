package com.asemi.ailab.agent_seminar;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Title extends Activity implements View.OnClickListener {

    private Button button1;
    private TextView txt1, txt2;

    private ImageButton imagebutton1;

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
            case R.id.imageButton1:
                txt1.setText("証拠なし……か");
                break;
        }
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
        setContentView(R.layout.activity_title);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(this);

        imagebutton1 = (ImageButton) findViewById(R.id.imageButton1);
        imagebutton1.setOnClickListener(this);

        txt1 = (TextView) findViewById(R.id.txt1);

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
