import java.util.Scanner;

public class Loop2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        String a = s.next();
        s.close();

        int sum = 0;

        for(int i = 0; i < N; i++) {
            sum += a.charAt(i)-'0';
        }
        System.out.print(sum);
    }
}
