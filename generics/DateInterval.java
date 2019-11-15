package generics;

import java.time.LocalDate;

public class DateInterval extends Pair<LocalDate> {

    public DateInterval(LocalDate first, LocalDate second) {
        super(first, second);
    }

    public LocalDate getSecond() {
        return (LocalDate)super.getSecond();
    }

    public void setSecond(LocalDate second) {
        if (second.compareTo(getFirst()) >= 0) {
            super.setSecond(second);
        }
    }

    public static void main(String[] args) {
        LocalDate first = LocalDate.of(2019, 1, 1);
        LocalDate second = LocalDate.of(2020, 1, 1);
        DateInterval interval = new DateInterval(first, second);
        interval.setSecond(LocalDate.of(2021, 1,1));

        Pair<LocalDate> pair = interval;
        pair.setSecond(LocalDate.of(2018, 1,1));
    }
}
