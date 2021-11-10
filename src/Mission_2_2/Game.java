package Mission_2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final int WIDTH = 5;
    private final int HEIGHT = 5;
    private final int PLAYER_X = 2;
    private final int PLAYER_Y = 2;
    private final int MAX_MONSTER = 3;

    private Player player;
    private int[][] map;
    private List<Monster> monsters;

    public boolean isValidLocation(int x, int y) {
        if (player.isSamePosition(x, y)) return false;
        return true;
    }

    public void init() {
        createMap(WIDTH, HEIGHT);
        String name = getNameFromUser();
        player = new Player(name, PLAYER_X, PLAYER_Y);
        setMonsters();
    }

    private void setMonsters() {
        monsters = new ArrayList<>();
        for (int i = 0; i < MAX_MONSTER; i++) {
            Position p = generateValidRandomPosition();
            Monster m = new Monster(i, p);
            monsters.add(m);
        }
    }

    //TODO: must implement!
    private Position generateValidRandomPosition() {
        return new Position(1, 1);
    }

    private String getNameFromUser() {
        Scanner s = new Scanner(System.in);
        String userName = s.nextLine();
        return userName;
    }

    private void createMap(int w, int h) {
        map = new int[w][h];
    }

    public void start() {
        System.out.println("Mission_2_2.Game Start");
    }

    public void showResult() {
        System.out.println("Thank You.");
        System.out.println(this.player);
        for (Monster m : monsters) {
            System.out.println(m);
        }
        System.out.println("Your Score: " + player.getScore());
    }
}
