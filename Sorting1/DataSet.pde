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
    sort();    
  }
  
  public void display() {
    for (Element e: data) {
      e.display();
    }
  }
  
  public void sort(/*Algorithm a*/) {
    // test swapping elements visually first
    // TODO - not actually swapped in the arraylist yet
    int x1 = data.get(0).getX();
    int x2 = data.get(3).getX();
    int y1 = data.get(0).getY();
    int y2 = data.get(3).getY();
    
    println("Try to update 0" + data.get(0).updatePosition(x2, y2));
    println("Try to update 2" + data.get(3).updatePosition(x1, y1));
    
    int x3 = data.get(1).getX();
    int x4 = data.get(2).getX();
    int y3 = data.get(1).getY();
    int y4 = data.get(2).getY();
    
    println("Try to update 0" + data.get(1).updatePosition(x3, y3));
    println("Try to update 2" + data.get(2).updatePosition(x4, y4));
  }
  
  public void update() {
    for(Element e: data) {
      e.update();
    }
  }
}