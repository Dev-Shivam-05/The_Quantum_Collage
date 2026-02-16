
import java.util.Scanner;


public class MaxOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        if (num1 < 0 || num2 < 0) {
            System.out.println("Invalid input. Please enter non-negative integers.");
            scanner.close();
            return;
        }

        int max = (num1 > num2) ? num1 : num2;
        System.out.println("The maximum of " + num1 + " and " + num2 + " is: " + max);
    }
}
