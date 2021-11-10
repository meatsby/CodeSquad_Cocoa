package Mission_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountBook {
    public static Scanner s = new Scanner(System.in);
    public static Map<String, String> userInfo = new HashMap<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 종료");
            int n = s.nextInt();

            if (n==1) {
                if (userInfo.isEmpty()) {
                    System.out.println("등록된 사용자가 존재하지 않습니다.");
                    continue;
                } else {
                    System.out.print("사용자 이름을 입력해주세요. : ");
                    String id = s.next();
                    System.out.print("비밀번호를 입력해주세요. : ");
                    String pw = s.next();

                    if (userInfo.get(id) == pw) {
                        System.out.println(id + "님 환영합니다.");
                        break;
                    } else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    }
                }
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
}
