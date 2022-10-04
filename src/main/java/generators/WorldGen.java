package generators;

import model.Race;

public interface WorldGen {
    void putToMap (Race[] races);
    void generate(int size);
    int [][] getWorld();
}
