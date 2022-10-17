package engine;

import generators.RandomGame;
import model.Player;
import model.Race;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomLobby implements Lobby {

    private RandomGame game;
    private int players;
    private int map_size;
    private Map<Integer, Player> playersMap;
    private ConcurrentLinkedQueue playersQueue;
    private int[][] world;

    public void setParamsForLobby(int players, int map_size) {
        this.players = players;
        this.map_size = map_size;
        create();
    }

    @Override
    public void create() {
        this.game = new RandomGame();
        game.generateGame(map_size, players);
    }

    public void setParamsForGame() {
        playersMap = game.getPlayersMap();
        playersQueue = game.getPlayersQueue();
        world = game.getWorld();
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
