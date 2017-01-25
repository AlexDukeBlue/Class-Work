#include <Servo.h>                           // Use the Servo library (included with Arduino IDE)  
Servo servoL;                                // Define the left and right servos
Servo servoR;
#include <SoftwareSerial.h>
int yes = 0;
#define Rx 10
#define Tx 11
SoftwareSerial Xbee (Rx, Tx);

// Perform these steps with the Arduino is first powered on
void setup()
{
  Serial.begin(9600);                        // Set up Arduino Serial Monitor at 9600 baud
  servoL.attach(13);                         // Attach (programmatically connect) servos to pins on Arduino
  servoR.attach(12);
  char outgoing = 0;
  char incoming = 0;

  pinMode(2, OUTPUT); //for a 1
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(9, OUTPUT);
  digitalWrite(2, LOW);
  digitalWrite(3, LOW);
  digitalWrite(4, LOW);
  digitalWrite(9, LOW);

  pinMode(31, OUTPUT);
  pinMode(33, OUTPUT);
  pinMode(35, OUTPUT);
  pinMode(37, OUTPUT);
  pinMode(39, OUTPUT);
  pinMode(41, OUTPUT);
  pinMode(43, OUTPUT);
  digitalWrite(31, LOW);
  digitalWrite(33, LOW);
  digitalWrite(35, LOW);
  digitalWrite(37, LOW);
  digitalWrite(39, LOW);
  digitalWrite(41, LOW);
  digitalWrite(43, LOW);

  pinMode(45, OUTPUT);
  pinMode(47, OUTPUT);
  pinMode(49, OUTPUT);
  pinMode(51, OUTPUT);
  pinMode(53, OUTPUT);

  //Xbee.begin(9600);
  //delay(500);

}

void RFIDSense() {
  servoL.detach();                         // Attach (programmatically connect) servos to pins on Arduino
  servoR.detach();
  //Xbee.begin(9600);

#define enablePin  13   // Connects to the RFID's ENABLE pin
#define rxPin      12  // Serial input (connects to the RFID's SOUT pin)
#define txPin      11  // Serial output (unused)


  //SoftwareSerial Xbee (Rx, Tx);

#define BUFSIZE    11  // Size of receive buffer (in bytes) (10-byte unique ID + null character)

#define RFID_START  0x0A  // RFID Reader Start and Stop bytes
#define RFID_STOP   0x0D
  SoftwareSerial rfidSerial =  SoftwareSerial(rxPin, txPin);

  //int outgoing = 1;
  //char outgoing = 0;
  //char incoming = 0;
  //int F = 0;

  pinMode(enablePin, OUTPUT);
  pinMode(rxPin, INPUT);
  digitalWrite(enablePin, HIGH);  // disable RFID Reader
  // set the baud rate for the SoftwareSerial port
  rfidSerial.begin(2400);
  Serial.flush();
  digitalWrite(enablePin, LOW);   // enable the RFID Reader
  // Wait for a response from the RFID Reader
  // See Arduino readBytesUntil() as an alternative solution to read data from the reader
  char rfidData[BUFSIZE];  // Buffer for incoming data
  char offset = 0;         // Offset into buffer
  rfidData[0] = 0;         // Clear the buffer
  int time = 0;
  while (1)
  {
    time = time + 1;
    Serial.println(time);
    if (rfidSerial.available() > 0) // If there are any bytes available to read, then the RFID Reader has probably seen a valid tag
    {
      digitalWrite(31, LOW);
      digitalWrite(33, HIGH);
      digitalWrite(35, HIGH);
      digitalWrite(37, LOW);
      digitalWrite(39, LOW);
      digitalWrite(41, LOW);
      digitalWrite(43, LOW);
      //outgoing = 'F';
      //F = 1;
      //Xbee.print(outgoing);
      digitalWrite(9, LOW);
      digitalWrite(2, HIGH);
      rfidData[offset] = rfidSerial.read();  // Get the byte and store it in our buffer
      if (rfidData[offset] == RFID_START)    // If we receive the start byte from the RFID Reader, then get ready to receive the tag's unique ID
      {
        offset = -1;     // Clear offset (will be incremented back to 0 at the end of the loop)
      }
      else if (rfidData[offset] == RFID_STOP)  // If we receive the stop byte from the RFID Reader, then the tag's entire unique ID has been sent
      {
        rfidData[offset] = 0; // Null terminate the string of bytes we just received
        //digitalWrite(9, HIGH);
        break;                // Break out of the loop
      }

      offset++;  // Increment offset into array
      if (offset >= BUFSIZE) offset = 0; // If the incoming data string is longer than our buffer, wrap around to avoid going out-of-bounds
    }
    //else if ((rfidSerial.available()) <= 0)
    else if (time == 500) //if (rfidSerial.available() == 0)
    {
      digitalWrite(31, HIGH);
      digitalWrite(33, HIGH);
      digitalWrite(35, HIGH);
      digitalWrite(37, HIGH);
      digitalWrite(39, HIGH);
      digitalWrite(41, HIGH);
      digitalWrite(43, LOW);
      //outgoing = 'f';
      //F = 0;
      //Xbee.print(outgoing);
      digitalWrite(9, HIGH);
      digitalWrite(2, HIGH);
      //break;
      Comms ();

    }

  }
  if (digitalRead(9) == LOW)
  {
    Comms();
  }
  Serial.println(rfidData);       // The rfidData string should now contain the tag's unique ID with a null termination, so display it on the Serial Monitor
  Serial.flush();

  servoL.attach(13);                         // Attach (programmatically connect) servos to pins on Arduino
  servoR.attach(12);
  //if (digitalRead(9) == HIGH)
  //{
  //digitalWrite(4, HIGH);
  //}
  //else
  //{
  //digitalWrite(4, LOW);
  //}

}



