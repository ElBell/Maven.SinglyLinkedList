package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CloneTest {
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
    public void testCloneEmpty() {
        //Given

        //When
        SinglyLinkedList actual = testList.clone();

        //Then
        Assert.assertEquals(testList, actual);
    }

    @Test
    public void testClone() {
        //Given
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        int expectedSize = 10;

        //When
        SinglyLinkedList actual = testList.clone();
        int actualSize = actual.size();

        //Then
        Assert.assertEquals(testList, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testClone2() {
        //Given
        for (int i = 0; i < 1000; i++) {
            testList.add(i);
        }
        int expectedSize = 1000;

        //When
        SinglyLinkedList actual = testList.clone();
        int actualSize = actual.size();

        //Then
        Assert.assertEquals(testList, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

}
