
import java.util.Scanner;


public class MaxOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.print("Enter Number 1 : ");
        int num1 = scanner.nextInt();
        System.err.print("Enter Number 2 : ");
        int num2 = scanner.nextInt();
        System.err.print("Enter Number 3 : ");
        int num3 = scanner.nextInt();

        if(num1 > num2) {
            if (num1>num3) {
                System.err.println(num1 + " Is Greatest Of All.");
            }
            else{
                System.err.println(num3 + " Is Greatest Of All.");
            }
        } else {
            if (num2>num3) {
                System.err.println(num2 + " Is Greatest Of All.");
            }
            else{
                System.err.println(num3 + " Is Greatest Of All.");
            }
        }
    }
}