/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

/**
 *
 * @author dangp
 * @param <E>
 */
public class DoublyLinkedList<E> {

    Node<E> head;
    Node<E> tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Add element to the begin of the list
    public Node<E> addFirst(Node<E> newNode) {
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
        return newNode;
    }

    // Add node to the end of the list
    public Node<E> addLast(Node<E> newNode) {
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = null;
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        return newNode;
    }

    // Add node after a given node
    public Node<E> addAfter(Node<E> newNode, Node<E> p) {
        if (p == null || p == tail) {
            return addLast(newNode);
        }
        Node<E> pAfter = p.next;
        newNode.next = pAfter;
        newNode.prev = p;
        pAfter.prev = newNode;
        p.next = newNode;
        return newNode;
    }

    // Add node before a given node
    public Node<E> addBefore(Node<E> newNode, Node<E> p) {
        if (p == null || p == head) {
            return addFirst(newNode);
        }
        Node<E> pBefore = p.prev;
        newNode.next = p;
        newNode.prev = pBefore;
        pBefore.next = newNode;
        p.prev = newNode;
        return newNode;
    }

    public Node<E> removeFirst() {
        if (head == null) {
            return null;
        }
        Node<E> result = head;
        if (head == tail) {
            head = tail = null;
        } else {
            Node<E> newHead = head.next;
            newHead.prev = null;
            head = newHead;
        }
        return result;
    }

    public Node<E> removeLast() {
        if (tail == null) {
            return null;
        }
        Node<E> result = tail;
        if (tail == head) {
            head = tail = null;
        } else {
            Node<E> newTail = tail.prev;
            newTail.next = null;
            tail = newTail;
        }
        return result;
    }

    public Node<E> remove(Node<E> newNode) {
        if (newNode == null) {
            return null;
        }
        if (newNode == head) {
            return removeFirst();
        }
        if (newNode == tail) {
            return removeLast();
        }
        Node<E> pBefore = newNode.prev;
        Node<E> pAfter = newNode.next;
        pBefore.next = pAfter;
        pAfter.prev = pBefore;
        return newNode;
    }

    public void addFirst(E... group) {
        for (E data : group) {
            addFirst(new Node<E>(data));
        }
    }

    public void addLast(E... group) {
        for (E data : group) {
            addLast(new Node<E>(data));
        }
    }
}
