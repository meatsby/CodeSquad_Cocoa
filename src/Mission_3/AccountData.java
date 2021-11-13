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

        System.out.println("순번    날짜       적요     수입     지출  유형");
        System.out.println("===========================================");
        for (int i=0; i < dataSet.size(); i++) {
            String[] data = dataSet.get(i).split(" ");
            System.out.printf("%3s %10s %6s %7s %7s %2s\n", i, data[0], data[1], data[2], data[3], data[4]);
        }
    }

    public static void dataSearch(String Dir, String userId, Scanner s) {
        ArrayList<String> dataSet = FileIO.openDataSet(Dir, userId);
        ArrayList<String> temp = new ArrayList<>();
        System.out.println("검색할 항목을 입력해주세요.");
        String search = s.nextLine();

        for (String data : dataSet) {
            if (data.contains(search)) {
                temp.add(data);
            }
        }

        System.out.println("   날짜       적요     수입     지출  유형");
        System.out.println("=======================================");
        for (int i=0; i < temp.size(); i++) {
            String[] data = temp.get(i).split(" ");
            System.out.printf("%10s %6s %7s %7s %2s\n", data[0], data[1], data[2], data[3], data[4]);
        }
    }

    public static void monthlyLookup(String Dir, String userId, Scanner s) {
        ArrayList<String> dataSet = FileIO.openDataSet(Dir, userId);
        ArrayList<String> temp = new ArrayList<>();
        System.out.println("검색할 월을 입력해주세요.");
        String month = s.nextLine();

        for (String data : dataSet) {
            if (Integer.parseInt(data.split(" ")[0].split("-")[1]) == Integer.parseInt(month)) {
                temp.add(data);
            }
        }

        System.out.println("   날짜       적요     수입     지출  유형");
        System.out.println("=======================================");
        for (int i=0; i < temp.size(); i++) {
            String[] data = temp.get(i).split(" ");
            System.out.printf("%10s %6s %7s %7s %2s\n", data[0], data[1], data[2], data[3], data[4]);
        }
    }
}
