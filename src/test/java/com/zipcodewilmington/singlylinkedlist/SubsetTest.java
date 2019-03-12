package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubsetTest {
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
    public void testSubset1() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        expected.add(1);
        for (int i = 0; i < 4; i++) {
            testList.add(i);
        }
        //When
        SinglyLinkedList<Integer> actual = testList.subset(1, 2);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSubset2() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        expected.add(1);
        expected.add(2);
        for (int i = 0; i < 4; i++) {
            testList.add(i);
        }
        //When
        SinglyLinkedList<Integer> actual = testList.subset(1, 3);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSubsetFirst() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        for (int i = 0; i < 4; i++) {
            testList.add(i);
        }
        //When
        SinglyLinkedList<Integer> actual = testList.subset(0, 3);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSubset3() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        expected.add(10);
        expected.add(11);
        expected.add(12);
        expected.add(13);
        for (int i = 0; i < 20; i++) {
            testList.add(i);
        }
        //When
        SinglyLinkedList<Integer> actual = testList.subset(10, 14);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSubsetException() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        expected.add(10);
        expected.add(11);
        expected.add(12);
        expected.add(13);
        for (int i = 0; i < 20; i++) {
            testList.add(i);
        }
        //When
        SinglyLinkedList<Integer> actual = testList.subset(10, 20);
        //Then
        //ExceptionThrown
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSubsetException2() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        expected.add(10);
        expected.add(11);
        expected.add(12);
        expected.add(13);
        for (int i = 0; i < 20; i++) {
            testList.add(i);
        }
        //When
        SinglyLinkedList<Integer> actual = testList.subset(-1, 10);
        //Then
        //ExceptionThrown
    }
}
