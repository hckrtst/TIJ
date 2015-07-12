static final int VM_STATE_INIT = 0;
static final int VM_STATE_PAUSED = 123;
static final int VM_STATE_RUNNING = 223;
static final int MAX_INSTR = 50;
/* 
* Each animation uses a VM and a set of instructions 
*/
class VM{
  // An array of instructions is our program
  Instruction[] instructions = new Instruction[MAX_INSTR];
  // program counter
  int pc = 0;
  int state;
  // instruction register
  int ir = 0;
  
  public VM(DataSet mydata) {
    /*for(int i =0; i < MAX_INSTR; i++) {
      instructions[i] = new Instruction();
    }*/
    //instructions[0] = new Instruction();
    //instructions[1] = new Instruction();
  }
  /* 
  * Continually process each instruction on every draw()
  */
  public void start() {
    state = VM_STATE_RUNNING;
    //println("VM state is started");
  }
  
  /*
  * Pause at the current instruction
  */
  public void pause() {
    state = VM_STATE_PAUSED;
    //println("VM state is paused");
  }
  
  /*
  * Move to beginning of instruction set
  */
  public void reset() {
  }
  
  /* //<>//
  * Process next available instruction
  */
  public void step() {
    println("step");
    Instruction i = getNext();
    if (null != i) {
      getNext().exec();
      pc++;
    } else {
      println("stopping");
      state = VM_STATE_PAUSED;
    }
  }
  
  /*
  * Add an instruction
  */
  public boolean addInstr(int instr, Element _a, Element _b) {
    if (ir < MAX_INSTR) {
      instructions[ir] = new Instruction();
      switch(instr) {
        case Instruction.SELECT:
        {
          instructions[ir].set(Instruction.SELECT, _a, null);
          println("added select " + _a.getValue());
          
          break;
        }
        case Instruction.DESELECT:
        {
          instructions[ir].set(Instruction.DESELECT, _a, null);
          println("added deselect " + _a.getValue());
          
          break;
        }
      }
      // TODO don't increment if invalid instruction received?
      // increment so next instruction can be saved
      ir++;
      return true;
    }
    
    println("Max instructions reached");
    return false;
  }
 
  /*
  * private methods
  */
  private void loadProgram() {
  }
  
  boolean isRunning() {
    return (VM_STATE_RUNNING == state);
  }
  
  private Instruction getNext() {
    println("getNext() - pc = " + pc);
    if (pc < MAX_INSTR) {
      return instructions[pc];
    }
    println("Maxed out on instructions");
    return null;
  }
}