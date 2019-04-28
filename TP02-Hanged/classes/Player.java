package classes;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Player implements Runnable{
    private Word word;
    private String name;
    private int points;
    private LocalDateTime day;

    public Player(String name, Word word) {
        this.name = name;
        this.word = word;
        this.points = 0;
        this.day = LocalDateTime.now();
    }

    public Player(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    @Override
    public void run() {
        while(!word.voidWord()){  // Los hilos se detienen cuando termina el juego
            if(!word.voidWord()) {
                points+=word.searchLetter();
                if(word.voidWord()){    // Gana el que termina completando la palabra
                    points+=(word.getAmountNotUsedLetters()>0)?50:0; // El jugador recibe puntos extra si descubre la palabra y quedan letras en el alfabeto
                    Player winner = new Player();
                    winner.setName(this.name);
                    winner.setPoints(this.points);
                    winner.setDay(this.day);
                    MySQL.addWinnerDataToDB(winner);
                }
                System.out.printf(" ----- Player Name: %s - Complet Letters: %s \n", name, Arrays.toString(word.getCompletLetters()).replace(",",""));
                System.out.printf(" ----- Player Name: %s - Guessed Letters: %s \n", name, Arrays.toString(word.getGuessedLetters()).replace(",",""));
            }
        }
    }
}
