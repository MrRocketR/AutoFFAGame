package engine;

import generators.RandomGame;
import model.Race;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomLobby implements Lobby {

    private RandomGame game;
    private int players;
    private int map_size;
    private ConcurrentLinkedQueue playersQueue = new ConcurrentLinkedQueue();

    public void setParamsForLobby(int players, int map_size) {
        this.players = players;
        this.map_size = map_size;
    }

    @Override
    public void create() {
        this.game = new RandomGame();
    }
}
