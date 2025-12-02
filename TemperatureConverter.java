import java.sql.SQLOutput;
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Scanner scannerScale = new Scanner(System.in);

        System.out.println("Конвертер температур:");

        System.out.print("Введите число: ");
        double num = scanner.nextDouble();

        System.out.print("Введите тип шкалы (C, F, K): ");
        String scale = scannerScale.nextLine();

        switch (scale){
            case "C":
                System.out.println("По шкале Фаренгейта: " + (num * 9/5 + 32));
                System.out.println("По шкале Кельвина: " + (num + 273.15));
                break;
            case "F":
                System.out.println("По шкале Цельсия: " + (num - 32) * 5/9);
                System.out.println("По шкале Кельвина: " + (((num - 32) * 5/9) + 273.15));
                break;
            case "K":
                System.out.println("По шкале Цельсия: " + (num - 273.15));
                System.out.print("По шкале Фаренгейта: " + ((num - 273.15) * 9/5 + 32));
                break;
        }
    }
}
