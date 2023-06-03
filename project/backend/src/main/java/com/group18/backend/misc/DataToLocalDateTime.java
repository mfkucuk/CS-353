package com.group18.backend.misc;

import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;

public class DataToLocalDateTime {
    public static LocalDateTime Convert(Date date) {
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp.toLocalDateTime();
    }
}
