package classes;

import util.Tools;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    List<Character> notUsedLetters = new ArrayList<>();


    public Alphabet() {
        for(char c = 'a'; c <= 'z'; c++){
            this.notUsedLetters.add(c);
        }
    }

    public int getAmountNotUsedLetters(){
        return notUsedLetters.size();
    }

    public Boolean voidNotUsedLetters(){
        return notUsedLetters.size() == 0;
        //return (notUsedLetters.size()>0)?Boolean.FALSE : Boolean.TRUE;
    }

    public char getRandomLetter(){
        char c;
        int i = Tools.fRandomRange(0,this.notUsedLetters.size());
        c = this.notUsedLetters.get(i);
        this.notUsedLetters.remove(i);
        return c;
    }

    @Override
    public String toString() {
        return "Alphabet{" +
                "notUsedLetters=" + notUsedLetters +
                '}';
    }
}
