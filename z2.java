import java.io.FileWriter;
import java.io.IOException;

public class z2 {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\User\\Desktop\\data1.txt");

            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    double sum = i + j;

                    writer.write(i + " + " + j + " = " + sum + "   ");
                }
                writer.write("\n"); // Переход на новую строку после каждой "строки" таблицы
            }

            writer.close();
            System.out.println("Таблица сложения записана в файл.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл.");
            e.printStackTrace();
        }
    }
}