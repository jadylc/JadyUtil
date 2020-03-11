package jady.test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author liuhan
 * @date 2020/03/11
 */
public class TimeTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2020,2,29);
        MonthDay monthDay = MonthDay.from(today);
        LocalTime time = LocalTime.now();
        Instant instant = Instant.now();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("今天的日期:"+dateTime.format(format1));
    }
}
