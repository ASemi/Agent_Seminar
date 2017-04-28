package com.asemi.ailab.agent_seminar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMenu extends Activity implements View.OnClickListener{

    Button buttonGame, buttonGacha, buttonConfig;
    Intent intentGame, intentGacha, intentConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonGame = (Button)findViewById(R.id.btn_game);
        buttonGame.setOnClickListener(this);
        buttonGame = (Button)findViewById(R.id.btn_gacha);
        buttonGame.setOnClickListener(this);
        buttonGame = (Button)findViewById(R.id.btn_config);
        buttonGame.setOnClickListener(this);


    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_game:
                intentGame = new Intent(ActivityMenu.this, ActivityGame.class);
                startActivity(intentGame);
                break;
            case R.id.btn_gacha:
                intentGacha = new Intent(ActivityMenu.this, ActivityGacha.class);
                startActivity(intentGacha);
                break;
            case R.id.btn_config:
                break;
        }
    }


}
