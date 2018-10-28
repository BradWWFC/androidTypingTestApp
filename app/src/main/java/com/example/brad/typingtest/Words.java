package com.example.brad.typingtest;

import java.util.Random;

public class Words {

    private String[] threeLetterWords;
    private String[] fourLetterWords;
    private String[] fiveLetterWords;
    private String[] sixLetterWords;
    private String[] sevenLetterWords;
    private String[] eightLetterWords;
    private String[] nineLetterWords;
    private String[] tenLetterWords;

    public Words(){
        threeLetterWords = new String[]{"inn", "boy", "rub", "ice", "row", "dog", "net", "bar", "pop", "cat", "key",
        "add", "sin", "air", "can", "act", "cap", "fun", "top", "era", "spy", "fee", "mix", "say", "gun", "car", "pat", "bus",
        "get", "fix","tin","end","dry","bag","put","cap","joy","fun","hen","pit","hut","ice", "die","jam","fly","bee","nap","tax",
        "sea","try","tie","cup","cow","boy","bow","bar","hot","lot","sip","row"};

        fourLetterWords = new String[]{"cage","pray","hard","golf","beat","fork","keep","suit","soap","face","real","high","wife",
        "chop","drop","roll","stun","hurl","fund","belt","step","root","well","ruin","tent","door","good","sell","chin","snap",
        "give","duke","jump","mail","army","want","feed","heel","hang","mask","risk","hook","king","loud","year","note","inch","gene",
        "lamb","fast","seat","hell","dark","rule","self","pony","last","ally","thin","late"};

        fiveLetterWords = new String[]{"coast","forum","trade","grave","climb","essay","court","eagle","joint","short","final","virus",
        "youth","rally","elbow","elect","shelf","crime","sweat","faint","guard","judge","embox","knock","arise","scene","fraud","fever",
                "organ","voter"};

        sixLetterWords = new String[]{"spirit","seller","efflux","scheme","mosque","treaty","artist","gossip","bottle","please","ballot",
        "bullet","source","patent","profit","return","muscle","flight","voyage","career","valley","endure","nuance","reason","reward","father",
        "decide","tissue","stroke","castle"};
    }

    public String getThreeLetterWord(){
        int rnd = new Random().nextInt(threeLetterWords.length);
        return threeLetterWords[rnd];
    }

    public String getFourLetterWord(){
        int rnd = new Random().nextInt(fourLetterWords.length);
        return fourLetterWords[rnd];
    }

    public String getFiveLetterWord(){
        int rnd = new Random().nextInt(fiveLetterWords.length);
        return fiveLetterWords[rnd];
    }

    public String getSixLetterWord(){
        int rnd = new Random().nextInt(sixLetterWords.length);
        return sixLetterWords[rnd];
    }

}
