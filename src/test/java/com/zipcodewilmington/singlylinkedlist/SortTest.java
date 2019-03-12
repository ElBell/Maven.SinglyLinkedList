package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortTest {
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
    public void testSortNothing() {
        //Given
        SinglyLinkedList before = testList.clone();
        //When
        testList.sort();

        SinglyLinkedList after = testList.clone();
        //Then
        Assert.assertEquals(before, after);
    }

    @Test
    public void testSortTwoThings() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        expected.add(1);
        expected.add(2);
        testList.add(2);
        testList.add(1);
        //When
        testList.sort();

        SinglyLinkedList after = testList.clone();
        //Then
        Assert.assertEquals(expected, after);
    }

    @Test
    public void testSortManyThingsRandom() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(3);
        testList.add(3);
        testList.add(2);
        testList.add(3);
        testList.add(1);
        SinglyLinkedList before = testList.clone();
        //When
        testList.sort();

        SinglyLinkedList after = testList.clone();

        //Then
        Assert.assertEquals(expected, after);
        Assert.assertNotEquals(expected, before);
    }

    @Test
    public void testSortManyThingsReverseOrder() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        for (int i = 0; i < 200; i++) {
            expected.add(i);
        }
        for (int i = 199; i >= 0; i--) {
            testList.add(i);
        }
        SinglyLinkedList before = testList.clone();
        //When
        testList.sort();

        SinglyLinkedList after = testList.clone();

        //Then
        Assert.assertEquals(expected, after);
        Assert.assertNotEquals(expected, before);
    }

    @Test
    public void testSortSameOrder() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        for (int i = 0; i < 200; i++) {
            testList.add(i);
            expected.add(i);
        }
        SinglyLinkedList before = testList.clone();
        //When
        testList.sort();

        SinglyLinkedList after = testList.clone();

        //Then
        Assert.assertEquals(expected, after);
        Assert.assertEquals(expected, before);
    }
}
