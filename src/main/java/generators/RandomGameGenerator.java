package generators;

import model.Race;

import java.util.HashMap;
import java.util.Map;

public class RandomGameGenerator {
    RandomRace genRace;
    World genWorld;
    private Map<Integer, Race> racesMaps = new HashMap<>();

    public void RandomPartyGenerator(int size) {
        genRace = new RandomRace(racesMaps);
        genWorld = new World();
        genWorld.generate(size);

    }

}
