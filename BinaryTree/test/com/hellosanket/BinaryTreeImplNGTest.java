/*
 * The MIT License
 *
 * Copyright 2015 Sanket K<hckrtst@gmail.com>.
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

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Sanket K<hckrtst@gmail.com>
 */
public class BinaryTreeImplNGTest {
    
    public BinaryTreeImplNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of insert method, of class BinaryTreeImpl.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Object key = null;
        Object payload = null;
        BinaryTreeImpl instance = new BinaryTreeImpl();
        boolean expResult = false;
        boolean result = instance.insert(key, payload);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInorderSuccessor method, of class BinaryTreeImpl.
     */
    @Test
    public void testGetInorderSuccessor() {
        System.out.println("getInorderSuccessor");
        Object key = null;
        BinaryTreeImpl instance = new BinaryTreeImpl();
        Node expResult = null;
        Node result = instance.getInorderSuccessor(key);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inorderTraversal method, of class BinaryTreeImpl.
     */
    @Test
    public void testInorderTraversal() {
        System.out.println("inorderTraversal");
        Object key = null;
        BinaryTreeImpl instance = new BinaryTreeImpl();
        instance.inorderTraversal(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class BinaryTreeImpl.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object key = null;
        BinaryTreeImpl instance = new BinaryTreeImpl();
        boolean expResult = false;
        boolean result = instance.remove(key);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
