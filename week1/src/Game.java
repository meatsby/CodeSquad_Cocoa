public class Game {

    private final int WIDTH = 5;
    private final int HEIGHT = 5;
    private final int PLAYER_X = 2;
    private final int PLAYER_Y = 2;

    private Player player;
    private int[][] map;
    private Monster monster;

    public void init() {
        createMap(WIDTH, HEIGHT);
        String name = getNameFromUser();
        player = new Player(name, PLAYER_X, PLAYER_Y);
    }

    //TODO: 키보드 입력 받기
    private String getNameFromUser() {
        return "meatsby";
    }

    private void createMap(int w, int h) {
        map = new int[w][h];
    }

    private void start() {
        System.out.println("Game Start");
    }

    public void showResult() {
        System.out.println("Thank You.");
        System.out.println("Your Score: " + player.getScore());
    }
}
