/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quickfind1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author sanket
 */
public class NewEmptyTestNGTest {
    
    public NewEmptyTestNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testinit() {
        HashSet<Pair> myset = new HashSet<>();
        myset.add(new Pair(11,8));
        myset.add(new Pair(0,2));
        myset.add(new Pair(7,9));
        
        System.out.println(myset.toString());
        QuickFind1 o = new QuickFind1();
                        
        assert(myset != null);
        assert(o.getN(myset) == 12);       
    }
    
    @Test
    public void testsimple() {
        System.out.println("testsimple");
        HashSet<Pair> myset = new HashSet<>();
        myset.add(new Pair(11,8));
        myset.add(new Pair(0,2));
        myset.add(new Pair(7,9));
        
        System.out.println(myset.toString());
        QuickFind1 o = new QuickFind1();
          
        
        int[] expected = {2, 1, 2, 3, 4, 5, 6, 9, 8, 9, 10, 8};
        assert(Arrays.equals(expected, o.simple(myset)));
    }
    
    @Test
    public void testsimple2() {
        System.out.println("testsimple2");
        HashSet<Pair> myset = new HashSet<>();
        myset.add(new Pair(11,8));
        myset.add(new Pair(0,2));
        myset.add(new Pair(7,0));
        myset.add(new Pair(7,2));
        myset.add(new Pair(2,11));
        
        
        System.out.println(myset.toString());
        QuickFind1 o = new QuickFind1();
                        
        
        int[] expected = {2, 1, 2, 3, 4, 5, 6, 9, 8, 9, 10, 8};
        assert(Arrays.equals(expected, o.simple(myset)));
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
}
