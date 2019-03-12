package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetTests {
    private SinglyLinkedList<Integer> testList;
    @Before
    public void setUp() {
        testList = new SinglyLinkedList<>();
    }

    @After
    public void tearDown() {
        testList.clear();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithNothingAdded() {
        //Given
        Integer expected = null;

        //When
        testList.get(0);
    }

    @Test
    public void testGetWithThingAdded() {
        //Given
        Integer expected = 12312;

        //When
        testList.add(expected);

        //Then
        Integer actual = testList.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetWithThingAdded2() {
        //Given
        Integer expected = 12312;

        //When
        for (int i = 0; i < 13; i++) {
            testList.add(i);
        }
        testList.add(expected);

        //Then
        Integer actual = testList.get(13);
        Assert.assertEquals(expected, actual);
    }
}
