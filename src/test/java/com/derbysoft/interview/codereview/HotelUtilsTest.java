package com.derbysoft.interview.codereview;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HotelUtilsTest {

    private HotelUtils hotelUtils;
    private ArrayList<Hotel> hotels;

    @Before
    public void setUp() throws Exception {
        hotelUtils = new HotelUtils();
        hotels = new ArrayList<>();
        for(int i=0; i< 5; i++) {
            Hotel hotel = new Hotel();
            if(i == 1)
            hotel.setNumAdults(5);
            else
                hotel.setNumAdults(4);
            hotels.add(hotel);
        }
    }

    @Test
    public void hotelNameList() {
    }

    @Test
    public void findHotel() {

    }

    @Test
    public void printAdultInfo() {
        hotelUtils.printAdultInfo(5);
    }

    @Test
    public void filterHotels() {
        hotelUtils.filterHotels(hotels, 6);
        assertEquals("", 5, hotels.size());
    }

    @Test
    public void hotelsEqual() {
    }

}