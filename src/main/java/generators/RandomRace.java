package generators;

import model.Race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomRace implements RaceGen {
    final Random random = new Random();

    final String[] first = new String[] {
        "Angry", "Dark", "Fire", "Kingdom of", "Empire of",
            "Nice", "Cold", "Duchy", "Holy Kingdom of",
            "Triumvirate of", "The Horde of", "Big Angry",
            "Dynasty of", "Holy order of", "", "Black",
            "Community of", "Republic of ", "Frost"
    };

    final String[] second  = new String[] {
            "Humans", "Girls", "Boys", "Bats",
            "Rats", "Women", "Americans",
            "Russians", "Borgs", "Orcs",
            "Mice", "Elves", "Hobbits",
            "Communists", "Fascists",
            "BlackWidows", "Barbarians",
            "Ants", "Angels", "Devils",
            "Imps", "Pirates"
    };


    private  Race[] races;


    @Override
    public Race[] create(int n) {
        Race[] races = new Race[n];
        for (int i = 0; i < races.length; i++) {
            int firstWord =  random.nextInt(first.length);
            int secondWord =  random.nextInt(second.length);
            String name = first[firstWord] + " " + second[secondWord];
            int turns = random.nextInt(3);
            int power = random.nextInt(3);
            Race temp = new Race(i + 1, name, turns, power);
            races[i] = temp;
        }
        return races;
    }

    public Race[] getRaces() {
        return races;
    }
}
