package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseTest {

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
    public void testReverseNothin() {
        //Given
        SinglyLinkedList before = testList.clone();

        //When
        testList.reverse();
        SinglyLinkedList after = testList.clone();

        //Then
        Assert.assertEquals(before, after);
    }

    @Test
    public void testReverseOneThing() {
        //Given
        testList.add(1);
        SinglyLinkedList before = testList.clone();

        //When
        testList.reverse();
        SinglyLinkedList after = testList.clone();

        //Then
        Assert.assertEquals(before, after);
    }

    @Test
    public void testReverseTwoThings() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        expected.add(2);
        expected.add(1);
        testList.add(1);
        testList.add(2);

        //When
        testList.reverse();
        SinglyLinkedList actual = testList.clone();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverseSomeThingsRandomOrder() {
        //Given
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
        expected.add(5);
        expected.add(2);
        expected.add(3);
        expected.add(1);
        testList.add(1);
        testList.add(3);
        testList.add(2);
        testList.add(5);

        //When
        testList.reverse();
        SinglyLinkedList actual = testList.clone();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverseManyThings() {
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
        testList.reverse();

        SinglyLinkedList after = testList.clone();

        //Then
        Assert.assertEquals(expected, after);
        Assert.assertNotEquals(expected, before);
    }
}
