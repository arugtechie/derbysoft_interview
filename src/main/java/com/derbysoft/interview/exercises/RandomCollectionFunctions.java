package com.derbysoft.interview.exercises;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Code Test
 */
public class RandomCollectionFunctions {

  private int min = -50;
  private int max = 50;
  private List<Integer>  integers = new ArrayList<>();;

  public List<Integer> getIntegers() {
    return integers;
  }

  public void setIntegers(List<Integer> integers) {
    this.integers = integers;
  }
  //  Create a class that has the following features:
//
//
//  On creation it creates a collection of 100 random integers that are both positive and negative
//  Add functions that will return the following using core Java as well as lambdas
//  1.) The smallest value in the data set
//  2.) The sum of the data set
//  3.) The data set sorted from smallest to largest
//  4.) The data set filtered to only have positive data
//  5.) Remove every 4th entry from the data set
//  Add unit tests to prove that your code works

  public RandomCollectionFunctions(int min, int max) {
    if(min == 0 && max == 0)
      this.max = 1;
    this.min = min;
    for(int i= 0; i< this.max-this.min; i++)
    {
      integers.add(new Random().nextInt(max- min + 1) + min);
    }
  }

  public int findSmallest() {
    if(Objects.nonNull(integers) && integers.size() > 0)
      return integers.stream().min(Comparator.comparingInt(Integer::intValue)).orElse(0);
    else return 0;
  }

  public int findSum() {
    if(Objects.nonNull(integers) && integers.size() > 0)
        return integers.stream().mapToInt(i -> i).sum();
    else return 0;
  }

  public List<Integer> sort() {
    if(Objects.nonNull(integers) && integers.size() > 0)
      return integers.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
    else return integers;
  }

  public List<Integer> filterPositive() {
    if(Objects.nonNull(integers) && integers.size() > 0)
      return integers.stream().filter(i -> i >= 0).collect(Collectors.toList());
    else return integers;
  }

  public int everyFourthEntry() {
    if(Objects.nonNull(integers) && integers.size() > 0 && integers.size() >=4 )
        return  integers.get(3);
    else return 0;
  }

  public static void main(String[] args) {
    RandomCollectionFunctions randomCollectionFunctions = new RandomCollectionFunctions(-50, 50);
    int positiveSum = (50 * 51)/2;

    randomCollectionFunctions = new RandomCollectionFunctions(-50, 50);
    positiveSum = (50 * 51)/2;

    //test smallest
    assertNotNull(randomCollectionFunctions.getIntegers());
    int smallest = randomCollectionFunctions.findSmallest();
    if( smallest < 0)
      assertTrue("Is not smallest", smallest >= -50);
    assertTrue("Is not smallest", smallest < 50);

    //test sum
    assertTrue(randomCollectionFunctions.findSum() <= positiveSum);

    //test sort
    List<Integer> integerList = randomCollectionFunctions.getIntegers();
    assertTrue(integerList.size() > 0);
    assertTrue("failed to sort", randomCollectionFunctions.sort().get(0) <=  randomCollectionFunctions.sort().get(integerList.size()-1));

    //test filterPositive
    randomCollectionFunctions.filterPositive().forEach(i -> assertTrue("Is not positive",  i>=0));

    //test everyFourthEntry
    assert(randomCollectionFunctions.everyFourthEntry() >= -50 && randomCollectionFunctions.everyFourthEntry() <= 50);
  }
}
