import java.util.*;

/* 
* Dataset contains several Elements
*/
class DataSet {
  List<Element> data;
  
  public DataSet() {
    data = new ArrayList<Element>();
    data.add(new Element(12));
    data.add(new Element(45));
    println(data);
    
    
  }
}