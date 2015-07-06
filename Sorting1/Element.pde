/* An Element is either at rest or
* hussling to another position
*/
public enum ElementState {
  ELEM_AT_REST,
  ELEM_HUSSLE
};

/* 
* Represents each element of the data set 
*/
class Element {
  private Integer value;
  // each element stores its own current position
  private int x = 0,y = 0;
  ElementState state = ElementState.ELEM_AT_REST;
  
  /* Public Methods */ 
  public Element(int val) {
     // use autoboxing here
     value = val;
     
     /*@Override
     public String toString() {
       return "fake val";
     }*/
  }
  
  public boolean updatePosition(int x, int y) {
    
    //text("Manasi", 60, 60);
    // if we are at rest, and not already at desired position 
    // start moving to new position
    
    // if we are already moving retun error and keep going
    return false;
  }
  
  
  public void display() {
    text(value.toString(), x, y);
  }
  
  ElementState getState() {
    return state;
  }
  
  public void initPosition(int _x , int _y) {
    x = _x;
    y = _y;
  }
  
  /* private methods */
  private void startMigrationTo(int x, int y) {    
  }
  
  private void stop() {
  }
  
  private void update() {
  
  }
  
  
}