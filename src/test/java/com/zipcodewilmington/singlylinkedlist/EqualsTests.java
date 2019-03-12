package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EqualsTests {
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
    public void testEqualsNotRightClass() {
        //Given

        //When
        boolean actual = testList.equals(new Object());

        //Then
        Assert.assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentSize() {
        //Given
        SinglyLinkedList<Integer> testList2 = new SinglyLinkedList<>();
        testList2.add(12);
        //When
        boolean actual = testList.equals(testList2);

        //Then
        Assert.assertFalse(actual);
    }

    @Test
    public void testEqualsTrue() {
        //Given
        SinglyLinkedList<Integer> testList2 = new SinglyLinkedList<>();
        testList2.add(12);
        testList.add(12);
        //When
        boolean actual = testList.equals(testList2);

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testEqualsFalseDifferentOrder0() {
        //Given
        SinglyLinkedList<Integer> testList2 = new SinglyLinkedList<>();
        testList2.add(12);
        testList2.add(1);
        testList.add(1);
        testList.add(12);

        //When
        boolean actual = testList.equals(testList2);

        //Then
        Assert.assertFalse(actual);
    }

    @Test
    public void testEqualsFalseDifferentOrder() {
        //Given
        SinglyLinkedList<Integer> testList2 = new SinglyLinkedList<>();
        for (int i = 0; i < 234; i++) {
            testList2.add(i);
        }
        for (int i = 233; i >= 0; i--) {
            testList.add(i);
        }
        //When
        boolean actual = testList.equals(testList2);

        //Then
        Assert.assertFalse(actual);
    }

    @Test
    public void testEqualsFalseDifferentOrderAndValues() {
        //Given
        SinglyLinkedList<Integer> testList2 = new SinglyLinkedList<>();
        for (int i = 0; i < 234; i++) {
            testList2.add(i);
        }
        for (int i = 234; i >= 1; i--) {
            testList.add(i);
        };
        //When
        boolean actual = testList.equals(testList2);

        //Then
        Assert.assertFalse(actual);
    }
}
