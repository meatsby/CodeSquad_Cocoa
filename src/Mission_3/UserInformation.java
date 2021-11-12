package Mission_3;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class UserInformation {

    private static final String USER_INFO = "userInfo.txt";

    public static void userRegistration(HashMap<String, String> userInfo, Scanner s) {
        System.out.print("사용자 이름을 입력해주세요. : ");
        String newId = s.next();

        if (userInfo.containsKey(newId)) {
            System.out.println("이미 존재하는 이름입니다.");
        } else {
            System.out.print("비밀번호를 입력해주세요. : ");
            String newPw = s.next();
            userInfo.put(newId, newPw);

            File f = new File(USER_INFO);
            try {
                FileWriter fw = new FileWriter(f, true);
                fw.write(newId + "," + newPw + "\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("회원가입이 완료되었습니다.");
        }
    }

    public static void userLogin(HashMap<String, String> userInfo, Scanner s) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(USER_INFO));
            while (true) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (line == null) break;
                String id = line.split(",")[0];
                String pw = line.split(",")[1];
                userInfo.put(id, pw);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("사용자 이름을 입력해주세요. : ");
        String id = s.next();
        if (userInfo.containsKey(id)) {
            System.out.print("비밀번호를 입력해주세요. : ");
            String pw = s.next();
            if (userInfo.get(id).equals(pw)) {
                System.out.println(id + "님 환영합니다.");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        } else {
            System.out.println("등록된 사용자가 존재하지 않습니다.");
        }
    }
}
