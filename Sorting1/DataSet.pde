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
  Element [] data = new Element[4];
  
  public DataSet() {
    data[0] = new Element(12);
    data[1] = new Element(45); 
    data[2] = new Element(5); 
    data[3] = new Element(543); 
    
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
  
  /*
  * Magical sorting algorithm
  */
  public void sort(/*Algorithm a*/) {
    // test swapping elements visually first
    // TODO - not actually swapped in the arraylist yet
    /*int x1 = data[0].getX();
    int x2 = data[3].getX();
    int y1 = data[0].getY();
    int y2 = data[3].getY();
    
    println("Try to update 0" + data[0].updatePosition(x2, y2));
    println("Try to update 2" + data[3].updatePosition(x1, y1));
    
    int x3 = data[1].getX();
    int x4 = data[2].getX();
    int y3 = data[1].getY();
    int y4 = data[2].getY();
    
    println("Try to update 0" + data[1].updatePosition(x3, y3));
    println("Try to update 2" + data[2].updatePosition(x4, y4));*/
    
    insertionSort(data);
    
  }
  
  private void insertionSort(Element[] d) {
    for (int i = 1; i < d.length ; i++) {
            int j = i;
            Element testElem = d[i];
            print("Testing " + testvar + ": ");
            //dumpState(j, mylist);
            while (j > 0 && (d[j-1].getValue() > testElem.getValue()) ) {
                System.out.println(d[j-1].getValue() + " > " + testElem.getValue());
                d[j] = d[j-1];
                //unsorted.set(j-1,0);
                j = j-1;
                
                //dumpState(testvar, data);
            }
            d[j] = testElem;
            
            // animate the swap ?
            swap(d[i], d[j]);
        }
  }
  
  /*
  * In this method we want to swap a and b
  * and show a sweet animation to boot   
  */
  private void swap(Element a, Element b) {
    int x1 = a.getX(), y1 = a.getY(), x2 = a.get();
    
  }
  
  public void update() {
    for(Element e: data) {
      e.update();
    }
  }
}