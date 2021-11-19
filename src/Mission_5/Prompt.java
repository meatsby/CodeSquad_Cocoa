package Mission_5;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Prompt {

    public Scanner s = new Scanner(System.in);
    public Calendar cal = new Calendar();
    public KoreanClock kc = new KoreanClock();
    public LocalDateTime now = LocalDateTime.now();

    public static final String ANSI = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public int year = now.getYear();
    public int month = now.getMonthValue();
    public int day = now.getDayOfMonth();

    public int hour = now.getHour();
    public int minute = now.getMinute();

    private void runPrompt() {
        while (true) {
            System.out.print("> ");
            String cmd = s.nextLine();

            if (cmd.equals("clock")) {
                kc.printClock(ANSI, ANSI_RESET, hour, minute);
            } else if (cmd.equals("cal")) {
                cal.printCalendar(ANSI, ANSI_RESET, year, month, day);
            } else if (cmd.equals("q")) {
                return;
            } else {
                int year = Integer.parseInt(cmd.split(" ")[1]);
                int month = Integer.parseInt(cmd.split(" ")[2]);
                cal.printCalendar(ANSI, ANSI_RESET, year, month, 0);
            }
        }
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
