package jady.test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        LocalDateTime start = LocalDateTime.of(LocalDate.now().minusDays(1),LocalTime.of(14,0));
        LocalDateTime end = LocalDateTime.of(LocalDate.now(),LocalTime.of(14,0));
        Instant starts = start.atZone(ZoneId.systemDefault()).toInstant();
        Date statt = Date.from(starts);
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("今天的日期:"+dateTime.format(format1));
    }
}
