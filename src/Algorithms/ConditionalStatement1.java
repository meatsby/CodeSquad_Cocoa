package Algorithms;

import java.util.Scanner;

public class ConditionalStatement1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int A = s.nextInt();
        int B = s.nextInt();

        s.close();

        if(A>B) System.out.println(">");
        else if(A<B) System.out.println("<");
        else System.out.println("==");
    }
}
