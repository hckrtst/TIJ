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
  private int deltaX = 0, deltaY = 0;
  private int x2 = 0, y2 = 0;
  private boolean selected = false;
  
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
  
  /* update the desired new position */
  public boolean updatePosition(int _x, int _y) {
    // if we are at rest, and not already at desired position 
    // start moving to new position
    if (ElementState.ELEM_AT_REST == state) {
      startMigrationTo(_x, _y);
      return true;
    }
    
    // if we are already moving retun error and keep going
    return false;
  }
  
  /* get current position */
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
  public int getValue() {
    return value;
  }
  
  public void display() {
    text(value.toString(), x, y);
    if (selected) {
      pushMatrix();
      stroke(114, 122, 0);
      noFill();
      strokeWeight(3);
      rect(x - 4, y - 18, 45, 45);
      popMatrix();
    }
  }
  
  ElementState getState() {
    return state;
  }
  
  void select() {
    selected = true;
  }
  
  void deselect() {
    selected = false;
  }
  
  
  public void initPosition(int _x , int _y) {
    x = _x;
    y = _y;
  }
  
  /* private methods */
  private boolean startMigrationTo(int _x, int _y) {
    if (ElementState.ELEM_HUSSLE == state) {
      println("Error: We are already in motion");
      return false;
    }
    state = ElementState.ELEM_HUSSLE;
    x2 = _x;
    y2 = _y;
    deltaX = (x2 > x)?2:-2;
    //deltaY = (y2 > y)?2:-2;
    return true;     
  }
  
  private void stop() {
    state = ElementState.ELEM_AT_REST;
  }
  
  private void update() {
    /* if hussling then update new position */
    if (ElementState.ELEM_HUSSLE == state) {
      // simple linear motion for now
      x += deltaX;
      y += deltaY;
    }
    // TODO this needs to be refactored a lot
    if (((deltaX > 0) && (x >= x2)) || 
    ((deltaX < 0) && (x <= x2))) {
      println("Set deltaX to 0");
      deltaX = 0;
      stop();
    }    
    if (((deltaY > 0) && (y >= y2)) || 
    ((deltaY < 0) && (y <= y2))) {
      println("Set deltaY to 0");
      deltaY = 0;
      stop();
    }
  }
    
}