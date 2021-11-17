package Mission_5;

public class KoreanClock {

    public String[][] KoreanClock = {
            {"한", "두", "세", "네", "다", "섯"},
            {"여", "섯", "일", "곱", "여", "덟"},
            {"아", "홉", "열", "한", "두", "시"},
            {"자", "이", "삼", "사", "오", "십"},
            {"정", "일", "이", "삼", "사", "오"},
            {"오", "육", "칠", "팔", "구", "분"}
    };

    public Boolean[][] ClockLogic = {
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, true},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, true},
    };

    public void logic(int hour, int minute) {
        switch (hour%12) {
            case 0:
                if (minute == 0) {
                    ClockLogic[2][5] = false;
                    if (hour == 12) {
                        ClockLogic[4][0] = true;
                        ClockLogic[5][0] = true;
                        break;
                    }
                    ClockLogic[3][0] = true;
                    ClockLogic[4][0] = true;
                    break;
                }
                ClockLogic[2][2] = true;
                ClockLogic[2][4] = true;
                break;
            case 1:
                ClockLogic[0][0] = true;
                break;
            case 2:
                ClockLogic[0][1] = true;
                break;
            case 3:
                ClockLogic[0][2] = true;
                break;
            case 4:
                ClockLogic[0][3] = true;
                break;
            case 5:
                ClockLogic[0][4] = true;
                ClockLogic[0][5] = true;
                break;
            case 6:
                ClockLogic[1][0] = true;
                ClockLogic[1][1] = true;
                break;
            case 7:
                ClockLogic[1][2] = true;
                ClockLogic[1][3] = true;
                break;
            case 8:
                ClockLogic[1][4] = true;
                ClockLogic[1][5] = true;
                break;
            case 9:
                ClockLogic[2][0] = true;
                ClockLogic[2][1] = true;
                break;
            case 10:
                ClockLogic[2][2] = true;
                break;
            case 11:
                ClockLogic[2][2] = true;
                ClockLogic[2][3] = true;
                break;
        }

        switch (minute / 10) {
            case 0:
                ClockLogic[5][5] = false;
                break;
            case 1:
                ClockLogic[3][5] = true;
                break;
            case 2:
                ClockLogic[3][5] = true;
                ClockLogic[3][1] = true;
                break;
            case 3:
                ClockLogic[3][5] = true;
                ClockLogic[3][2] = true;
                break;
            case 4:
                ClockLogic[3][5] = true;
                ClockLogic[3][3] = true;
                break;
            case 5:
                ClockLogic[3][5] = true;
                ClockLogic[3][4] = true;
                break;
        }

        switch (minute % 10) {
            case 9:
                ClockLogic[5][4] = true;
                break;
            case 8:
                ClockLogic[5][3] = true;
                break;
            case 7:
                ClockLogic[5][2] = true;
                break;
            case 6:
                ClockLogic[5][1] = true;
                break;
            case 5:
                ClockLogic[4][5] = true;
                break;
            case 4:
                ClockLogic[4][4] = true;
                break;
            case 3:
                ClockLogic[4][3] = true;
                break;
            case 2:
                ClockLogic[4][2] = true;
                break;
            case 1:
                ClockLogic[4][1] = true;
                break;
        }
    }

    public void printClock(String ANSI, String ANSI_RESET, int hour, int minute) {
        logic(hour, minute);

        for (int i=0; i < 6; i++) {
            for (int j=0; j < 6; j++) {
                if (ClockLogic[i][j]) {
                    KoreanClock[i][j] = ANSI + KoreanClock[i][j] + ANSI_RESET;
                }
            }
        }

        for (int i=0; i < 6; i++) {
            for (int j=0; j < 6; j++) {
                System.out.print(KoreanClock[i][j] + " ");
            }
            System.out.println();
        }
    }
}
