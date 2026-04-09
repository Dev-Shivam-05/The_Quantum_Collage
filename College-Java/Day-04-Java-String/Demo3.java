import java.util.Scanner;

public class Demo3  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.println("My First Name is : " + firstName.trim());
        System.out.println("My Last Name is : " + lastName.trim());
        System.out.println("My Full Name is : " + firstName.trim().concat(" " + lastName.trim()));
        // Creating Email
        System.out.println("Your email is : " + firstName.trim().toLowerCase() + "." + lastName.trim().toLowerCase() + "@gmail.com");
        // Replacing
        System.out.println("Your name is : " + firstName.trim().replace("Shivam", "Shivam Kumar"));
    }
}