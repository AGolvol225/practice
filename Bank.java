import java.util.Scanner;

public class Bank {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String num;
        String name;
        double bal = -1;

        System.out.print("Введите номер карты: ");
        num = scanner.nextLine();

        System.out.print("Введите имя: ");
        name = scanner.nextLine();

        while (bal < 0) {
            System.out.print("Введите начальный баланс: ");
            bal = scanner.nextDouble();
            if (bal < 0) {
                throw new RuntimeException("Начальный баланс не может быть отрицательным");
            }
        }
        BankAccount account = new BankAccount(num, name, bal);
        account.operations();
    }
}

class BankAccount{
    private final String accountNumber;
    private final String ownerName;
    private double balance;

    BankAccount(String accountNum, String name, double bal){
        accountNumber = accountNum;
        ownerName = name;
        balance = bal;
    }

    void operations(){
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        int amount;

        System.out.println("Возможные операции:\n1) Внести\n2) Вывести\n3) Посмотерть баланс\n4) Начислени процентов 10%\n5) Выход");
        do {
            operation = scanner.nextLine();
            switch (operation){
                case "1":
                case "Внести":
                    System.out.print("Введите сумму для зачисления на счет: ");
                    amount = scanner.nextInt();
                    deposit(amount);
                    break;
                case "2":
                case "Вывести":
                    System.out.print("Введите сумму для вывода денег: ");
                    amount = scanner.nextInt();
                    withdraw(amount);
                    break;
                case "3":
                case "Посмотерть баланс":
                    System.out.println(getBalance() + "р.");
                    break;
                case "4":
                case "Начислени процентов 10%":
                    System.out.println("При ставке начисления в размере 10% сумма будет равна " + percentages(balance));
                    break;
                case "5":
                case "Выход":
                    System.out.println("Операция по выходу успешно завершена.");
                    break;
                default:
                    System.out.println("Введите число или название операции.");
            }
        } while (!operation.equals("Выход") && !operation.equals("5"));
    }

    void deposit(int amount){
        if (amount < 1) {
            throw new RuntimeException("Сумма транзакции не может быть меньше 0.");
        } else {
            balance += amount;
            System.out.println("Операция прошла успешно.\nПереведена сумма в размере: " + amount + "р.");
        }
    }

    void withdraw(int amount){
        if (amount > balance){
            throw new RuntimeException("Минимально допустимое значение суммы " + balance + "р.");
        } else {
            balance -= amount;
            System.out.println("Операция прошла успешно.\nСо счёта списана сумма в размере " + amount + "р.");
        }
    }

    double getBalance() {
        return balance;
    }

    double percentages(double amount){
        amount += amount * 0.1;
        return amount;
    }
}
