import java.util.Scanner;
public class CaesarCipher {
    public static String caesar(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = ((shift % 26) + 26) % 26;
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                int base = 'A';
                char shifted = (char) ((ch - base + shift) % 26 + base);
                result.append(shifted);
            } else if (Character.isLowerCase(ch)) {
                int base = 'a';
                char shifted = (char) ((ch - base + shift) % 26 + base);
                result.append(shifted);
            } else {
                result.append(ch); 
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String message = sc.nextLine();
        System.out.print("Enter shift value (e.g., 3): ");
        while (!sc.hasNextInt()) {
            System.out.print("Please enter an integer shift value: ");
            sc.next();
        }
        int shift = sc.nextInt();
        sc.nextLine(); 
        System.out.println("\n1. Encrypt Message");
        System.out.println("2. Decrypt Message");
        System.out.print("Choose option (1/2): ");
        String choice = sc.nextLine().trim();
        if (choice.equals("1")) {
            String encrypted = caesar(message, shift); 
            System.out.println("\n🔒 Encrypted message: " + encrypted);
        } else if (choice.equals("2")) {
            String decrypted = caesar(message, -shift); 
            System.out.println("\n🔓 Decrypted message: " + decrypted);
        } else {
            System.out.println("\nInvalid choice! Please select 1 or 2.");
        }
        sc.close();
    }
}
