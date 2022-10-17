package generators;

import model.Player;
import model.Race;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomGame {
    RandomRace genRace;
    World genWorld;
    RandomPlayers randomPlayers;
    private Map<Integer, Player> playersMap;
    private ConcurrentLinkedQueue playersQueue;
    private int[][] world;


    public void generateGame(int worldSize, int players) {
        genWorld = new World();
        genRace = new RandomRace();
        randomPlayers = new RandomPlayers();
        System.out.printf("Generating world size = ", worldSize);
        genWorld.generate(worldSize);
        world = genWorld.getWorld();
        System.out.println("Creating races count = " + players);
        Race[] races = genRace.generate(players);
        randomPlayers.create(races);
        System.out.println("Generating players = " + players);
        playersMap = randomPlayers.getPlayerMap();
        playersQueue = randomPlayers.getPlayers();
    }


    public Map<Integer, Player> getPlayersMap() {
        return playersMap;
    }

    public ConcurrentLinkedQueue getPlayersQueue() {
        return playersQueue;
    }

    public int[][] getWorld() {
        return world;
    }
}
