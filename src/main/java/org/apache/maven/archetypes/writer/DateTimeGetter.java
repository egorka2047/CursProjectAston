package org.apache.maven.archetypes.writer;

/**Позволяет получить текущее время и дату системы в удобдном для печати виде**/

public final class DateTimeGetter {

    public static String getDataTime(){
        String[] localDateTime = java.time.LocalDateTime.now().toString().split("T");
        String date = localDateTime[0];
        String time = localDateTime[1].split("\\.")[0];
        return date + " " + time;
    }
}
