package com.derbysoft.interview.exercises;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RandomCollectionFunctionsTest {
    RandomCollectionFunctions randomCollectionFunctions;
    private int positiveSum = 0;
    @Before
    public void setUp() throws Exception {
        randomCollectionFunctions = new RandomCollectionFunctions(-50, 50);
        positiveSum = (50 * 51)/2;
    }

    @Test
    public void findSmallest() {
        assertNotNull(randomCollectionFunctions.getIntegers());
        int smallest = randomCollectionFunctions.findSmallest();
        if( smallest < 0)
            assertTrue("Is not smallest", smallest >= -50);
        assertTrue("Is not smallest", smallest < 50);
    }

    @Test
    public void findSum() {
        assertNotNull(randomCollectionFunctions.getIntegers());
        assertTrue(randomCollectionFunctions.findSum() <= positiveSum);
    }

    @Test
    public void sort() {
        List<Integer> integerList = randomCollectionFunctions.getIntegers();
        assertNotNull(integerList);
        assertTrue(integerList.size() > 0);
        assertTrue("failed to sort", randomCollectionFunctions.sort().get(0) <=  randomCollectionFunctions.sort().get(integerList.size()-1));
    }

    @Test
    public void filterPositive() {
        assertNotNull(randomCollectionFunctions.getIntegers());
        randomCollectionFunctions.filterPositive().forEach(i -> assertTrue("Is not positive",  i>=0));
    }

    @Test
    public void everyFourthEntry() {
        assertNotNull(randomCollectionFunctions.getIntegers());
        assert(randomCollectionFunctions.everyFourthEntry() >= -50 && randomCollectionFunctions.everyFourthEntry() <= 50);
    }
}