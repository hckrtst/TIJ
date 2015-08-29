DataSet mydata; 
VM vm;
int prevtime;

void setup() {
  textSize(20);
  colorMode(RGB);
  background(0);
  fill(255, 0, 0);
  
  size(600,700);
  mydata = new DataSet();
  vm = new VM(mydata);
  mydata.setVm(vm);
  // TODO - pass in sort options
  mydata.sort();
  vm.start();
  //temp
  //frameRate(1);
  prevtime = millis();
}

void draw() {
  //if (vm.isRunning()) {
    background(0);
    mydata.update();
    mydata.display();
    vm.update();
    vm.step();
    //noLoop();
  //}      
  
  // TODO move this logic to pause and pace VM
  // into the VM instead of driving from here
  /*if((millis() - prevtime) < 1000) {
    vm.pause();
  }
  else{
    vm.start();
    prevtime = millis();  
  }*/
  
  
}