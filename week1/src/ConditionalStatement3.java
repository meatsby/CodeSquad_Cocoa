import java.util.Scanner;

public class ConditionalStatement3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int y = s.nextInt();
        s.close();

        if(y%4==0) {
            if(y%400==0) System.out.println("1");
            else if(y%100==0) System.out.println("0");
            else System.out.println("1");
        }
        else System.out.println("0");
    }
}