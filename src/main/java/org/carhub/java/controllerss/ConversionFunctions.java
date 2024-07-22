package org.carhub.java.controllerss;

import java.time.LocalDate;

public class ConversionFunctions {

    public static java.sql.Date toSqlDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }
}
