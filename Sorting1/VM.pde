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
  // which tracks the next instruction to execute
  int pc = 0;
  int state;
  // instruction counter 
  // which tracks the next instruction to be added
  int ic = 0;
  
  public VM(DataSet mydata) {
    /*for(int i =0; i < MAX_INSTR; i++) {
      instructions[i] = new Instruction();
    }*/
    //instructions[0] = new Instruction();
    //instructions[1] = new Instruction();
    instructions[0] = new Instruction();
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
  
  /*
  * update vm on each cycle
  */
  public void update() {
    if ((pc < MAX_INSTR) && (null != instructions[pc])) {
      instructions[pc].update();
    }
  }
  
  /* //<>//
  * Process next available instruction
  */
  public void step() {
    if ((pc >= MAX_INSTR) || (null == instructions[pc])) return;
      
    // check if an instruction is executing
    if (instructions[pc].getState() == INSTR_RUNNING) {
      //println(instructions[pc].getCmd() + " running ");
      // do nothing
    } else {
      // if done or none then get the next instruction
      Instruction i = getNext();
      if (null != i) {
        if (INSTR_RUNNING == i.exec()) {
          // if still running then pause vm
          pause();
        }
        //pc++;
      } else {
        println("stopping");
        pause();
      }
    }
  }
  
  /*
  * Add an instruction
  */
  public boolean addInstr(int instr, Element _a, Element _b) {
        
    // Let first instruction always be a NOP
    if (0 == ic) {
         println("first instruction is NOP");
         instructions[ic] = new Instruction(); 
         instructions[ic].set(Instruction.NOP, null, null);
         println("added NOP ");
         ic++;
    }
    
    if (ic < MAX_INSTR) {
      instructions[ic] = new Instruction();
      boolean added = true;
      switch(instr) {
        case Instruction.SELECT:
        {
          instructions[ic].set(Instruction.SELECT, _a, null);
          println("added select " + _a.getValue());
          break;
        }
        case Instruction.DESELECT:
        {
          instructions[ic].set(Instruction.DESELECT, _a, null);
          println("added deselect " + _a.getValue());          
          break;
        }
        default:
          println("unknown instruction");
          added = false;
      }
      // Don't increment if invalid instruction received
      if (added) {
        ic++;
        return true;
      }
      return false;
    }
    
    println("Max instructions reached");
    return false;
  }
 
  /*
  * private methods
  */
  boolean isRunning() {
    return (VM_STATE_RUNNING == state);
  }
  
  private Instruction getNext() {
    pc++;
    if (pc < MAX_INSTR) {
      println("getNext() - pc = " + pc);
      return instructions[pc];
    }
    println("Maxed out on instructions, pause vm");
    pause();
    return null;
  }
}