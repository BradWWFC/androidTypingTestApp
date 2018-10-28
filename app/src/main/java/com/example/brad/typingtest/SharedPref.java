package com.example.brad.typingtest;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;


public class SharedPref {

    private static Context context;
    private android.content.SharedPreferences pref;
    private android.content.SharedPreferences.Editor editor;
    private static String[] prefNames = new String[]{"Score1", "Score2", "Score3", "Score4", "Score5"};

    public SharedPref(Context importedContext) {
        setContext(importedContext);
        pref = context.getSharedPreferences("Scores", 0);
        editor = pref.edit();
    }

    public void setContext(Context myContext){

        context = myContext;
    }

    public void createLeaderboard(){
        editor.putInt("Score1",0);
        editor.putInt("Score2",0);
        editor.putInt("Score3",0);
        editor.putInt("Score4",0);
        editor.putInt("Score5",0);
        editor.commit();
        for(String x: prefNames){
            x = String.valueOf(0);
        }
    }

    public List<Integer> getLeaderboardInputs() {
        List<Integer> returnValues = new ArrayList<>();
        for (String x : prefNames) {
            Integer value = pref.getInt(x, -1);
            returnValues.add(value);
        }
        if(returnValues.get(0) == -1){
            createLeaderboard();
            for (int i = 0;i<prefNames.length;i++) {
                Integer value = pref.getInt(prefNames[i], 0);
                returnValues.set(i,value);
            }
        }
        return returnValues;
    }

    public void addToLeaderboard(String[] prefString, List<Integer> listofscores) {
        for (int i=0;i<prefString.length;i++) {
            editor.putInt(prefString[i], listofscores.get(i));
            editor.commit();
        }
    }

    public void UpdateLeaderboard(int finalScore){
        //gets the values
        List<Integer> scores = getLeaderboardInputs();


        //first part is for if it is a new top score
        if (finalScore >= scores.get(scores.size()-1)){ //if score is same or better than top score
            for(int i=0;i<scores.get(scores.size()-1);i++){
                scores.set(i,scores.get(i+1)); //moves all scores down one, makes [i] value the same as the next value in the array
            }
            scores.set(scores.size()-1,finalScore);
        }else{
            //this section is for new scores from 5 to 2.
            for(int i=0;i<scores.get(scores.size()-1);i++){
                if(finalScore<scores.get(i)){
                    if(i>0){
                        for(int j = 0; j<i-1;j++){
                            scores.set(j,scores.get(j+1));
                        }
                        scores.set(i-1,finalScore);
                        break;
                    }
                }
            }
        }
        //final section assigns new values to shared preference variables.
        addToLeaderboard(prefNames,scores);
    }

}
