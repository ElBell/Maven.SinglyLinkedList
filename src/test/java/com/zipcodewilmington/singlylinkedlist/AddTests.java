package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddTests {
    private SinglyLinkedList<Integer> testList;
    @Before
    public void setUp() {
        testList = new SinglyLinkedList<>();
    }

    @After
    public void tearDown() {
        testList.clear();
    }

    @Test
    public void testAdd() {
        //Given
        Integer expected = 146;

        //When
        testList.add(expected);

        //Then
        Integer actual = testList.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddAdd() {
        //Given
        Integer expected = 146;
        Integer expected2 = 1938;

        //When
        testList.add(expected);
        testList.add(expected2);

        //Then
        Integer actual = testList.get(0);
        Integer actual2 = testList.get(testList.size() - 1);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testAddAddAdd() {
        //Given
        Integer expected = 146;
        Integer expected2 = 1938;

        //When
        testList.add(expected);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(expected2);

        //Then
        Integer actual = testList.get(0);
        Integer actual2 = testList.get(testList.size() - 1);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testAddAtIndex() {
        //Given
        Integer expected = 146;

        //When
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(expected, 4);

        //Then
        Integer actual = testList.get(4);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexOutOfBounds() {
        //Given
        Integer expected = 146;

        //When
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(123);
        testList.add(expected, 44);

        //Then
        //ExceptionIsThrown
    }
}
