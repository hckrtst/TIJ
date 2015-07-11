DataSet mydata; 
VM vm;
void setup() {
  textSize(20);
  colorMode(RGB);
  background(0);
  fill(255, 0, 0);
  
  size(600,700);
  mydata = new DataSet();
  vm = new VM(mydata);
  vm.start();
}

void draw() {
  
  // TODO - only wipe when animating
  if (vm.isRunning()) {
    background(0);
    mydata.update();
    mydata.display();
    vm.step();
  } else {
    
  }
}