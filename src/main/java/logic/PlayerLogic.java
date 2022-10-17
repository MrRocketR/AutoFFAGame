package logic;

import engine.AI;
import generators.WorldGen;
import model.Player;
import model.Race;

import java.util.Random;

public class PlayerLogic extends  Thread implements Turns, AI, Battle {

    private Player player;
    private volatile RandomMaster master;
    private Race race;
    private int id = 1;
    private int turns = 0;
    private int population = 1;
    private WorldGen worldGen;

    public PlayerLogic(Player player, RandomMaster master) {
        this.player = player;
        this.turns = player.getRace().getTurns();
        this.id++;
        this.master = master;
    }

    @Override
    public void run() {
        while (population > 0) {
            try {
                play();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        master.deletePlayer(id);
    }

    public synchronized void play() throws InterruptedException {
        int[][] result = master.getWorld();
        while (turns != 0) {
            result = makeTurn(result);
        }
        wait();

    }


    @Override
    public int[][] makeTurn(int[][] world) {
        int[][] current = world;
        Random random = new Random();
        int row = random.nextInt(current.length);
        int element = random.nextInt(current[row].length);
        int cell = current[row][element];
        if (cell == 0) {
            current[row][element] = id;

        } else if (cell != id) {
            fight(id, cell);
        }

        return current;
    }

    @Override
    public void fight(int player1, int player2) {

    }
    public void setId(int id) {
        this.id = id;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void lose() {
        population--;
    }


}
