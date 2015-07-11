/* 
* VM needs to process several instructions
*/
class Instruction {
  // Not using enums to make it portable for pjs
  // NOP is the default instruction
  static final int NOP = 0;
  static final int SELECT = 11;
  static final int COMPARE = 21;
  static final int SWAP = 31;
  static final int DESELECT = 41;
  
  // command
  int cmd = NOP;
  // params
  Element a = null;
  Element b = null;
  
  public Instruction() {
    println("created instruction");
  }
  
  /*
  * Execute instruction
  */
  public void exec() {
    println("exec()");
    switch(cmd) {
      case SELECT:
      {
        println("SELECT " + a);
        a.select();
        break;
      }
      default:
      case NOP:
        println("NOP");
      
    }
  }
  
  /*
  * Set the instruction
  */
  public void set(int instr, Element _a, Element _b) {
      switch(instr) {
        // _b is ignored for SELECT?
        case SELECT:
        {
          println("set select " + _a);
          cmd = SELECT;
          a = _a;          
        }
        break;
        case DESELECT:
        {
          println("set deselect " + _a);
          cmd = DESELECT;
          a = _a;
        }
        break;
        default:
        case NOP:
          println("set NOP");
      }
  }
  
}