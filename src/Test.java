import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("№ Название Цена мал. и бол.");
        File file = new File("menu.txt");
        Scanner sc = new Scanner(file);
        String[] line = new String[10];
        int c = 0;
        while (sc.hasNextLine()) {
            line[c] = sc.nextLine();
/*            String parts1[] = line[c].split(" ");
            System.out.println(parts1[0] + "\t" + parts1[1]+ "\t" + parts1[2]+ "\t" + parts1[3]);*/
            System.out.println(line[c]);
            c++;
        }
        System.out.println();
        Scanner s = new Scanner(System.in);

        int type = 0;
        while ((type < 1) || (type > c)) {
            System.out.println("Что вы выбрали? (введите номер продукта)");
            type = s.nextInt(); //какой напиток
        }

        int size = 0;
        while ((size < 1) || (size > 2)) {
            System.out.println("Маленький (1) или большой(2))");
            size = s.nextInt(); //размер
        }

        System.out.println("Какую вы хотите обжарку? (светлая(1)/средняя(2)/темная(3))");
        int roasting = s.nextInt(); //обжарка

        int inout = 0;
        while ((inout < 1) || (inout > 2)) {
            System.out.println("Вы выпьете кофе в кофейне (1) или возьмете с собой (2)?");
            inout = s.nextInt(); //с собой или здесь
        }

        String time = "";
        while (Objects.equals(time, "")) {
            System.out.println("На какое время ваш заказ? (hh.mm)");
            //эту часть будет делать такая автоматическая менюшка, где прокурткой время выбирается
            time = s.next(); //время
        }


        System.out.println();
        System.out.print("Итак, вы выбрали ");
        if (size == 1) {
            System.out.print("маленький ");
        } else {
            System.out.print("большой ");
        }
        String parts2[] = line[type].split(" ");
        System.out.print(parts2[1]);
        String roast;
        if (roasting == 1) {
            roast = "светлая обжарка";
        } else {
            if (roasting == 2) {
                roast = "средняя обжарка";
            } else {
                if (roasting == 3) {
                    roast = "темная обжарка";
                } else {
                    roast = "на усмотрение баристы";
                }
            }
        }
        System.out.print("(" + roast + ")");

        System.out.print(", который вы ");
        if (inout == 1) {
            System.out.print("выпьете у нас ");
        } else {
            System.out.print("возьмете с собой ");
        }
        System.out.println("в " + time + ".");

        System.out.print("Сумма вашего заказа: ");
        int price;
        if (size == 1) {
            price = Integer.parseInt(parts2[2]);
        } else {
            price = Integer.parseInt(parts2[3]);
        }
        System.out.println(price + "р.");


        String filename = time + "txt";
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(filename);
            PrintStream ps = new PrintStream(fout);
            ps.println("Время:" + "\t" + time);
            ps.println("Тип:" + "\t" + "\t" + parts2[1]);
            ps.print("Разме" +"р:" + "\t");
            if (size == 1) {
                ps.println("маленький ");
            } else {
                ps.println("большой ");
            }
            ps.println("Обжарка" + "\t" + roast);
            ps.print("Где:" + "\t" + "\t");
            if (inout == 1) {
                ps.println("в кофейне");
            } else {
                ps.println("с собой");
            }
            ps.println("Сумма заказа: " + price + "р.");
            fout.close();
        } catch (IOException e) {
            System.err.println("Error");
            System.exit(-1);
        }
    }
}



