package model;

import java.util.Objects;

public class Player {

    private int pl_id;
    private String name;
    private Race race;
    private int population;

    public Player(int pl_id, String name, Race race) {
        this.pl_id = pl_id;
        this.name = name;
        this.race = race;
        this.population = 1;
    }

    public int getPl_id() {
        return pl_id;
    }

    public void setPl_id(int pl_id) {
        this.pl_id = pl_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return pl_id == player.pl_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pl_id, name, race);
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
