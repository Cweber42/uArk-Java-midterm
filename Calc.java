import java.util.Scanner;
/*
 * Use the scanner to pull in the numbers
 * 
 * Created by: Charlie Weber
 * version 12.20.2021.0.0.1 alpha
 * This is a representation of my current abilities learned and gained in the class. The lack of working code examples shared from class to github; and restrictions
 * that blackboard seems to only go back 4 weeks (12 sessions). There are several ways to improve this code.
 * I've tried to break the class methods section into individual classes and bring back in.
 * I have a conceptual idea of how to instance the num1/2 to be strings instead of forcing a number and then doing a verification like exampled below to accept regular strings
 * 
 * 
 */


public class Calc {
    // instance fields
    double num1;
    double num2;
    
    // constructor method
    public Calc(double firstNum, double secondNum) {
      num1 = firstNum;
      num2 = secondNum;
    }

    //class methods
    /*
     * Basic math functions, set to a method; probably should break these method into their own package(class) and import them
     * I could not get that to work as I intended so I wrote it all in one
     */
    public double add(double firstNum, double secondNum){
      return firstNum + secondNum;
    }

    public double subtract(double firstNum, double secondNum){
      return firstNum - secondNum;
    }

    public double multiply(double firstNum, double secondNum){
      return firstNum * secondNum;
    }

    public long expontentiate(double firstNum, double secondNum){
      // Math.pow returns a double, so use typecasting to account for large numbers
      
      long exponentProd = (long) Math.pow(firstNum, secondNum);
      
      return exponentProd;
    }
    /*Requires a PhD in mathmatics to figure out the formula
     * Should be able to compute any root
     */
    public double root(double firstNum,double secondNum) {
    	double temp;
    	double anyRoot = firstNum/secondNum;
    	do {
    		temp = anyRoot;
    		anyRoot = (temp + (firstNum / temp)) / 2;
    	} while ((temp - anyRoot) != 0);

    	return anyRoot;
    	
    }

    public double divide(double firstNum,double secondNum){
      return firstNum / secondNum;
    }

    public static void backToMainMenu(){
      System.out.println("\nReturning to main menu...\n");
      wholeThing();
    }

    
    public static void wholeThing(){
      try{
        Thread.sleep(500);
      }
      catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      System.out.println(" This calculator performs operations on two numbers. \n Please type your first number \n Type 'exit' to exit at anytime! \n");
          Scanner sc1 = new Scanner(System.in);
          String firstInput = sc1.next();
          double firstNum = 0.0; 
          
          if(firstInput.equals("exit")){
            System.exit(0);
          }/*else if(firstInput.equals("pi")) {
        	  firstNum = Math.PI;
        	  This is in the wrong place with the logic... figure it out bud.
          }*/
          else{
          }
            firstNum = Double.parseDouble(firstInput);
          

          System.out.println("\n Now input your second number.\n");
          
          String secondInput = sc1.next();
          double secondNum = 0.0;
          
          if(secondInput.equals("exit")){
            System.exit(0);
          } else{
            secondNum = Double.parseDouble(secondInput);
          }

          Calc calc1 = new Calc(firstNum, secondNum);

          System.out.println("\nAwesome! Now, choose the operation you want.\n Type a for addition\n Type s for subtraction\n Type m for multiplication\n Type exp to raise the first number to the power of the second\n Type d to divide\n Type r to get any root");

          
          String operator = sc1.next();
          operator = operator.toLowerCase(); // force operator to always be lowercase
           switch (operator){
             case "a":
                System.out.println(calc1.num1 + " plus " + calc1.num2 + " equals "+calc1.add(firstNum, secondNum));
                backToMainMenu();
                break;
              case "s":
                System.out.println(calc1.num1 + " minus " + calc1.num2 + " equals "+calc1.subtract(firstNum, secondNum));
                backToMainMenu();
                break;
              case "m":
                System.out.println(calc1.num1 + " multiplied by " + calc1.num2 + " equals "+calc1.multiply(firstNum, secondNum));
                backToMainMenu();
                break;
              case "exp":
                System.out.println(calc1.num1 + " raised to the power of " + calc1.num2 + " equals "+calc1.expontentiate(firstNum, secondNum));
                backToMainMenu();
                break;
              case "d":
                System.out.println(calc1.num1 + " divided by " + calc1.num2 + " equals "+calc1.divide(firstNum, secondNum));
                backToMainMenu();
                break;
              case "exit":
                System.exit(0);
                break;
              case "r":
            	  System.out.println(calc1.num1 + " root of " + calc1.num2 + " equals "+ calc1.root(firstNum,secondNum));
            	  backToMainMenu();
            	  break;
              default:
                System.out.println("Input not recognized.");
                backToMainMenu();
                break;
           }
    }
    public static void main(String[] args) {
      wholeThing();
    }
}
