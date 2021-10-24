#include <VarSpeedServo.h> // inclusão da bibliotecaa
VarSpeedServo servo;
void setup() {
  Serial.begin(9600);
  servo.attach(9);

}

char option;
void loop() {
  /*
    delay 1000 - speed 50
    delay 700 - speed 100
    delay 400 - speed 255
  */
  if( Serial.available() > 0 ){
    option = Serial.read();
    
  }
  Serial.print(option);

  switch (option) {
    case '1':
      ServoMotor(1000,50);
      break;
    case '2':
      ServoMotor(700,100);
      break;
    case '3':
      ServoMotor(400,255);
      break;
    default:
      servo.write(0);
      break;
  }
  
}

void ServoMotor(int delayServo ,int speedServo){
  servo.slowmove(0, speedServo);
  delay (delayServo); 
  servo.slowmove(95, speedServo); 
  delay (delayServo);
}
