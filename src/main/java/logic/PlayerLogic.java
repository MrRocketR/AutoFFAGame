package logic;

import engine.AI;
import generators.WorldGen;
import model.Race;

import java.util.Random;

public class PlayerLogic implements Turns, AI, Battle, Runnable {
    private Race race;
    private int id;
    private int turns;
    private int population = 1;
    private WorldGen worldGen;

    @Override
    public void run() {
        while (population > 0) {
            play();
        }
        System.out.println(this.getRace() + " is destroyed!");
        Master.deletePlayer(id);
    }

    public synchronized void play() {
        int[][] result = worldGen.getWorld();
        while (Master.getList().contains(this.getId())) {
            try {
                if (turns != 0) {
                    result = makeTurn(result);
                    turns--;
                } else {
                    Master.getList().remove(id);
                }
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
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
        PlayerLogic pl1 = Master.getPlayer(player1);
        PlayerLogic pl2 = Master.getPlayer(player2);
        System.out.println(pl1.getRace().getName() + " is fighting with"
                + pl2.getRace().getName());
        boolean result = pl1.getRace().getPower() > pl2.getRace().getPower();
        if (result) {
            System.out.println(pl1.getRace().getName() + "wins!");
            pl2.lose();
        }
    }


    public int getId() {
        return id;
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
