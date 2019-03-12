package com.zipcodewilmington.singlylinkedlist;

import com.sun.tools.corba.se.idl.InvalidArgument;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Eleonor on 3/10/19.
 */
public class SinglyLinkedList<T extends Comparable> {
    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = new Node(null, null);
        size = 0;
    }

    public void add(T data) {
        getLastNode().next = new Node(data, null);
        size++;
    }

    public void add(T data, int index) {
        getNodeByIndex(index).next = new Node(data, getNodeByIndex(index).next);
        size++;
    }

    public T remove(int index) {
        T dataRemoved = getNodeByIndex(index + 1).data;
        getNodeByIndex(index).next = getNodeByIndex(index).next.next;
        return dataRemoved;
    }

    public boolean contains(T data) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
            if(current.data.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        return getNodeByIndex(index + 1).data;
    }

    public SinglyLinkedList<T> clone(){
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        for (int i = 0; i < size; i++) {
            newList.add(get(i));
        }
        return newList;
    }

    public void clear() {
            head.next = null;
    }

    public void sort() {
        Node sortedHead = null;
        Node current = head.next;
        while (current != null) {
            Node next = current.next;
            sortedHead = currentInsert(current, sortedHead);
            current = next;
        }
        head.next = sortedHead;
        }

    private Node currentInsert(Node nextNode, Node sortedHead) {
        if (sortedHead == null || sortedHead.data.compareTo(nextNode.data) > 0) {
            nextNode.next = sortedHead;
            sortedHead = nextNode;
        } else {
            Node current = sortedHead;
            while (current.next != null && current.next.data.compareTo(nextNode.data) < 0) {
                current = current.next;
            }
            nextNode.next = current.next;
            current.next = nextNode;
        }
        return sortedHead;
    }

    public void reverse() {
        Node previousNode = null;
        Node current = head.next;
        Node nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = previousNode;
            previousNode = current;
            current = nextNode;
        }
        head.next = previousNode;
    }

    public SinglyLinkedList<T> subset(int start, int end) {
        sizeCheck(end);
        sizeCheck(start - 1);
        SinglyLinkedList<T> answer = new SinglyLinkedList<>();
        for (int i = start; i < end; i++) {
            answer.add(get(i));
        }
        return answer;
    }

    public boolean equals(Object o) {
        if (!(o instanceof SinglyLinkedList) ) {
            return false;
        }
        SinglyLinkedList<T> other = (SinglyLinkedList<T>) o;
        if (other.size != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if(!(other.get(i).equals(get(i)))) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return size;
    }

    private Node getNodeByIndex(int index) {
        sizeCheck(index - 1);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void sizeCheck(int index) {
        if (index >= size || index < - 1) { throw new IndexOutOfBoundsException("Not a valid index"); }
    }

    private Node getLastNode() {
        return getNodeByIndex(size);
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
