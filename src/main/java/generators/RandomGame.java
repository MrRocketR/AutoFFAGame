package generators;

import model.Player;
import model.Race;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomGame {
    RandomRace genRace;
    World genWorld;
    RandomPlayers randomPlayers;
    private Map<Integer, Race> racesMaps = new HashMap<>();
    private ConcurrentLinkedQueue players = new ConcurrentLinkedQueue();
    private int[][] world;


    public ConcurrentLinkedQueue<Player> generateGame(int map, int players) {
            return null;
    }


}
