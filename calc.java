import java.util.Scanner;

public class calc {
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);
        Scanner oper = new Scanner(System.in);
        System.out.println("Калькулятор");

        System.out.print("Введите первое число: ");
        double first = scanner.nextDouble();

        System.out.print("Введите первое число: ");
        double second = scanner.nextDouble();

        System.out.print("Введите операцию (+, -, *, /): ");
        String operation = oper.nextLine();

        switch (operation){
            case "+":
                System.out.println(first+second);
                break;
            case "-":
                System.out.println(first-second);
                break;
            case "*":
                System.out.println(first*second);
                break;
            case "/":
                if (second != 0){
                    System.out.println(first/second);
                } else {
                    System.out.println("Деление на 0 невозможно!");
                }
                break;
        }
    }
}
