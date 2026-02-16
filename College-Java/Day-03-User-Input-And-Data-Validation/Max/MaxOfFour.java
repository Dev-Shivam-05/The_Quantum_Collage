
import java.util.Scanner;

public class MaxOfFour {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.print("Enter Number 1 : ");
        int num1 = scanner.nextInt();

        System.err.print("Enter Number 2 : ");
        int num2 = scanner.nextInt();

        System.err.print("Enter Number 3 : ");
        int num3 = scanner.nextInt();

        System.err.print("Enter Number 4 : ");
        int num4 = scanner.nextInt();

        if (num1 > num2) {
            if (num1 > num3) {
                if (num1 > num4) {
                    System.err.print(num1 + " Is Greatest");
                } else {
                    System.err.print(num4 + " Is Greatest");
                }
            } else {
                System.err.print(num3 + " Is Greatest");
            }
        } else if (num2 > num3) {
            if (num2 > num4) {
                System.err.print(num2 + " Is Greatest");
            } else {
                System.err.print(num4 + " Is Greatest");
            }
        } else {
            if (num3 > num4) {
                System.err.print(num3 + " Is Greatest");
            } else {
                System.err.print(num4 + " Is Greatest");
            }
        }
    }
}
