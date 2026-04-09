import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("My First Name is : " + firstName);
        System.out.println("My Last Name is : " + lastName);
        
        System.out.println("My Full Name is : " + firstName.concat(" " + lastName));
        // Creating Email
        System.out.println("Your email is : " + firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com");
    }
}