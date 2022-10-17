package model;

public class Race {
    private int race_id;
    private int turns;
    private String name;
    private int power;



    public Race(int id, String name, int turns, int power) {
        this.race_id = id;
        this.name = name;
        this.turns = turns;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Race{" + ", turns=" + turns
                + ", name='" + name + '\''
                + ", power=" + power + '}';
    }
}
