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
public class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;
    
    public Node(E data){
        this.data = data;
        next = prev = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
    
    @Override
    public String toString(){
        return data.toString();
    }
}
