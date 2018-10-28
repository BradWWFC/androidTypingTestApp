package com.example.brad.typingtest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    private long timeLeftInMilliseconds = 60000;
    private TextView timerText;
    private String randomWord;
    private EditText editText;
    private int gameScore = 0;


    //Methods for the game
    public void generateWord(){
        TextView text = findViewById(R.id.wordTextView);
        Words word = new Words();
        if(gameScore<5){
            randomWord = word.getThreeLetterWord();
        } else if (gameScore>=5 && gameScore<10){
            randomWord = word.getFourLetterWord();
        } else if (gameScore>=10 && gameScore<15){
            randomWord = word.getFiveLetterWord();
        } else if (gameScore>=15){
            randomWord = word.getSixLetterWord();
        }
        text.setText(randomWord);
    }

    public void addScore(){
        TextView scoreTextView = findViewById(R.id.Score);
        gameScore = gameScore+1;
        System.out.println(gameScore);
        scoreTextView.setText(String.valueOf(gameScore));
    }

    public void countdownTimer(){
        new CountDownTimer(timeLeftInMilliseconds, 1000) {

            public void onTick(long millisUntilFinished) {
                timerText.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                SharedPref sharedpref = new SharedPref(getApplicationContext());
                sharedpref.UpdateLeaderboard(gameScore);
                finishGame();
            }
        }.start();
    }

    public void finishGame(){
        Intent Intent = new Intent(this, gameEndLeaderboard.class);
        Intent.putExtra("finalScore", gameScore);
        startActivity(Intent);
    }

    private final TextWatcher editTextChanger = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String input = editText.getText().toString();
            if(input.equals(randomWord)){
                generateWord();
                editText.getText().clear();
                addScore();
            }
        }

        public void afterTextChanged(Editable s) {
        }
        };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        generateWord();

        timerText = findViewById(R.id.Time);
        countdownTimer();

        editText = findViewById(R.id.editText);
        editText.addTextChangedListener(editTextChanger);

    }
}
