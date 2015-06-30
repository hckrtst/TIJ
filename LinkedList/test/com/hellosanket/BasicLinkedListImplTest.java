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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sanket K
 */
public class BasicLinkedListImplTest {
    
        
    public BasicLinkedListImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertAfter method, of class BasicLinkedListImpl.
     */
    @Test
    public void testInsertAfter() {
        System.out.println("insertAfter");
        /*
        Object elem = null;
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        int expResult = 0;
        int result = instance.insertAfter(elem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.*/
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertBefore method, of class BasicLinkedListImpl.
     */
    @Test
    public void testInsertBefore() {
        System.out.println("insertBefore");
        /*Object elem = null;
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        int expResult = 0;
        int result = instance.insertBefore(elem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.*/
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHead method, of class BasicLinkedListImpl.
     */
    @Test
    public void testGetHead() {
        System.out.println("getHead");
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        Object expResult = null;
        Object result = instance.getHead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeHead method, of class BasicLinkedListImpl.
     */
    @Test
    public void testRemoveHead() {
        System.out.println("removeHead");
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        int expResult = 30;
        
        instance.add(10);
        instance.add(20);
        instance.add(30);
        int result = (int) instance.removeHead();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTail method, of class BasicLinkedListImpl.
     */
    @Test
    public void testGetTail() {
        System.out.println("getTail");
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        
        // Test with null list
        /*{
            Object expResult = null;        
            Object result = instance.getTail();
            assertEquals(expResult, result);
        }*/
        
        // Test with data
        {
            String expResult = "hello";        
            instance.add("hello");
            String result = (String) instance.getTail();
            assertEquals(expResult, result);
            
            instance.add("kitty");
            result = (String) instance.getTail();
            assertEquals(expResult, result);
        }
        
    }

    /**
     * Test of removeTail method, of class BasicLinkedListImpl.
     */
    @Test
    public void testRemoveTail() {
        System.out.println("removeTail");
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        int expResult = 10;
        
        instance.add(10);
        instance.add(20);
        instance.add(30);
        int result = (int) instance.removeTail();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of size method, of class BasicLinkedListImpl.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        
        // test size 0
        {
            int expResult = 0;
            int result = instance.size();
            assertEquals(expResult, result);
        }
        
        //test size 2
        {
            instance.add(10);
            instance.add("test");
            int expResult = 2;
            int result = instance.size();
            assertEquals(expResult, result);
        }        
    }

    /**
     * Test of isEmpty method, of class BasicLinkedListImpl.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);        
    }

    /**
     * Test of contains method, of class BasicLinkedListImpl.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object o = null;
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        boolean expResult = false;
        boolean result = instance.contains(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class BasicLinkedListImpl.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class BasicLinkedListImpl.
     */
    @Test
    public void testToArray_0args() {
        System.out.println("toArray");
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class BasicLinkedListImpl.
     */
    @Test
    public void testToArray_GenericType() {
        System.out.println("toArray");
        Object[] a = null;
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        Object[] expResult = null;
        Object[] result = instance.toArray(a);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class BasicLinkedListImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        boolean expResult = true;
        int i = 20;
        boolean result = instance.add(i);
        assertEquals(expResult, result);
        int j = 30;
        result = instance.add(j);
        assertEquals(expResult, result);        
    }

    /**
     * Test of remove method, of class BasicLinkedListImpl.
     * TODO 
     * - move this to testRemoveTail()
     * - also check Tail gets updated correctly
     * 
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object o = null;
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        boolean expResult = true;
        int i = 20;
        boolean result = instance.add(i);
        assertEquals(expResult, result);
        int j = 30;
        result = instance.add(j);
        result = instance.remove(20);
        assertEquals(expResult, result);
        //assertEquals(30, instance.getTail());       
    }

    /**
     * Test of containsAll method, of class BasicLinkedListImpl.
     */
    @Test
    public void testContainsAll() {
        System.out.println("containsAll");
        Collection c = null;
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        boolean expResult = false;
        boolean result = instance.containsAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class BasicLinkedListImpl.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        Collection c = null;
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        boolean expResult = false;
        boolean result = instance.addAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class BasicLinkedListImpl.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        Collection c = null;
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        boolean expResult = false;
        boolean result = instance.removeAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retainAll method, of class BasicLinkedListImpl.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        Collection c = null;
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        boolean expResult = false;
        boolean result = instance.retainAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class BasicLinkedListImpl.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        BasicLinkedListImpl instance = new BasicLinkedListImpl();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }   
}
