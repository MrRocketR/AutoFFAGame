package generators;

import model.Race;

import java.util.Random;

public class World implements WorldGen {
    private int[][] world;

    @Override
    public void putToMap(Race[] races) {
        Random random = new Random();
        for (int i = 0; i < races.length; i++) {
            int raw = random.nextInt(world.length);
            int el = random.nextInt(world[raw].length);
            world[1][2] = races[i].getRace_id();
            if (world[raw][el] == 0) {
                world[raw][el] = races[i].getRace_id();
            }
        }
    }

    @Override
    public void generate(int size) {
        world = new int[2][size];
    }

    public int[][] getWorld() {
        return world;
    }

    public void setWorld(int[][] world) {
        this.world = world;
    }
}
