package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoveTests {
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
    public void testRemove() {
        //Given
        Integer expected = 12312;

        //When
        testList.add(132);
        testList.add(expected);
        testList.remove(0);

        //Then
        Integer actual = testList.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemove2() {
        //Given
        Integer expected = 1324;
        testList.add(132);
        testList.add(132);
        testList.add(expected);
        testList.add(132);
        testList.add(132);

        //When
        Integer actual = testList.remove(2);

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertFalse(testList.contains(expected));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        //Given
        Integer expected = 12312;

        //When
        testList.add(132);
        testList.add(expected);
        testList.remove(123);

        //Then
        //Exception thrown
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveNothingAdded() {
        //Given

        //When
        testList.remove(0);

        //Then
        //Exception thrown
    }
}
