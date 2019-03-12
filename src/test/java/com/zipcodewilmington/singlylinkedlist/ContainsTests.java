package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContainsTests {
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
    public void testContainsTrue() {
        //Given
        testList.add(12);

        //When
        boolean actual = testList.contains(12);

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testContains2() {
        //Given
        for (int i = 0; i < 212; i++) {
            testList.add(i);
        }

        //When
        boolean actual = testList.contains(34);
        boolean actual2 = testList.contains(45);

        //Then
        Assert.assertTrue(actual && actual2);
    }


    @Test
    public void testContainsFalse() {
        //Given
        for (int i = 0; i < 212; i++) {
            testList.add(i);
        }

        //When
        boolean actual = testList.contains(234);

        //Then
        Assert.assertFalse(actual);
    }

    @Test
    public void testBeforeAndAfter() {
        //Given
        for (int i = 0; i < 212; i++) {
            testList.add(i);
        }

        //When
        boolean before = testList.contains(23);
        testList.remove(23);
        boolean after = testList.contains(23);

        //Then
        Assert.assertFalse(after);
        Assert.assertTrue(before);
    }
}
