import java.util.*;

public enum Algorithm{
  INSERTION_SORT,
  QUICK_SORT
};

/* 
* Dataset contains several Elements.
* It manages each element
*/
class DataSet {
  List<Element> data;
  
  public DataSet() {
    data = new ArrayList<Element>();
    data.add(new Element(12));
    data.add(new Element(45));
    data.add(new Element(5));
    data.add(new Element(543));
    
    int i = 30;
    int j = 140;
    for (Element e: data) {
      e.initPosition(i, j);
      i = i + 45;
      if (e.getState() == ElementState.ELEM_AT_REST) {
        println("at rest");
      }
    }
    
  }
  
  public void display() {
    for (Element e: data) {
      e.display();
    }
  }
  
  public void sort(Algorithm a) {
    
  }
}