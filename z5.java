import java.io.*;

class Product {
    String type;
    String name;
    int salesAmount;
    double price;
    double expenses;

    public Product(String type, String name, int salesAmount, double price, double expenses) {
        this.type = type;
        this.name = name;
        this.salesAmount = salesAmount;
        this.price = price;
        this.expenses = expenses;
    }
}

public class z5 {
    public static void main(String[] args) {
        double totalProductExpenses = 0;
        double totalServiceExpenses = 0;
        int totalProductCount = 0;
        int totalServiceCount = 0;

        try {
            File inputFile = new File("C:\\Users\\User\\Desktop\\data1.txt");
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");
                String type = data[0];
                String name = data[1];
                int salesAmount = Integer.parseInt(data[2]);
                double price = Double.parseDouble(data[3]);
                double expenses = Double.parseDouble(data[4]);

                Product product = new Product(type, name, salesAmount, price, expenses);

                if (type.equals("Продукт")) {
                    totalProductExpenses += expenses;
                    totalProductCount += salesAmount;
                } else if (type.equals("Услуга")) {
                    totalServiceExpenses += expenses;
                    totalServiceCount += salesAmount;
                }
            }

            bufferedReader.close();

            // Добавляем результаты в конец файла
            FileWriter fileWriter = new FileWriter(inputFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String result = String.format("\nОбщие затраты на продукты: %.2f\nОбщие затраты на услуги: %.2f\n" +
                            "Общее количество приобретенных продуктов: %d\nОбщее количество приобретенных услуг: %d",
                    totalProductExpenses, totalServiceExpenses, totalProductCount, totalServiceCount);

            bufferedWriter.write(result);

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}