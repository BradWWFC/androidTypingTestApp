package com.example.brad.typingtest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class gameEndLeaderboard extends AppCompatActivity {

    private TextView score1;
    private TextView score2;
    private TextView score3;
    private TextView score4;
    private TextView score5;
    private TextView finalScoreTextView;
    private int finalScore;
    private SharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_leaderboard);
        sharedpref = new SharedPref(getApplicationContext());

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            finalScore = extras.getInt("finalScore");
            //The key argument here must match that used in the other activity
        }

        score1 = findViewById(R.id.score5);
        score2 = findViewById(R.id.score4);
        score3 = findViewById(R.id.score3);
        score4 = findViewById(R.id.score2);
        score5 = findViewById(R.id.score1);
        finalScoreTextView = findViewById(R.id.finalScore);

        finalScoreTextView.setText(String.valueOf(finalScore));

        setMenu();

    }

    @Override
    public void onBackPressed() {
        Intent Intent = new Intent(this, Menu.class);
        startActivity(Intent);
    }

    public void setMenu(){
        List<Integer> scores = sharedpref.getLeaderboardInputs();
        TextView[] idList = {score1,score2,score3,score4,score5};

        for(int i = 0;i<idList.length;i++) {
            idList[i].setText(String.valueOf(scores.get(i)));
        }
    }
}
