public static int INSTR_RUNNING = 1;
public static int INSTR_DONE = 2;

/* 
* VM needs to process several instructions
*/
class Instruction {
  // Not using enums to make it portable for pjs
  // NOP is the default instruction
  public static final int NOP = 0;
  public static final int SELECT = 1;
  public static final int COMPARE = 2;
  public static final int SWAP = 3;
  public static final int DESELECT = 4;
  private AnimatedInstruction ai;
  private int state;
  
  // command
  int cmd = NOP;
  // params
  Element a = null;
  Element b = null;
  
  public Instruction() {
    println("created instruction");
    state = INSTR_DONE;
    ai = new AnimatedInstruction();
  }
  
  /*
  * Execute instruction
  */
  public int exec() {
        
    switch(cmd) {
      case SELECT:
      {
        println("SELECT " + a.getValue());
        if (ai.startSelect(a)) {
          setState(INSTR_RUNNING); 
        }
        
        break;
      }
      case DESELECT:
      {
        println("DESELECT " + a.getValue());
        ai.deselect(a);
        setState(INSTR_DONE);
        break;
      }
      case COMPARE:
      {
        println("COMPARE " + a.getValue() + " & " + b.getValue());
        // todo - animate compare
        break;
      } 
      case SWAP:
      {
        println("SWAP " + a.getValue() + " & " + b.getValue());
        // todo - animate swap
        break;
      }
      default:
      case NOP:
        println("NOP"); 
        setState(INSTR_DONE);
    }
    return getState();
  }
  
  /*
  * Set the instruction
  */
  public void set(int instr, Element _a, Element _b) {
      switch(instr) {
        // _b is ignored for SELECT?
        case SELECT:
        {
          if (null == _a) {
            println("null elem");
            return;
          }
          println("set select " + _a.getValue());
          cmd = SELECT;
          a = _a;          
        }
        break;
        case DESELECT:
        {
          if (null == _a) {
            println("null elem");
            return;
          }
          println("set deselect " + _a.getValue());
          cmd = DESELECT;
          a = _a;
        }
        break;
        default:
        case NOP:
          println("set NOP");
      }
  }
  
  /*
  * On each cycle poll instruction to see if done
  * This would be much better with callbacks if
  * we didn't need to use pjs
  */
  public void update() {
    if (ai.isReady()) {
      setState(INSTR_DONE);
    }
  }
  public int getState() {
    return state;
  }   
  
  public int getCmd() {
    return cmd;
  }
 
  /*public boolean isReady() {
    return ai.isReady();
  }*/
  private void setState(int s) {
    state = s;
  }
  
 
  
}