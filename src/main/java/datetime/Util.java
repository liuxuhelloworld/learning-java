package datetime;

import java.time.LocalDate;

public class Util {
    public static void printCurrentMonthCalendar() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        date = date.minusDays(today - 1);
        int n = date.getDayOfWeek().getValue();
        for (int i = 1; i < n; i++) {
            System.out.print("    ");
        }

        for (; date.getMonthValue() == month; date = date.plusDays(1)) {
            System.out.printf("%3d", date.getDayOfMonth());

            if (date.getDayOfMonth() != today) {
                System.out.print(" ");
            } else {
                System.out.print("*");
            }

            if (date.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        printCurrentMonthCalendar();
    }
}
