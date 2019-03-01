package pl.jm.advanced_programming.cesar;


public class CesarCipher {

    public static void main(String[] args) {

        System.out.println(encrypt("zuza",2));

    }

    private static StringBuilder encrypt(String wordToEncrypt, int shift) {
//        if (wordToEncrypt.toUpperCase().matches(".*[a-zA-Z].*")) {
            final int normalizationConst = 1;
            int numberOfLetters = 'z' - 'a' + normalizationConst;
            StringBuilder result = new StringBuilder("");
            for (int i = 0; i < wordToEncrypt.length(); i++) {
                char current = wordToEncrypt.charAt(i);
                if (current >= 'a' && current <= 'z') {
                    result.append(
                            (char) (((current + shift -'a') % numberOfLetters) + 'a'));
                } else if (current >= 'A' && current <= 'Z') {
                    result.append(
                            (char) (((current + shift - 'A') % numberOfLetters) + 'A'));

                } else {
                    result.append(current);
                }
            }

            return result;
//        } else throw new IllegalArgumentException("Only alphabet letters here!!!");
    }

    private void decrypt(String word, int shift) {
    }
}
