public class Demo1 {
    public static void main(String[] args) {
        String name = "Shivam Bhadoriya";
        // Method 1 
        System.out.println("My name is " + name.charAt(0));
        // Method 2
        String nameCopy = "";
        for(int i = 0; i < name.length(); i++) {
            nameCopy += name.charAt(i);
        }
        System.out.println("My name is : " + nameCopy);

        // Method 3
        System.out.println("My name is : " + name.toUpperCase());
        // Method 4
        System.out.println("My name is : " + name.toLowerCase());
        // Method 5
        System.out.println("My name is : " + name.substring(0, 5));
        // Method 6
        System.out.println("My name is : " + name.substring(7));

        // Method 7
        System.out.println("My name is : " + name.indexOf("Bhadoriya"));
        // Method 8
        System.out.println("My name is : " + name.lastIndexOf("Bhadoriya"));
        // Method 9
        System.out.println("My name is : " + name.equals("Shivam Bhadoriya"));
        // Method 10
        System.out.println("My name is : " + name.equalsIgnoreCase("Shivam Bhadoriya"));
        // Method 11
        System.out.println("My name is : " + name.compareTo("Shivam Bhadoiya"));
        // Method 12
        System.out.println("My name is : " + name.compareToIgnoreCase("Shivam Bhadoriya"));
        // Method 13
        System.out.println("My name is : " + name.compareTo("Shivam Bhadoriya"));
        // Method 14
        System.out.println("My name is : " + name.contains("Shivam"));
    }
}