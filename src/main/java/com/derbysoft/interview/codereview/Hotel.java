package com.derbysoft.interview.codereview;

import java.util.Objects;

public class Hotel {

  private String name;
  private String description;
  private String hotel_id;
  private int numAdults = 0;

  public Hotel() {
    this.name = "";
    this.description = "";
    this.hotel_id= "";
  }

  public Hotel(String name, String description, String hotel_id, int numAdults) {
    this.name = name;
    this.description = description;
    this.hotel_id = hotel_id;
    this.numAdults = numAdults;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHotel_id() {
    return hotel_id;
  }

  public void setHotel_id(String hotel_id) {
    this.hotel_id = hotel_id;
  }

  public int getNumAdults() {
    return numAdults;
  }

  public void setNumAdults(int numAdults) {
    this.numAdults = numAdults;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Hotel hotel = (Hotel) o;
    return numAdults == hotel.numAdults &&
            Objects.equals(name, hotel.name) &&
            Objects.equals(description, hotel.description) &&
            Objects.equals(hotel_id, hotel.hotel_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, hotel_id, numAdults);
  }
}
