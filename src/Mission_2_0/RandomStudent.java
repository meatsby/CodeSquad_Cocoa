package Mission_2_0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//코코아 학생 아무나 뽑기
public class RandomStudent {

    public static void main(String[] args) throws FileNotFoundException {
        //학생 리스트(배열)를 만들고
        List<String> cocoaList = createList();

        // 키보드로 입력 받기.
        final int n = input(cocoaList.size());

        //잘 섞어서
        shuffle(cocoaList);

        //그 중에 n명을 뽑는다.
        printN(cocoaList, n);
    }

    private static int input(int m) {
        Scanner s = new Scanner(System.in);
        System.out.print("몇 명 뽑을까요? (1 - " + m + ") ");
        int n = s.nextInt();
        s.close();
        return n;
    }

    private static void printN(List<String> s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i+1 + ". " + s.get(i));
        }
    }

    private static void shuffle(List<String> s) {
        Collections.shuffle(s);
    }

    private static List<String> createList() throws FileNotFoundException {
        List cocoaList = new ArrayList<>();
        File f = new File("user.csv");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String name = s.next();
            cocoaList.add(name);
        }
        s.close();
        return cocoaList;
    }
}
