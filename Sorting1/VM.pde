/* 
* Each animation uses a VM and a set of instructions 
*/
class VM{
  // An array of instructions is our program
  Instruction[] program;
  // program counter
  int pc;
  public VM() {
    
  }
  /* 
  * Continually process each instruction on every draw()
  */
  public void process() {
  }
  
  /*
  * Pause at the current instruction
  */
  public void pause() {
  }
  
  /*
  * Move to beginning of instruction set
  */
  public void reset() {
  }
  
  /*
  * Process next available instruction
  */
  public void step() {
  }
  
  /*
  * Add an instruction
  */
  public boolean addInstr() {
    
    return false;
  }
 
  /*
  * private methods
  */
  private void loadProgram() {
  }
}