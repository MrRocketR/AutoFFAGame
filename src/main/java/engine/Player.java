package engine;

import logic.Battle;
import logic.Turns;
import model.Race;

public class Player implements Turns, AI, Battle {
    Race race;


    public synchronized void play() {


    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }


    @Override
    public int[][] makeTurn(int[][] world) {
        return new int[0][];
    }
}
