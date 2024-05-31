import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class z3
{
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\User\\Desktop\\data.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Z]", ""); // Удаляем все символы, оставляем только буквы
                if (!word.isEmpty() && Character.isUpperCase(word.charAt(word.length() - 1))) {
                    System.out.println(word);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }
    }
}
