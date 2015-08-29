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
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Sanket K
 * @param <E>
 */
public abstract class BasicLinkedList<E> implements Collection<E> {
    
    public abstract int insertAfter(E ref, E data);
    
    public abstract int insertBefore(E ref, E data);
    
    public abstract E getHead();
    
    public abstract E removeHead();
    
    public abstract E getTail();
    
    public abstract E removeTail();
    
    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }
    
    public abstract ListIterator<E> listIterator();
    
    public abstract BasicLinkedList<E> getReverseList();
    
    @Override
    public abstract String toString();
}