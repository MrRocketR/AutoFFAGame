package generators;

import model.Player;
import model.Race;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomPlayers {

    private ConcurrentLinkedQueue players;
    private int number;
    private Map<Integer, Player> playerMap = new HashMap<>();

    public void create(Race[] races) {
        players = new ConcurrentLinkedQueue<>();
        playerMap = new HashMap<>();
        for (int i = 0; i < races.length; i++) {
            String name = "Player" + i;
            Player temp = new Player(i, name, races[i]);
            players.offer(temp);
            playerMap.put(i, temp);
        }
    }


    public ConcurrentLinkedQueue getPlayers() {
        return players;
    }

    public Map<Integer, Player> getPlayerMap() {
        return playerMap;
    }
}
