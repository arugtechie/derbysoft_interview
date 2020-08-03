package com.derbysoft.interview.codereview;

import com.derbysoft.interview.HotelNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Hotel DAO
 */
public class HotelDAO {

  public final static String sql = "SELECT * FROM hotel";
  public HotelDAO()
  {

  }
  private Connection getConnection() {
    // assume this returns a valid connection
    return null;
  }

  public List<Hotel> findHotels() throws HotelNotFoundException {
    Connection conn = getConnection();
    try {
      List<Hotel> hotels = new ArrayList<>();
      Statement statement = conn.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      while (null!= resultSet && resultSet.next()) {
        Hotel hotel = new Hotel(resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getString("hotel_id"), resultSet.getInt("num_adults")) ;
        hotels.add(hotel);
      }
      return hotels;
    } catch (SQLException e) {
      throw new HotelNotFoundException("Hotels not found", e);
    }finally
    {
      try {
        conn.close();
      } catch (SQLException e) {
        throw new HotelNotFoundException("Hotels not found", e);
      }
    }
  }

}