void Comms() {

  //servoL.detach();                         // Attach (programmatically connect) servos to pins on Arduino
  //servoR.detach();
#define Tx 11;
  Xbee.begin(9600);
  char incoming = '0';
  char outgoing = '0';
  int F = 0;
  if (digitalRead(9) == LOW)
  {
    outgoing = 'F';
    F = 1;
  }
  else if (digitalRead(9) == HIGH)
  {
    outgoing = 'f';
    F = 0;
  }
  Xbee.print(outgoing);
  //delay (50);
  if (Xbee.print(outgoing))
  {
    digitalWrite(3, HIGH);

  }
  else
  {
    digitalWrite(3, LOW);
  }
  //Serial.println(outgoing);

  int aA = 0;
  int bB = 0;
  int cC = 0;
  int dD = 0;
  int eE = 0;
  //int fF = 0;
  int A = 0;
  int B = 0;
  int C = 0;
  int D = 0;
  int E = 0;

  int Count1 = 0;
  if (Xbee.available());
  {
    digitalWrite(4, HIGH);
  }

  while ((Count1) < 5)
  {
    Xbee.print(outgoing);
    //delay(50);
    //Serial.println(outgoing);
    //incoming = '0';

    if (Xbee.available()) {
    incoming = Xbee.read();
    digitalWrite(4, HIGH);
    }
    else{
    digitalWrite(4, LOW);
    }

    Serial.println(incoming);
    //Serial.println(outgoing);

    if (incoming == 'A')
    {
      aA = 1;
      A = 1;
      digitalWrite(45, HIGH);
    }
    else if (incoming == 'a')
    {
      aA = 1;
      A = 0;
    }
    if (incoming == 'B')
    {
      bB = 1;
      B = 1;
      digitalWrite(47, HIGH);
    }
    else if (incoming == 'b')
    {
      bB = 1;
      B = 0;
    }
    if (incoming == 'C')
    {
      cC = 1;
      C = 1;
      digitalWrite(49, HIGH);
    }
    else if (incoming == 'c')
    {
      cC = 1;
      C = 0;
    }
    if (incoming == 'D')
    {
      dD = 1;
      D = 1;
      digitalWrite(51, HIGH);
    }
    else if (incoming == 'd')
    {
      dD = 1;
      D = 0;
    }
    if (incoming  == 'E')
    {
      eE = 1;
      E = 1;
      digitalWrite(53, HIGH);
    }
    else if (incoming == 'e')
    {
      eE = 1;
      E = 0;
    }

    Count1 = aA + bB + cC + dD + eE; //+ fF;
    int Count2 = A + B + C + D + E + F;

    switch (Count2)
    {

      case 0:
        digitalWrite(31, HIGH);
        digitalWrite(33, HIGH);
        digitalWrite(35, HIGH);
        digitalWrite(37, HIGH);
        digitalWrite(39, HIGH);
        digitalWrite(41, HIGH);
        digitalWrite(43, LOW);
        break;

      case 1:
        digitalWrite(31, LOW);
        digitalWrite(33, HIGH);
        digitalWrite(35, HIGH);
        digitalWrite(37, LOW);
        digitalWrite(39, LOW);
        digitalWrite(41, LOW);
        digitalWrite(43, LOW);
        break;

      case 2:
        digitalWrite(31, HIGH);
        digitalWrite(33, HIGH);
        digitalWrite(35, LOW);
        digitalWrite(37, HIGH);
        digitalWrite(39, HIGH);
        digitalWrite(41, LOW);
        digitalWrite(43, HIGH);
        break;

      case 3:
        digitalWrite(31, HIGH);
        digitalWrite(33, HIGH);
        digitalWrite(35, HIGH);
        digitalWrite(37, HIGH);
        digitalWrite(39, LOW);
        digitalWrite(41, LOW);
        digitalWrite(43, HIGH);
        break;

      case 4:
        digitalWrite(31, LOW);
        digitalWrite(33, HIGH);
        digitalWrite(35, HIGH);
        digitalWrite(37, LOW);
        digitalWrite(39, LOW);
        digitalWrite(41, HIGH);
        digitalWrite(43, HIGH);
        break;

      case 5:
        digitalWrite(31, HIGH);
        digitalWrite(33, LOW);
        digitalWrite(35, HIGH);
        digitalWrite(37, HIGH);
        digitalWrite(39, LOW);
        digitalWrite(41, HIGH);
        digitalWrite(43, HIGH);
        break;

      case 6:
        digitalWrite(31, HIGH);
        digitalWrite(33, LOW);
        digitalWrite(35, HIGH);
        digitalWrite(37, HIGH);
        digitalWrite(39, HIGH);
        digitalWrite(41, HIGH);
        digitalWrite(43, HIGH);
        break;
    }

  }

  delay(50);
  //digitalWrite(RedPin, LOW);
}


