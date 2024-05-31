
import java.io.*;
import java.util.Scanner;

public class z1 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\User\\Desktop\\data.txt");
            Scanner scanner = new Scanner(file);

            StringBuilder data = new StringBuilder();
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
            }

            char[] symbols = data.toString().toCharArray();

            int uppercaseLettersCount = countUppercaseLetters(symbols);
            boolean letterExists = checkLetter(symbols, 'ю');
            boolean multipleCommas = checkMultipleCommas(symbols);
            boolean pairOVExists = checkPairOV(symbols);
            boolean pairDigitsExists = checkPairDigits(symbols);
            boolean conditionExists = checkCondition(symbols);

            FileWriter writer = new FileWriter(file, true);
            writer.write("\nРезультаты обработки массива:\n");
            writer.write("Количество латинских прописных букв: " + uppercaseLettersCount + "\n");
            writer.write("Буква 'ю' " + (letterExists ? "входит" : "не входит") + " в последовательность\n");
            writer.write("Наличие двух и более запятых: " + (multipleCommas ? "Да" : "Нет") + "\n");
            writer.write("Наличие пары соседствующих букв \"во\" или \"ов\": " + (pairOVExists ? "Да" : "Нет") + "\n");
            writer.write("Наличие пары соседствующих одинаковых цифр: " + (pairDigitsExists ? "Да" : "Нет") + "\n");
            writer.write("Существуют ли i и j для условия: " + (conditionExists ? "Да" : "Нет") + "\n");

            writer.close();
            System.out.println("Результаты обработки записаны в файл.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при работе с файлом.");
            e.printStackTrace();
        }
    }

    private static int countUppercaseLetters(char[] symbols) {
        int count = 0;

        for (char symbol : symbols) {
            if (Character.isUpperCase(symbol)) {
                count++;
            }
        }

        return count;
    }

    public static boolean checkLetter(char[] symbols, char letter) {
        for (char symbol : symbols) {
            if (Character.toLowerCase(symbol) == Character.toLowerCase(letter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkMultipleCommas(char[] symbols) {
        int count = 0;
        for (char symbol : symbols) {
            if (symbol == ',') {
                count++;
            }
        }
        return count >= 2;
    }

    public static boolean checkPairOV(char[] symbols) {
        for (int i = 0; i < symbols.length - 1; i++) {
            if ((symbols[i] == 'о' && symbols[i + 1] == 'в') || (symbols[i] == 'в' && symbols[i + 1] == 'о')) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPairDigits(char[] symbols) {
        for (int i = 0; i < symbols.length - 1; i++) {
            if (Character.isDigit(symbols[i]) && symbols[i] == symbols[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkCondition(char[] symbols) {
        for (int i = 0; i < symbols.length - 1; i++) {
            if (Character.isLetter(symbols[i]) && Character.isLetter(symbols[i + 1])) {
                if (Character.toLowerCase(symbols[i]) == Character.toLowerCase(symbols[i + 1]) && (symbols[i] == 'i' || symbols[i] == 'j')) {
                    return true;
                }
            }
        }
        return false;
    }
}

