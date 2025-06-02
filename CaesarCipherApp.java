import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CaesarCipherApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Caesar Cipher Application ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Encrypt text");
            System.out.println("2. Decrypt text (with shift)");
            System.out.println("3. Decrypt text (without shift)");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            String option = scanner.nextLine();

            if ("4".equals(option)) {
                System.out.println("Exit");
                break;
            }

            System.out.print("Input text from console or file? (c/f): ");
            String inputType = scanner.nextLine();

            String text = "";

            if ("f".equalsIgnoreCase(inputType)) {
                System.out.print("Enter file path: ");
                String filePath = scanner.nextLine();
                try {
                    text = new String(Files.readAllBytes(Paths.get(filePath)));
                    System.out.println("Text loaded from file:");
                    System.out.println(text);
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                    continue;
                }
            } else {
                System.out.print("Enter text: ");
                text = scanner.nextLine();
            }

            switch (option) {
                case "1":
                    int shiftEnc = getShift(scanner);
                    String encrypted = CaesarCipher.encrypt(text, shiftEnc);
                    System.out.println("Encrypted text:\n" + encrypted);
                    break;

                case "2":
                    int shiftDec = getShift(scanner);
                    String decrypted = CaesarCipher.decrypt(text, shiftDec);
                    System.out.println("Decrypted text:\n" + decrypted);
                    break;

                case "3":
                    CaesarCipher.decryptWithoutShift(text);
                    break;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
        scanner.close();
    }

    private static int getShift(Scanner scanner) {
        int shift = 0;
        while (true) {
            System.out.print("Enter integer shift value: ");
            String input = scanner.nextLine();
            try {
                shift = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
        return shift;
    }
}