void getOut() {
  servoL.writeMicroseconds(1400);
  servoR.writeMicroseconds(1600);
  delay(900);
  servoL.writeMicroseconds(1600);
  servoR.writeMicroseconds(1600);
  delay(620);
  servoL.writeMicroseconds(1600);
  servoR.writeMicroseconds(1400);
  delay(300);
  //Comms();
  servoL.detach();
  servoR.detach();
  delay(250);
  Comms();
  //break;
}

void turnIn() {
  delay(500);
  servoL.writeMicroseconds(1400);
  servoR.writeMicroseconds(1400);
  delay(620);
  servoL.writeMicroseconds(1600);
  servoR.writeMicroseconds(1400);
  delay(900);
  servoL.writeMicroseconds(1500);
  servoR.writeMicroseconds(1500);
  delay(500);
  RFIDSense();
  delay(500);
  getOut();
  //Comms();
  //break;
}
// This code repeats indefinitely
void loop()
{
  //Xbee.begin(9600);
  //delay(500);

  //int outgoing = 1;
  //Xbee.print(outgoing);
  //int incoming = 0;
  //if(outgoing == '1') {digitalWrite(3, HIGH);}
  //if (Xbee.available()) incoming = Xbee.read();
  //if (incoming == '1') digitalWrite(3, HIGH);
  //else digitalWrite(3, LOW);

  for (int i = 5; i < 9; i++) {
    pinMode(i, OUTPUT);
    digitalWrite(i, HIGH);
  }    // Set direction of Arduino pins D4-D7 as OUTPUT
  // Set level of Arduino pins D4-D7 to HIGH
  delayMicroseconds(230);                    // Short delay to allow capacitor charge in QTI module
  for (int i = 5; i < 9; i++) {
    pinMode(i, INPUT);
    digitalWrite(i, LOW);
  }    // Set direction of pins D4-D7 as INPUT
  // Set level of pins D4-D7 to LOW
  delayMicroseconds(200);                    // Short delay
  int pins = digitalRead(5) + 10 * digitalRead(6) + 100 * digitalRead(7) + 1000 * digitalRead(8);              // Get values of pins D0-D7
  // Drop off first four bits of the port; keep only pins D4-D7

  Serial.println(pins);                 // Display result of D4-D7 pins in Serial Monitor

  // Determine how to steer based on state of the four QTI sensors
  int vL, vR, k, d;
  d = 50;
  switch (pins)                              // Compare pins to known line following states
  {
    case 0:
      vL = 100;
      vR = 100;
      k = 0;
      break;
    case 110:
      vL = 100;
      vR = 100;
      k = 1;
      break;
    case 1001:
      vL = 100;
      vR = 100;
      k = 1;
      break;
    case 1000:
      vL = -75;                             // -100 to 100 indicate course correction values
      vR = 75;
      k = 0;
      // -100: full reverse; 0=stopped; 100=full forward
      break;
    case 1100:
      vL = 0;
      vR = 75;
      k = 0;
      break;
    case 100:
      vL = 0;
      vR = 75;
      k = 0;
      break;
    case 1110:
      vL = -50;
      vR = 75;
      k = 0;
      break;
    case 111:
      vL = 100;
      vR = -75;
      k = 0;
      break;
    case 11:
      vL = 100;
      vR = -50;
      k = 0;
      break;
    case 1:
      vL = 75;
      vR = -75;
      k = 0;
      break;
    case 1111:
      //if(k == 1){ //  For the dash the bot backs up and then moves forward.
      vL = 0;
      vR = 0;
      k = 2;

      // else{
      // vL = 100;
      // vR = -100;
      // k= 0;}
      break;
    case 1010:
      vL = -50;
      vR = 75;
      k = 0;
      break;
    case 101:
      vL = 100;
      vR = -75;
      k = 0;
      break;
    case 10:
      vL = 100;
      vR = -75;
      k = 0;
      break;
    case 1011:
      vL = 75;
      vR = -50;
      k = 0;
      break;
  }

  vR = -vR;

  servoL.writeMicroseconds(1500 + vL);      // Steer robot to recenter it over the line
  servoR.writeMicroseconds(1500 + vR);

  if (k == 2 && yes != 0) {
    delay(1000);
    servoL.writeMicroseconds(1500);
    servoR.writeMicroseconds(1500);
    turnIn();
  }
  yes = yes + 1;
  delay(d);
  // Delay for d milliseconds
}