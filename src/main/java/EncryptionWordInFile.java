import java.io.*;

public class EncryptionWordInFile {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStreamWord = new FileInputStream("src/main/resources/Word.txt");

        FileReader fileReader = new FileReader("src/main/resources/Text.txt");
        BufferedReader readerText = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter("src/main/resources/TextWithWord.txt");
        BufferedWriter writerText = new BufferedWriter(fileWriter);

        StringBuilder text = new StringBuilder();
        String line = readerText.readLine();
        text.append(line);
        while (line != null) {
            line = readerText.readLine();
            if (line != null) {
                text.append("\n" + line);
            }
        }
        readerText.close();

        byte[] bytes = inputStreamWord.readAllBytes();
        StringBuilder bits = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            bits.append(String.format("%8s", Integer.toBinaryString(bytes[i]))
                    .replace(" ", "0"));
        }

        char[] charsBits = bits.toString().toCharArray();
        char[] charsText = text.toString().toCharArray();
        int pos = 0;
        for (int i = 0; i < charsBits.length; i++) {
            for (int j = pos; j < charsText.length; j++) {
                if (charsText[j] == 'e') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'е';
                    }
                    break;
                }
                if (charsText[j] == 'E') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'Е';
                    }
                    break;
                }
                if (charsText[j] == 'T') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'Т';
                    }
                    break;
                }
                if (charsText[j] == 'y') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'у';
                    }
                    break;
                }
                if (charsText[j] == 'o') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'о';
                    }
                    break;
                }
                if (charsText[j] == 'O') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'О';
                    }
                    break;
                }
                if (charsText[j] == 'p') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'р';
                    }
                    break;
                }
                if (charsText[j] == 'P') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'Р';
                    }
                    break;
                }
                if (charsText[j] == 'a') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'а';
                    }
                    break;
                }
                if (charsText[j] == 'A') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'А';
                    }
                    break;
                }
                if (charsText[j] == 'H') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'Н';
                    }
                    break;
                }
                if (charsText[j] == 'K') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'К';
                    }
                    break;
                }
                if (charsText[j] == 'x') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'х';
                    }
                    break;
                }
                if (charsText[j] == 'X') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'Х';
                    }
                    break;
                }
                if (charsText[j] == 'c') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'с';
                    }
                    break;
                }
                if (charsText[j] == 'C') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'с';
                    }
                    break;
                }
                if (charsText[j] == 'B') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'В';
                    }
                    break;
                }
                if (charsText[j] == 'M') {
                    pos = j + 1;
                    if (charsBits[i] == '1') {
                        charsText[j] = 'М';
                    }
                    break;
                }
            }
        }

        writerText.write(charsText);
        writerText.close();
    }
}