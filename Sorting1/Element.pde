/* 
* Represents each element of the data set 
*/
class Element {
  private int value;
  private int x ,y = 0;
  
  public Element(int val) {
     value = val;
  }
  
  public void updatePosition(int x, int y) {
    fill(55, 77, 96);
    text("Manasi", 60, 60);
  }
  
  public void display() {
  }
  
  public void moveToPosition(int pos) {    
  }
}