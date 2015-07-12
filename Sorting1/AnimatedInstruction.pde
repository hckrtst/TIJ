/* 
* Animation states of various instructions
*/

public static int ANIM_PAUSE = 1;
public static int ANIM_PLAY = 2;


/*
* implement custom animations for common instructions
*/
class AnimatedInstruction 
{
  private int state;
  private int ms;
  
  public AnimatedInstruction() {
    state = ANIM_PAUSE;
  }
  public boolean startCompare(Element _a, Element _b) {
    if ((null == _a) || (null == _b)) {
      println("cannot compare null");
      return false;
    }    
    return true;
  }
  
  public boolean startSelect(Element _a) {
    if (null == _a) {
      println("cannot select null");
      return false;
    }
    // TODO move that to this class altogether
    // no need to mix animations into Element class
    _a.select();
    state = ANIM_PLAY;
    ms = millis();
    return true;
  }
  
  public boolean deselect(Element _a) {
    if (null == _a) {
      println("cannot deselect null");
      return false;
    }
    _a.deselect();
    state = ANIM_PAUSE;
    return true;
  }
  
  public int getState() {
    return state;  
  }
  
  public boolean isReady() {
    // check time diff
    if (ANIM_PAUSE == state) return true; 
    if ((millis() - ms) >= 1000) {
      println("Instruction ready");
      state = ANIM_PAUSE;
      return true;
    }
    return false;
  }  
}  