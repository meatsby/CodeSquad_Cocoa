package Mission_2_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Mission_2_2 {
    public static Random r = new Random();
    public static Scanner s = new Scanner(System.in);
    public static int[][] arr = new int[5][5];
    public static String[][] map = new String[5][5];
    public static int[] playerCo = {2, 2};
    public static int[] monsCo = createRandom();
    public static int[] mineCo = createRandom();

    public static void main(String[] args) {

        resetMap(playerCo[0], playerCo[1]);

        int score = 0;

        // move 설정
        HashMap<String, int[]> move = new HashMap<String, int[]>();
        move.put("w", new int[]{-1, 0});
        move.put("a", new int[]{0, -1});
        move.put("s", new int[]{1, 0});
        move.put("d", new int[]{0, 1});

        // 게임 시작
        while (true) {
            // 지도 출력
            for (int i = 0; i < map.length; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }

            System.out.println("이동할 방향을 입력해주세요. (w, a, s, d)");
            String cmd = s.nextLine();

            arr[playerCo[0]][playerCo[1]] = 0;
            playerCo[0] = playerCo[0] + move.get(cmd)[0];
            playerCo[1] = playerCo[1] + move.get(cmd)[1];
            if (arr[playerCo[0]][playerCo[1]] == 3) {
                System.out.println("지뢰를 밟았습니다.");
                System.out.println("게임 종료");
                break;
            }
            if (arr[playerCo[0]][playerCo[1]] == 2) {
                arr[playerCo[0]][playerCo[1]] = 1;
                score = score + 100;
                System.out.println("몬스터를 잡았습니다! +" + score + "점 획득.");
                System.out.println("현재 스코어: " + score);
                System.out.println("몬스터와 지뢰의 위치를 재설정합니다.");
                resetMap(playerCo[0], playerCo[1]);
                continue;
            }
            arr[playerCo[0]][playerCo[1]] = 1;
        }
    }

    private static void resetMap(int x, int y) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
                map[i][j] = "□";
            }
        }

        arr[x][y] = 1;
        map[x][y] = "■";

        while (monsCo == playerCo || monsCo == mineCo) {
            monsCo = createRandom();
        }
        arr[monsCo[0]][monsCo[1]] = 2;
        map[monsCo[0]][monsCo[1]] = "⊙";

        while (mineCo == playerCo || mineCo == monsCo) {
            mineCo = createRandom();
        }
        arr[mineCo[0]][mineCo[1]] = 3;
    }

    private static int[] createRandom() {
        int randomX = r.nextInt(5);
        int randomY = r.nextInt(5);
        int[] cord = {randomX, randomY};
        return cord;
    }
}
