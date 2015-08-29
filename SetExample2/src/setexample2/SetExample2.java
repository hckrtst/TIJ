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
package setexample2;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

class Province implements Comparable{
        long area;
        String name;
        
        Province(String n, long a) {
            area = a;
            name = n;
        }
        
        @Override
        public int compareTo(Object o) {
            
            Province other = (Province) o;
            
            System.out.println("Compare " + name + " with " + other.name);
            
            if ((name.equals(other.name)) && (area == other.area)) {
                System.out.println("Same names and areas");
                return 0;
            }
            
            // otherwise compare by area
            if (area > other.area) {
                System.out.println(other.name + " < " + name);
                return 1;
            } else if (area < other.area) {
                System.out.println(other.name +  " > " + name);
                return -1;
            }
            return 0;
        }
        
        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            
            s.append("(");
            s.append(name);
            s.append(",");
            s.append(area);
            s.append(")");
            
            return s.toString();
        }
    }

/**
 *
 * @author Sanket K
 */
public class SetExample2 {
    Set<Province> provinces = null;
        
    public SetExample2() {
        provinces = new TreeSet<>();
        provinces.add(new Province("British Columbia", 944735));
        provinces.add(new Province("Alberta", 642317));
        provinces.add(new Province("Ontario", 917741));
        provinces.add(new Province("Prince Edward Island", 5660));
        provinces.add(new Province("Yukon", 474391));
        provinces.add(new Province("Quebec", 1356128));        
    }    
    
    public void dumpSet() {
        System.out.println("Provinces:\n");
        System.out.println(provinces);
    }
    
    public TreeSet<Province> getSet() {
        return (TreeSet<Province>) provinces;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Create a set of Provinces");
        SetExample2 sets = new SetExample2();
        sets.dumpSet();
        
        System.out.println("");
        System.out.println("Checking how 'floor' and 'ceiling' works in sets");
        
        System.out.println(sets.getSet().floor(new Province("Nova Scotia", 53338)));
        
        System.out.println(sets.getSet().ceiling(new Province("Nova Scotia", 53338)));
        
        System.out.println("\nCreate subset using a fake province");
        NavigableSet subset;
        subset = sets.getSet().tailSet(new Province("Fake Province", 633233), true);
        System.out.println(subset);       
        
    }    
}
/*
run:
Create a set of Provinces
Compare British Columbia with British Columbia
Same names and areas
Compare Alberta with British Columbia
British Columbia > Alberta
Compare Ontario with British Columbia
British Columbia > Ontario
Compare Ontario with Alberta
Alberta < Ontario
Compare Prince Edward Island with Ontario
Ontario > Prince Edward Island
Compare Prince Edward Island with Alberta
Alberta > Prince Edward Island
Compare Yukon with Ontario
Ontario > Yukon
Compare Yukon with Alberta
Alberta > Yukon
Compare Yukon with Prince Edward Island
Prince Edward Island < Yukon
Compare Quebec with Ontario
Ontario < Quebec
Compare Quebec with British Columbia
British Columbia < Quebec
Provinces:

[(Prince Edward Island,5660), (Yukon,474391), (Alberta,642317), (Ontario,917741), (British Columbia,944735), (Quebec,1356128)]

Checking how 'floor' and 'ceiling' works in sets
Compare Nova Scotia with Ontario
Ontario > Nova Scotia
Compare Nova Scotia with Yukon
Yukon > Nova Scotia
Compare Nova Scotia with Prince Edward Island
Prince Edward Island < Nova Scotia
(Prince Edward Island,5660)
Compare Nova Scotia with Ontario
Ontario > Nova Scotia
Compare Nova Scotia with Yukon
Yukon > Nova Scotia
Compare Nova Scotia with Prince Edward Island
Prince Edward Island < Nova Scotia
(Yukon,474391)

Create subset using a fake province
Compare Fake Province with Fake Province
Same names and areas
Compare Fake Province with Ontario
Ontario > Fake Province
Compare Fake Province with Yukon
Yukon < Fake Province
Compare Fake Province with Alberta
Alberta > Fake Province
[(Alberta,642317), (Ontario,917741), (British Columbia,944735), (Quebec,1356128)]
*/