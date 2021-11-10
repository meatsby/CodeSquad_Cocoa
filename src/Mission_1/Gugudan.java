package Mission_1;

import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시작단 : ");
        int start = scanner.nextInt();
        System.out.println("끝단 : ");
        int end = scanner.nextInt();

        for(int i = start; i < end+1; i++) {
            System.out.println(i + "단");
            for(int j = 1; j < 10; j++) {
                System.out.println(i + "*" + j + "=" + i * j);
            }
        }
    }
}
