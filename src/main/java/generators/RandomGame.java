package generators;

import model.Race;

import java.util.HashMap;
import java.util.Map;

public class RandomGame {
    RandomRace genRace;
    World genWorld;
    private Map<Integer, Race> racesMaps = new HashMap<>();


    public void generateGame(int size) {
        genRace = new RandomRace(racesMaps);
        racesMaps = genRace.getRacesMaps();
        genWorld = new World();
        genWorld.generate(size);
    }

}
