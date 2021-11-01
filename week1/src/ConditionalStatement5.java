import java.util.Scanner;

public class ConditionalStatement5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int H = s.nextInt(); // 시
        int M = s.nextInt(); // 분
        s.close();

        if(M < 45) {
            H--; // 시(hour) 1 감소
            M = 60 - (45 - M); // 분(min) 감소
            if(H < 0) {
                H = 23;
            }
            System.out.println(H + " " + M);
        }
        else {
            System.out.println(H + " " + (M - 45));
        }
    }
}