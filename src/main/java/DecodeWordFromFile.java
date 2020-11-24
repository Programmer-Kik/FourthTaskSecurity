import java.io.BufferedReader;
import java.io.FileReader;

public class DecodeWordFromFile {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("src/main/resources/TextWithWord.txt");
        BufferedReader readerTextWithWord = new BufferedReader(fileReader);

        StringBuilder textWithWord = new StringBuilder();
        String line = readerTextWithWord.readLine();
        textWithWord.append(line);
        while (line != null) {
            line = readerTextWithWord.readLine();
            if (line != null) {
                textWithWord.append("\n" + line);
            }
        }
        readerTextWithWord.close();

        StringBuilder stringBits = new StringBuilder();
        char[] textWithWordChars = textWithWord.toString().toCharArray();
        for (int i = 0, j = 0; i < textWithWordChars.length && (j < 8 || stringBits.length() % 8 != 0); i++) {
            if (textWithWordChars[i] == 'у' || textWithWordChars[i] == 'К' ||
                    textWithWordChars[i] == 'е' || textWithWordChars[i] == 'Е' ||
                    textWithWordChars[i] == 'Н' || textWithWordChars[i] == 'х' ||
                    textWithWordChars[i] == 'Х' || textWithWordChars[i] == 'В' ||
                    textWithWordChars[i] == 'а' || textWithWordChars[i] == 'А' ||
                    textWithWordChars[i] == 'р' || textWithWordChars[i] == 'Р' ||
                    textWithWordChars[i] == 'о' || textWithWordChars[i] == 'О' ||
                    textWithWordChars[i] == 'с' || textWithWordChars[i] == 'С' ||
                    textWithWordChars[i] == 'М' || textWithWordChars[i] == 'Т') {
                stringBits.append("1");
                j = 0;
            }
            if (textWithWordChars[i] == 'e' || textWithWordChars[i] == 'E' ||
                    textWithWordChars[i] == 'T' || textWithWordChars[i] == 'y' ||
                    textWithWordChars[i] == 'o' || textWithWordChars[i] == 'O' ||
                    textWithWordChars[i] == 'p' || textWithWordChars[i] == 'P' ||
                    textWithWordChars[i] == 'a' || textWithWordChars[i] == 'A' ||
                    textWithWordChars[i] == 'H' || textWithWordChars[i] == 'K' ||
                    textWithWordChars[i] == 'x' || textWithWordChars[i] == 'X' ||
                    textWithWordChars[i] == 'c' || textWithWordChars[i] == 'C' ||
                    textWithWordChars[i] == 'B' || textWithWordChars[i] == 'M') {
                stringBits.append(0);
                j++;
            }
        }

        char[] bits = stringBits.delete(stringBits.length() - 8, stringBits.length())
                .toString()
                .toCharArray();

        byte[] bytes = new byte[bits.length / 8];
        int byteFromBits = 0;
        for (int i = 0, degree = 7; i < bits.length; i++) {
            byteFromBits += Math.pow(2, degree) * Character.getNumericValue(bits[i]);

            if (degree == 0) {
                degree = 7;
                bytes[i / 8] = (byte)byteFromBits;
                byteFromBits = 0;
            }
            else {
                degree--;
            }
        }

        String word = new String(bytes);
        System.out.println(word);
    }
}