import classes.*;

import java.util.ArrayList;
import java.util.List;

public class HangedGame {
    public static void main(String[] args) {
        MySQL.makeJDBCConnection();
        Word word = new Word(MySQL.getRandomWordFromDB());

        System.out.printf("Word: %s",word.getWord());
        int numberOfPlayers = 2;
        List<Player> players = new ArrayList<>();
        Player winner;

        for(int i=0;i<numberOfPlayers;i++){
            players.add(new Player("Machine "+(i+1), word));
        }

        Thread threadPlayers[] = new Thread[numberOfPlayers];

        for(int i =0; i<numberOfPlayers;i++) {
            threadPlayers[i] = new Thread(players.get(i));
            threadPlayers[i].start();
        }
    }

}
