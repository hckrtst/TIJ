/*
 * The MIT License
 *
 * Copyright 2015 Sanket K.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.hellosanket;

import java.util.Collection;
import java.util.ListIterator;


public class BasicLinkedListImpl<E> extends BasicLinkedList<E> {
    
    // Java does not provide unsigned :(
    
    private int size = 0;

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    /*
        This is the class that stores the data and allows navigation to the
        next element in list
    */
    private static class Node<E> {
        E payload;
        Node<E> prev;
        Node<E> next;
        
        Node(Node<E> p, Node<E> n, E e) {
            prev = p;
            next = n;
            payload = e;
        }
    }
    
    
    Node<E> head;
    Node<E> tail;

    @Override
    public int insertAfter(E ref, E data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertBefore(E ref, E data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getHead() {
        return head.payload;
    }

    @Override
    public E removeHead() {           
        if (this.isEmpty()) return null;
        
        Node<E> current = head;
        if (unlink(head.payload, head, head.prev, head.next)) {
            size--;
            return current.payload;
        }
        return null;       
    }

    @Override
    public E getTail() {
        return tail.payload;
    }

    @Override
    public E removeTail() {
        if (this.isEmpty()) return null;
        
        Node<E> current = tail;
        if (unlink(tail.payload, tail, tail.prev, tail.next)) {
            size--;
            return current.payload;
        }
        return null;       
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (0 == size);
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(E e) {
        if (null == e) {
            System.out.println("Bad paramater");
            return false;
        }
        
        Node<E> n = new Node<>(null, null, e);
        n.payload = e;
        
        // if empty set head and tail to be first element
        if (0 == size) {
            System.out.println("Adding first element");
            head = n;
            tail = n;            
        } else {
            System.out.println("Added to head");
            // add to head and update head
            n.next = head;
            n.prev = null; // TODO use sentinal?
            head = n;
            System.out.println("Head is now " + head);
        }
        size++;
        System.out.println("Size is now " + size);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (null == o) {
            System.out.println("Null paramater error");
            return false;
        }
        E elem = (E) o;
        
        System.out.println("Try to remove " + elem);
                
        // first iterate to the desired element
        // TODO should this throw any exceptions?
        Node<E> current = head;
        while(null != current) {
            if (elem == current.payload) {
                if (unlink(elem, current, current.prev, current.next)) {
                    size--;
                    return true;
                } else {
                    return false;
                }
                
            }
            current = current.next;
        }
                
        return false;
    }
    
    /*
    * Try to unlink an element from anywhere in the list
    */
    private boolean unlink(E elem, Node<E> curr, Node<E> prev, Node<E> next) {
        System.out.println("Unlink elem=" + elem);
        // prev or next may be null, but node should be non-null
        if (null == elem) {
            System.out.println("Null paramater error");
            return false;
        }
        
        // if unlinking head then
        // move head to next
        if (elem == head.payload) {            
            head = head.next;
            //System.out.println("Head is now " + head.payload);
            curr = null; // Check
            return true;
        }
        
        // if unlinking tail then make prev the
        // new tail
        else if (elem == tail.payload) {
            tail = tail.prev;
            //System.out.println("Tail is now " + tail.payload);
            curr = null;
            return true;
        }
        
        // in the default case
        // we are removing something from the middle of the list
        // we need to ensure the list stays intact
        prev.next = next;
        next.prev = prev;
        curr = null;
        return true;          
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
