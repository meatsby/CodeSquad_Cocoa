package Mission_3;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountData {

    public static void dataRegistration(String Dir, String userId, Scanner s) {
        System.out.println("날짜, 적요, 수입, 지출, 소비유형 을 입력하세요. (ex. 2021-11-11 빼빼로 0 1000 카드)");
        ArrayList<String> dataSet = new ArrayList<>();
        String data = s.nextLine();
        dataSet.add(data);

        FileIO.updateDataSet(Dir, userId, true, dataSet);
    }

    public static void dataAdjustment(String Dir, String userId, Scanner s, String cmd) {
        ArrayList<String> dataSet = FileIO.openDataSet(Dir, userId);

        if (cmd.equals("2")) {
            System.out.println("삭제할 항목을 선택해주세요.");
            String idx = s.nextLine();
            dataSet.remove(Integer.parseInt(idx));
        } else if (cmd.equals("3")) {
            System.out.println("수정할 항목을 선택해주세요.");
            String idx = s.nextLine();
            System.out.println("수정할 내용을 입력해주세요.");
            String adjustment = s.nextLine();
            dataSet.set(Integer.parseInt(idx), adjustment);
        }

        FileIO.updateDataSet(Dir, userId, false, dataSet);
    }

    public static void dataLookup(String Dir, String userId, Scanner s) {
        ArrayList<String> dataSet = FileIO.openDataSet(Dir, userId);

        for (int i=0; i < dataSet.size(); i++) {
            System.out.println(i + " " + dataSet.get(i));
        }
    }
}
