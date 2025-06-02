Project Description
This repository contains two console Java applications that provides two main functionalities:
1. Caesar Cipher encryption/decryption   
2. Arithmetic Expression Evaluator 

How to compile and run the application
1. Clone the repository
git clone https://github.com/rapppersha/Entrance-Test.git
2. Compile the Java files
javac *.java
3. Run one of the applications Caesar Cipher or Arithmetic Evaluator
java CaesarCipherApp or java ArithmeticEvaluatorApp

I separated the program into logic classes (CaesarCipher.java, ArithmeticEvaluator.java) and classes with the main method for running the application (CaesarCipherApp.java, ArithmeticEvaluatorApp.java). I used only standard Java libraries. Input and output are handled through the console.

Examples of usage:
1. CaesarCipher
Enter text to encrypt: Hello World
Enter shift: 3
Result: Khoor Zruog
2. ArithmeticEvaluator
Input: 2 + 3 * 4
Output: 14
