package engine;

import generators.RaceGen;
import generators.RandomRace;
import generators.WorldGen;
import model.Race;

import java.util.Arrays;
import java.util.List;

public class InitGame {

    RaceGen raceGen;
    WorldGen worldGen;

    public static void main(String[] args) {
        RandomRace randomRace = new RandomRace();
        Race [] races;
        races = randomRace.create(10);
        System.out.println(Arrays.asList(races));


    }
}
