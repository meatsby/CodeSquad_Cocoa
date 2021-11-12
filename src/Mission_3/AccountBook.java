package Mission_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AccountBook {
    public Scanner s = new Scanner(System.in);
    public HashMap<String, String> userInfo = new HashMap<>();

    private void promptRegistration() {
        while (true) {
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 종료");
            String cmd = s.nextLine();

            if (cmd.equals("1")) {
                UserInformation.userRegistration(userInfo, s);
            } else if (cmd.equals("2")) {
                String userId = UserInformation.userLogin(userInfo, s);
                detailRegistration(userId);
                break;
            } else if (cmd.equals("3")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    public void detailRegistration(String userId) {
        String path = "C:\\Users\\admin\\IdeaProjects\\CodeSquad_Cocoa\\src\\Mission_3\\" + userId; //폴더 경로
        File Folder = new File(path);

        // 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
        if (!Folder.exists()) {
            try{
                Folder.mkdir(); //폴더 생성합니다.
                System.out.println(userId + "님 반갑습니다.");
            }
            catch(Exception e){
                e.getStackTrace();
            }
        }else {
            System.out.println(userId + "님 환영합니다.");
        }

        while (true) {
            System.out.println("1. 데이터 입력");
            System.out.println("2. 데이터 삭제");
            System.out.println("3. 데이터 수정");
            String cmd = s.nextLine();

            if (cmd.equals("1")) {
                System.out.println("날짜, 적요, 수입, 지출, 소비유형 을 입력하세요.");
                String[] data = s.nextLine().split(" ");
                System.out.println(Arrays.toString(data));
                break;
//                AccountData.dataRegistration(userInfo, s);
            } else if (cmd.equals("2")) {
                AccountData.dataDeletion(userInfo, s);
            } else if (cmd.equals("3")) {
                AccountData.dataAdjustment(userInfo, s);
            }
        }
    }

    public static void main(String[] args) {
        AccountBook a = new AccountBook();
        // 사용자 등록
        a.promptRegistration();
    }
}
