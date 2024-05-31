import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class z8 {
    public static void main(String[] args) throws IOException {
        Scanner mc = new Scanner(System.in);
        Random rand = new Random();

        File file1 = new File("test8.txt");
        readFile(String.valueOf(file1));
        FileWriter fwr1 = new FileWriter(file1);
        fwr1.write("1-ая Фигура 1) 4>=(x+1)^2+(y+1)^2\tx>=-3 && x<=-1 y>=-1 && y<=3\r\n " +
                "\t\t2) y<=-1.5x+3.5 y>=3x-1 y>=-2x-1\ty>=-1 && y<=5 x>=-1 && x<=1\r\n" +
                "2-ая фигура 1) y>=x-7\tx>=4 &&x<=6\r\n" +
                "\t\t2) 4<=(x-4)^2+(y+1)^2 x>=2 && x<=4 y>=-3 && y<=-1\r\n" +
                "\t\t3) y<=x-3 x>=2 && x<=3 y>=-1 && y<=0\r\n" +
                "\t\t4) y>=-x+3 x>=2 && x<=3 y>=0 && y<=1\r\n" +
                "\t\t4<=(x-4)^2+(y+1)^2 x>=4 && x<=6 y>=-1 && y<=1\r\n\r\n");

        System.out.println("Введите количество точек");
        int n = mc.nextInt();
        Integer[][] mas = new Integer[2][n];
        for (int i = 0; i < n; i++) {
            mas[0][i] = rand.nextInt(-4, 8);
            mas[1][i] = rand.nextInt(-4, 6);
            int cnt = i + 1;
            fwr1.write(cnt + ")\tx)" + mas[0][i] + "\ty)" + mas[1][i] + "\r\n");
        }
        fwr1.write("\r\nВывод\r\n\r\n");
        for (int i = 0; i < n; i++) {
            int pop = FIGURE(mas[0][i], mas[1][i]);
            int cnt = i + 1;
            if (pop == 2) {
                fwr1.write(cnt + ") Точка (" + mas[0][i] + ";" + mas[1][i] + ")\tПопала в область фигуры 2\r\n");
            }
            if (pop == 1) {
                fwr1.write(cnt + ") Точка (" + mas[0][i] + ";" + mas[1][i] + ")\tПопала в область фигуры 1\r\n");
            }
            if (pop == 0) {
                fwr1.write(cnt + ") Точка (" + mas[0][i] + ";" + mas[1][i] + ")\tНе попала в область\r\n");
            }
            if (pop == -1) {
                fwr1.write(cnt + ") Точка (" + mas[0][i] + ";" + mas[1][i] + ")\tПопала на границу фигуры 1\r\n");
            }
            if (pop == -2) {
                fwr1.write(cnt + ") Точка (" + mas[0][i] + ";" + mas[1][i] + ")\tПопала на границу фигуры 2\r\n");
            }
        }
        fwr1.flush();
        fwr1.close();
    }
    public static int FIGURE(int x, int y) {
        if (fig_1(x,y)==1){
            return 1;
        }
        else if (fig_1(x,y)==0) {
            return 0;
        }
        else{
            return -1;
        }
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("Файл не существует");
        }
    }

    public static int fig_1(double x, double y) {
        double v1 = Math.pow(x + 1, 2) + Math.pow(y - 1, 2), v2 = Math.pow(x - 4, 2) + Math.pow(y + 1, 2);
        if  (((x>=-1 & x<=1 & y>=-1 & y<=5 & y<-1.5*x+3.5 & y>3*x-1 & y>-2*x-1)||//1 фигура 1 и 3 треуг
                (y>=-1 & y<=3 & x>=-3 & x<=-1 & y<v1 & y>-v1))){return 1;}//1 фигура 2 полуокр

        else if ((((x>=2 & x<=4 & y>=0 & y<=1 & y>-x+3)||
                (x>2 & x<3 & y<0 & y>-1 & y<x-3)||
                (y>x-7 & x>=4 & x<=6 & y>=-3 & y<=-1)||
                (x>=2 & x<=4 & y>=-3 & y<=-1 & y<-v2)||
                (x>=4 & x<=6 & y>=-1 & y<=1 & y<v2)))){return 2;} //oblast

        else if ((x>=-1 & x<=1 & y>=2 & y<=5 & y==-1.5*x+3.5)||
                (y==3*x-1 & y>=-1 & y<=2 & x>=0 & x<=1)||
                (x>=-1 & x<=0 & y<=1 & y>=-1 & y==-2*x-1)||
                (x==-1 & ((y>=-1 & y<=1)||(y>=3 & y<=5)))||
                (x>=-3 & x<=-1 & y>=-1 & y<=3 & 4==v1)) {return -1;} //phigure

        else if ((x>=2 & x<=4 & y==1)||(x>=2 & x<=4 & y<=-1 & y>=-3 & 4==v2)||
                (x>4 & x<=6 & y<=1 & y>=-1 & 4==v2)||
                (x>=4 & x<=6 & y>=-3 & y<=-1 & y==x-7)||
                (x>=2 & x<=3 & y<=1 & y>=0 & y==-x+3)||
                (x>=2 & x<=3 & y<=0 & y>=-1 & y==x-3)){return -2;}//phigure
        return 0;
    }
}
