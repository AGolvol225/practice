import java.util.Scanner;

public class SearchForPrimeNumbers {
    public static void main(String[] args){
        System.out.println("Поиск простых чисел:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число N: ");
        int n = scanner.nextInt();
        int primeNum;
        if (n>=2){
            for (int i = 2; i <= n; i++) {
                primeNum = 0;
                for (double j = 1; j < i; j += 1) {
                    if (i % j == 0) {
                        primeNum++;
                    }
                }
                if (primeNum == 1){
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Число меньше 2!");
        }

    }
}
