
import java.io.*;
import java.util.ArrayList;

public class z9 {
    public static File file1 = new File("test9.txt");
    public static FileWriter fwr;
    static {
        try {
            fwr = new FileWriter(file1,true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader fread= new BufferedReader(new FileReader(file1));
        ArrayList <String> Array=new ArrayList<String>();
        while (fread.ready()){
            Array.add(fread.readLine());
        }
        String [][] masStrok=new String[Array.size()][];
        for (int i=0;i<Array.size();i++){
            String m= String.valueOf(Array.get(i));
            masStrok[i]=m.split(";");
        }
        fwr.write("\r\n\r\nВывод ответа\r\n\r\n");
        find_information(masStrok);
        fwr.flush();fwr.close();
    }
    public static void find_information(String[][] schools) throws IOException { //Метод, который ищет нужные данные об издательствах


        int countKandidates=0, countBudszhet=0, k;
        String STR;
        for (int i = 0; i < schools.length; i++) {
            if (!schools[i][0].equals("")) {
                k = 1;
                STR = schools[i][0];
                for (int j = i + 1; j < schools.length; j++) {
                    if (STR.equals(schools[j][0])) {
                        if (Integer.parseInt(schools[i][4]) >= 5 && Integer.parseInt(schools[i][5]) >= 1 &&
                                Integer.parseInt(schools[i][7]) >= 500) {
                            countKandidates++;
                        }
                        schools[j][0] = "";
                        k++;
                    }
                }
                schools[i][0] = "";
                fwr.write(STR + "\t" + k + "\n");
            }
            if (Integer.parseInt(schools[i][11]) >= 1 && Integer.parseInt(schools[i][13]) >= 1
                    && Integer.parseInt(schools[i][14]) >= 10000000) {
                countBudszhet++;
            }
        }
        fwr.write("Количество школ по районам в которых есть не менее 5 кандидатов наук и 1 доктора наук с численностью обучающихся более 500 человек = " + countKandidates + "\n");
        fwr.write("Количество школ, в которых есть хотя бы один компьютерный класс и один спортивный зал с общей стоимостью оборудования школы более 10 млн. руб. = " + countBudszhet);
    }
}
