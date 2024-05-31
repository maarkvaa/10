
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import static java.lang.Math.*;

public class z7 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("test7.txt");
        FileWriter fwr1 = new FileWriter(file1);
        fwr1.write("Постановка задачи\r\nx >=-3 && x <= 3 x += 0.5\r\nif x >= 0\tf(x) = x*x+cos(2*PI*x)\nif x < 0\tf(x)= -x*x+5\n\n" +
                "Вывод данных \r\n\r\n");
        for (double i=-3.0;i<=3.0;i+=0.5){
            DecimalFormat mm = new DecimalFormat("#.#");
            if (i>=-3.0 && i<0.0){
                double m = sin(i)+cos(i);
                fwr1.write("f("+i+")="+mm.format(m) +"\s\s");
            }
            else {
                double m = sin(i)*cos(i);
                fwr1.write("f("+i+")="+mm.format(m) +"\s\s");
            }
        }
        fwr1.flush();fwr1.close();
    }
}