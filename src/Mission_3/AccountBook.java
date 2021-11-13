package Mission_3;

import java.util.*;

public class AccountBook {
    public Scanner s = new Scanner(System.in);
    public HashMap<String, String> userInfo = new HashMap<>();

    private static final String Dir = "C:\\Users\\admin\\IdeaProjects\\CodeSquad_Cocoa\\src\\Mission_3\\";

    private void promptRegistration() {
        label:
        while (true) {
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 종료");
            String cmd = s.nextLine();

            switch (cmd) {
                case "1":
                    UserInformation.userRegistration(Dir, userInfo, s);
                    break;
                case "2":
                    String userId = UserInformation.userLogin(Dir, userInfo, s);
                    detailRegistration(userId);
                    break label;
                case "3":
                    System.out.println("프로그램을 종료합니다.");
                    break label;
            }
        }
    }

    public void detailRegistration(String userId) {
        label:
        while (true) {
            System.out.println("1. 데이터 입력");
            System.out.println("2. 데이터 삭제");
            System.out.println("3. 데이터 수정");
            System.out.println("4. 데이터 조회");
            System.out.println("5. 데이터 검색");
            System.out.println("6. 월별 출력");
            System.out.println("7. 종료");
            String cmd = s.nextLine();

            switch (cmd) {
                case "1":
                    AccountData.dataRegistration(Dir, userId, s);
                    break;
                case "2":
                case "3":
                    AccountData.dataAdjustment(Dir, userId, s, cmd);
                    break;
                case "4":
                    AccountData.dataLookup(Dir, userId, s);
                    break;
                case "5":
                    AccountData.dataSearch(Dir, userId, s);
                    break;
                case "6":
                    AccountData.monthlyLookup(Dir, userId, s);
                    break;
                case "7":
                    break label;
            }
        }
    }

    public static void main(String[] args) {
        AccountBook a = new AccountBook();
        a.promptRegistration();
    }
}
