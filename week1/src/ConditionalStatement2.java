import java.util.Scanner;

public class ConditionalStatement2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int A = s.nextInt();

        s.close();

        if(A>=90) System.out.println("A");
        else if(A>=80) System.out.println("B");
        else if (A>=70) System.out.println("C");
        else if(A>=60) System.out.println("D");
        else System.out.println("F");
    }
}
