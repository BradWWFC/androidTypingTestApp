package com.example.brad.typingtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void startGameOne(View v){
        Intent Intent = new Intent(this, Game.class);
        startActivity(Intent);
    }

    public void startLeadboard(View v){
        Intent Intent = new Intent(this, Leaderboard.class);
        startActivity(Intent);
    }
}
