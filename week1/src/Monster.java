public class Monster {
    private Position position;
    private String name;

    public Monster(int n, Position p) {
        this.name = "Monster" + n;
        this.position = new Position(p.getX(), p.getY());
    }

    @Override
    public String toString() {
        return "Monster{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
    }
}
