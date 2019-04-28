package classes;

import java.util.Arrays;

public class Word {
    private String word;
    private char[] guessedLetters;
    private char[] completLetters;
    private int amountLettersNotGuessed;
    private Alphabet alphabet;
    private Boolean closed = Boolean.FALSE;


    public Word(String word) {
        this.word = word;
        this.amountLettersNotGuessed = word.length();
        completLetters = word.toCharArray();
        guessedLetters = new char[word.length()];
        this.alphabet = new Alphabet();
        setGuessedLetters();
    }

    public String getWord() {
        return word;
    }

    public char[] getGuessedLetters() {
        return guessedLetters;
    }

    public char[] getCompletLetters() {
        return completLetters;
    }

    private void setGuessedLetters(){
        for(int i=0;i<word.length();i++){
            guessedLetters[i] = ('_');
        }
    }

    public int getAmountNotUsedLetters(){
        return alphabet.getAmountNotUsedLetters();
    }

    public synchronized int searchLetter(){
        int count=0;
        while(Boolean.TRUE.equals(closed)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.closed=Boolean.TRUE;
        char c = this.alphabet.getRandomLetter();
        System.out.printf(" ----- Alphabet: %s \n", this.alphabet.notUsedLetters);

        for (int i = 0; i < completLetters.length; i++) {
            if (completLetters[i] == c) {
                count++;
                guessedLetters[i] = c;
                completLetters[i] = '_';
                amountLettersNotGuessed--;
            }
        }
        this.closed=Boolean.FALSE;
        notifyAll();
        return count;
    }

    public Boolean voidWord(){
        return (amountLettersNotGuessed>0)?Boolean.FALSE : Boolean.TRUE;
        //return amountLettersNotGuessed == 0; // It's the same
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
