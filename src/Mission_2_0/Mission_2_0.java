package Mission_2_0;

import java.util.Random;
import java.util.Scanner;

public class Mission_2_0 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] members = {"Tany", "Ella", "BC", "Barney", "Konda", "Jhin", "OS", "Sonny", "meatsby", "Bart", "Hanse"};
        int a[] = new int[members.length];
        System.out.print("몇 명인가요? ");
        int n = s.nextInt();
        boolean isFirst = true;
        Random r = new Random();

        for (int i=0; i<members.length; i++) {
            a[i] = r.nextInt(members.length)+1;
            for (int j=0; j<i; j++) {
                if (a[i] == a[j]) {
                    i--;
                }
            }
        }

        for (int b=0; b<n; b++) {
            if (isFirst) {
                System.out.print(members[a[b]]);
                isFirst = false;
            } else {
                System.out.print(", " + members[a[b]]);
            }
        }
    }
}
