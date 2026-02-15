public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        if (num < 1) {
            System.err.println  ("Factorial Of "+ num +"! Is :- "+ num +".");
        }
        int factorial = 1;
        for (int i = num; i >= 1; i--) {
            factorial *= i;
        }
        System.err.println("Factorial Of "+ num +"! Is :- "+ factorial +".");
    }    
}