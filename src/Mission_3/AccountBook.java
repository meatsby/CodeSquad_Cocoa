package Mission_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AccountBook {
    public Scanner s = new Scanner(System.in);
    public HashMap<String, String> userInfo = new HashMap<>();
    public ArrayList<String[]> accountBook = new ArrayList<>();

    public void detailRegistration() {
        while (true) {
            System.out.println("1. 데이터 입력");
            System.out.println("2. 데이터 삭제");
            System.out.println("3. 데이터 수정");
            int n = s.nextInt();

            if (n==1) {
                System.out.println("날짜, 적요, 수입, 지출 을 입력하세요.");
                String[] data = s.next().split(",");
                accountBook.add(data);

                System.out.println(accountBook);
            } else if (n==2) {
                System.out.print("사용자 이름을 입력해주세요. : ");
                String newId = s.next();

                if (userInfo.containsKey(newId)) {
                    System.out.println("이미 존재하는 이름입니다.");
                } else {
                    System.out.print("비밀번호를 입력해주세요. : ");
                    String newPw = s.next();
                    userInfo.put(newId, newPw);
                    System.out.println("회원가입이 완료되었습니다.");
                }
            } else if (n==3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    private void promptRegistration() {
        while (true) {
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 종료");
            int cmd = s.nextInt();

            if (cmd==1) {
                UserInformation.userRegistration(userInfo, s);
            } else if (cmd==2) {
                UserInformation.userLogin(userInfo, s);
            } else if (cmd==3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        AccountBook a = new AccountBook();
        // 사용자 등록
        a.promptRegistration();
    }
}
