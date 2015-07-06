DataSet mydata; 

void setup() {
  
  textSize(20);
  colorMode(RGB);
  background(0);
  fill(255, 0, 0);
  
  size(600,700);
  mydata = new DataSet();
}

void update() {
}

void draw() {
  mydata.display();
}