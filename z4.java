import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class z4 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("C:\\Users\\User\\Desktop\\data.txt");
            File outputFile = new File("C:\\Users\\User\\Desktop\\data1.txt");
            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[_.,;:\\n\\t!?]", ""); // Удаляем символы-разделители
                if (word.matches("[А-Яа-яA-Za-z&&[^aeiouыэоаеёиюяAEIOU]]+")) {
                    writer.write(word + "\n"); // Записываем слово в другой файл
                }
            }

            scanner.close();
            writer.close();
            System.out.println("Слова записаны в файл.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при работе с файлами.");
            e.printStackTrace();
        }
    }
}