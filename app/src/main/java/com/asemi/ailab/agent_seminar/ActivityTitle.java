package com.asemi.ailab.agent_seminar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class ActivityTitle extends Activity {

    Intent menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        menu = new Intent(ActivityTitle.this, ActivityMenu.class);
        startActivity(menu);
        overridePendingTransition(R.anim.in_right, R.anim.out_left);
        return true;
    }

}
