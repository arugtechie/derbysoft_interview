package com.derbysoft.interview.codereview;

import com.derbysoft.interview.HotelNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
//import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class HotelUtils {

  private static Logger LOG = LoggerFactory.getLogger(HotelUtils.class);

  public List<String> hotelNameList(ArrayList<Hotel> hotels) {
    return hotels.stream().map(Hotel::getName).collect(Collectors.toList());
  }

  public Hotel findHotel(ArrayList<Hotel> hotels, String name) throws HotelNotFoundException {
    Optional<Hotel> hotel = hotels.stream().filter(h -> h.getName().equals(name)).findFirst();
    if(hotel.isPresent())
      return hotels.stream().filter(h -> h.getName().equals(name)).findFirst().get();
    else
      throw new HotelNotFoundException("Not Found");
  }

  /**
   * prints the num of adults as text out to the logger
   *
   * @param numAdults - the number of adults
   */
  public void printAdultInfo(final Integer numAdults) {
    switch (numAdults) {
      case 0:
        LOG.debug("Zero");
        break;
      case 1:
        LOG.debug("One");
        break;
      case 2:
        LOG.debug("Two");
        break;
      default:
        LOG.debug("Default");
    }
  }

  public List<Hotel> filterHotels(ArrayList<Hotel> hotels, int maxAdultCount) {
/*    CopyOnWriteArrayList<Hotel> hotelCopyOnWriteArrayList = new  CopyOnWriteArrayList<Hotel>(hotels);
    for (Hotel hotel : hotelCopyOnWriteArrayList) {
        if (hotel.getNumAdults() > maxAdultCount) {
          hotels.remove(hotel);
        }
    }*/
    Iterator<Hotel> itr = hotels.iterator();
    while (itr.hasNext()) {
      if (itr.next().getNumAdults() > maxAdultCount) {
        // will not throw Exception
        itr.remove();
      }
    }
    return hotels;
  }

  public boolean hotelsEqual(Hotel h1, Hotel h2) {
      return h1.equals(h2);
  }
}
