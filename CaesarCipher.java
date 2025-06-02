public class CaesarCipher {

    private static final String EN_UP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String EN_LOW = "abcdefghijklmnopqrstuvwxyz";
    private static final String RU_UP = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String RU_LOW = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static String encrypt(String text, int shift) {
        return process(text, shift);
    }

    public static String decrypt(String text, int shift) {
        return process(text, -shift);
    }

    public static void decryptWithoutShift(String text) {
        System.out.println("Possible decryption (all shifts):");
        int maxShift = Math.max(EN_UP.length(), RU_UP.length());
        for (int shift = 1; shift <= maxShift; shift++) {
            System.out.printf("Shift %2d: %s%n", shift, decrypt(text, shift));
        }
    }

    private static String process(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (EN_UP.indexOf(ch) != -1) {
                sb.append(shiftChar(ch, EN_UP, shift));
            } else if (EN_LOW.indexOf(ch) != -1) {
                sb.append(shiftChar(ch, EN_LOW, shift));
            } else if (RU_UP.indexOf(ch) != -1) {
                sb.append(shiftChar(ch, RU_UP, shift));
            } else if (RU_LOW.indexOf(ch) != -1) {
                sb.append(shiftChar(ch, RU_LOW, shift));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private static char shiftChar(char ch, String alphabet, int shift) {
        int len = alphabet.length();
        int idx = alphabet.indexOf(ch);
        int shifted = (idx + shift) % len;
        if (shifted < 0) shifted += len;
        return alphabet.charAt(shifted);
    }
}