package Mission_2_2;

public class Monster {
    private Position position;
    private String name;

    public Monster(int n, Position p) {
        this.name = "Mission_2_2.Monster" + n;
        this.position = new Position(p.getX(), p.getY());
    }

    @Override
    public String toString() {
        return "Mission_2_2.Monster{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
    }
}
