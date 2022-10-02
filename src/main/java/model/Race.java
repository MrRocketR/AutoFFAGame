package model;

public class Race {
    private int id;
    private int turns;
    private String name;
    private int power;

    public Race(int id, String name, int turns, int power) {
        this.id = id;
        this.name = name;
        this.turns = turns;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
