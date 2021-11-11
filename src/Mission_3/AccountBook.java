package Mission_3;

import java.util.*;

public class AccountBook {
    public static Scanner s = new Scanner(System.in);
    public static Map<String, String> userInfo = new HashMap<>();
    public static ArrayList<String[]> accountBook = new ArrayList<>();

    public static void main(String[] args) {

        // 사용자 등록
        userRegistration();

        // 데이터 입력


        while (true) {
            System.out.println("1. 데이터 입력");
            System.out.println("2. 데이터 삭제");
            System.out.println("3. 데이터 수정");
            int n = s.nextInt();

            if (n==1) {
                System.out.println("날짜, 적요, 수입, 지출 을 입력하세요.");
                String[] data = s.next().split(" ");
                accountBook.add(data);

                for (String[] b : accountBook) {
                    System.out.println(b[0]);
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

    private static void userRegistration() {
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

                    if (userInfo.get(id).equals(pw)) {
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
