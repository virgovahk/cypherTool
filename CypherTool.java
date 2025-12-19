import java.util.Scanner;

public class CypherTool {

    // global variables to use as inputs in different methods.
    public static String cypher;
    public static String crypt;
    public static String message;
    public static String shift;
    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    
        public static void main(String[] args) {
            getInput();
            String result = "";
    
            // Based on inputs, method is selected
            if (Integer.parseInt(crypt) == 1 && Integer.parseInt(cypher) == 1) {
                result = encryptRot13(message);
            } else if (Integer.parseInt(crypt) == 2 && Integer.parseInt(cypher) == 1) {
                result = decryptRot13(message);
            } else if (Integer.parseInt(crypt) == 1 && Integer.parseInt(cypher) == 2) {
                result = encryptAtbash(message);
            } else if (Integer.parseInt(crypt) == 2 && Integer.parseInt(cypher) == 2) {
                result = decryptAtbash(message);
            } else if (Integer.parseInt(crypt) == 1 && Integer.parseInt(cypher) == 3) {
                result = encryptCaesar(message, Long.parseLong(shift));
            } else if (Integer.parseInt(crypt) == 2 && Integer.parseInt(cypher) == 3) {
                result = decryptCaesar(message, Long.parseLong(shift));
    
            } else {
                result = "";
            }
    
            System.out.println(
            (crypt.equals("1") ? "\nEncrypted message with " : "\nDecrypted message with ")
            + (cypher.equals("1") ? "Rot13. Result:" : cypher.equals("2") ? "Atbash. Result:" : "Caesar. Result:")
            );
            System.out.println(result);
        }
    
        // user input is asked for
        public static void getInput() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nWelcome to the Cypher Tool!\n");
        
            while (true) {
                System.out.println("Select operation:");
                System.out.println("1: Encrypt");
                System.out.println("2: Decrypt");
                System.out.println("write 'exit' to exit code");
                System.out.print("$> ");
                crypt = scanner.nextLine();
                if (crypt.equals("exit")) {
                    System.exit(0);
                }
                if (crypt.equals("1") || crypt.equals("2")) {
                    break;
                } else {
                    System.out.println(RED + "You need to choose one of the options listed!" + RESET);
                }
            }
    
        while (true) {
            System.out.println("\nSelect Cypher:");
            System.out.println("1. Rot13");
            System.out.println("2. Atbash");
            System.out.println("3. Caesar");
            System.out.println("write 'exit' to exit code");
            System.out.print("$> ");
            cypher = scanner.nextLine();
            if (cypher.equals("exit")) {
                System.exit(0);
            }
            if (cypher.equals("1") || cypher.equals("2")) {
                break;
            } else if (cypher.equals("3")) {
                while (true) {
                    if (crypt.equals("1")) {
                        System.out.println("\nEnter a number for encryption shift, or write 'exit' to exit code:");
                    } else {
                        System.out.println("\nEnter a number for decryption shift, or write 'exit' to exit code:");
                    }
                    System.out.print("$> ");

                    shift = scanner.nextLine();
                    if (shift.equals("exit")) {
                        System.exit(0);
                    }

                    // Edge case handling - either letters or too big number used.
                    try {
                        long validNumber = Long.parseLong(shift);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "\nYou need to choose a valid number between -2^63 and 2^63-1! (or just 1-25)." + RESET);
                        System.out.print("$> ");
                        shift = null;
                    }
                }
                break;
            } else {
                System.out.println(RED + "\nChoose one of the options listed!" + RESET);
            }
        }
    
        System.out.println("\nEnter your message:");
        System.out.print("$> ");
        message = scanner.nextLine();
        scanner.close();
    }

    // encrypting the message using ROT13 Cipher
    public static String encryptRot13(String message) {
        message = message.trim();
        StringBuilder Rot13Encrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) {
                    Rot13Encrypted.append((char)(c + 13));
                } else if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) {
                    Rot13Encrypted.append((char)(c - 13));
                }
            } else {
                Rot13Encrypted.append(c);
            }
        }
        return Rot13Encrypted.toString();
    }

    // decrypting the message using ROT13 Cipher
    public static String decryptRot13(String message) {
        message = message.trim();
        StringBuilder Rot13Decrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) {
                    Rot13Decrypted.append((char)(c + 13));
                } else if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) {
                    Rot13Decrypted.append((char)(c - 13));
                }
            } else {
                Rot13Decrypted.append(c);
            }
        }
        return Rot13Decrypted.toString();
    }

    // encrypting the message using Atbash Cipher
    public static String encryptAtbash(String message) {
        message = message.trim();
        StringBuilder bashEncrypted = new StringBuilder();

        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    bashEncrypted.append((char) ('z' - (c - 'a'))); 
                } else {
                    bashEncrypted.append((char) ('Z' - (c - 'A'))); 
                }
            } else {
                bashEncrypted.append(c);
            }
        }
        return bashEncrypted.toString();
    }

    // decrypting the message using Atbash Cipher
    public static String decryptAtbash(String message) {
        message = message.trim();
        StringBuilder bashDecrypt = new StringBuilder();

        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    bashDecrypt.append((char) ('z' - (c - 'a')));
                } else {
                    bashDecrypt.append((char) ('Z' - (c - 'A'))); 
                }
            } else {
                bashDecrypt.append(c);
            }
        }
        return bashDecrypt.toString();
    }

    // encrypting the message using Caesar Cipher
    public static String encryptCaesar(String message, long shift) {
        message = message.trim();
        StringBuilder caesarEncrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    long newCharPos = (c  - 'A' + (shift % 26) + 26) % 26;
                    char encryptChar = (char)('A' + newCharPos);
                    caesarEncrypted.append(encryptChar);

                } else {
                    long newCharPos = (c - 'a' + (shift % 26) + 26) % 26;
                    char encryptChar = (char)('a' + newCharPos);
                    caesarEncrypted.append(encryptChar);
                }
            } else {
                caesarEncrypted.append(c);
            }
        }
        return caesarEncrypted.toString();
    }

    // decrypting the message using Caesar Cipher
    public static String decryptCaesar(String message, long shift) {
        message = message.trim();
        StringBuilder caesarDecrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    long newCharPos = (c - 'A' - (shift % 26) + 26) % 26;
                    char encryptChar = (char)('A' + newCharPos);
                    caesarDecrypted.append(encryptChar);
                } else {
                    long newCharPos = (c - 'a' - (shift % 26) + 26) % 26;
                    char encryptChar = (char)('a' + newCharPos);
                    caesarDecrypted.append(encryptChar);
                }
            } else {
                caesarDecrypted.append(c);
            }
        }
        return caesarDecrypted.toString();
    }
}