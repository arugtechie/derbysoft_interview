package com.derbysoft.interview;

import java.sql.SQLException;

public class HotelNotFoundException extends Exception {
    public HotelNotFoundException(String message) {
        super(message);
    }
    public HotelNotFoundException(String message, SQLException e)
    {
        super(message);
    }
}
