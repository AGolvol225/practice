import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigDecimalProj {
    static String[] units = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять",
            "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать",
            "восемнадцать", "девятнадцать"};
    static String[] units12 = {"", "одна", "две"};
    static String[] dozens = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестдесят", "семьдесят",
            "восемьдесят", "девяносто"};
    static String[] hundreds = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
            "восемьсот", "девятьсот"};

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        String stringNum = scanner.nextLine();
        BigDecimal num = new BigDecimal(stringNum);
        BigDecimal number = num.setScale(2, BigDecimal.ROUND_HALF_UP);

        long wholeNumber = number.longValue();
        short fractionalNumber = number.movePointRight(2).remainder(BigDecimal.valueOf(100)).shortValue();
        System.out.println("рублей: " + wholeNumber + "\n" + "копеек: " + fractionalNumber + "\n");

        System.out.println(bigIntNum(wholeNumber) + rubles(wholeNumber) + numStr(fractionalNumber, 1) + kopecks(fractionalNumber));;
    }

    private static String numStr(int num, int thousands){
        int t = num % 100;
        int hundred = num / 100;
        StringBuilder str = new StringBuilder();

        str.append(hundreds[hundred]).append(" ");
        if (thousands == 1 && (t%10 == 1 || t%10 == 2) && t > 19){
            str.append(dozens[t / 10]).append(" ");
            str.append(units12[t % 10]).append(" ");
        } else {
            if (t > 9 && t < 20) {
                str.append(units[t]).append(" ");
            } else {
                str.append(dozens[t / 10]).append(" ");
                str.append(units[t % 10]).append(" ");
            }
        }

        return str.toString().trim();
    }

    private static String bigIntNum(long num) {
        if (num == 0){return "ноль";}

        String[] thousands_056789 = {"", "тысяч", "миллионов", "миллиардов", "триллионов"};
        String[] thousands_1 = {"", "тысяча", "миллион", "миллиард", "триллион"};
        String[] thousands_234 = {"", "тысячи", "миллиона", "миллиарда", "триллиона"};
        List<String> threeNum = new ArrayList<>();
        StringBuilder strB = new StringBuilder();
        String str = new String();
        int n;

        for (int i = 0; num > 0; i++){
            n = (int) (num % 1000);
            num /= 1000;
            strB.append(numStr(n, i)).append(" ");
            int t = n%10;
            if (n%100 < 20 && n%100 > 9){
                strB.append(thousands_056789[i]).append(" ");
            } else {
                switch (t) {
                    case 1:
                        strB.append(thousands_1[i]).append(" ");
                        break;
                    case 2:
                    case 3:
                    case 4:
                        strB.append(thousands_234[i]).append(" ");
                        break;
                    default:
                        strB.append(thousands_056789[i]).append(" ");

                }
            }
            str = strB.toString().trim();
            threeNum.add(0, str);
            strB.setLength(0);
        }
        return String.join(" ", threeNum).trim();
    }

    private static String rubles(long num){
        int t = (int) num%10;
        return switch (t) {
            case 1 -> " рубль ";
            case 2, 3, 4 -> " рубля ";
            default -> " рублей ";
        };
    }

    private static String kopecks(short num){
        int t = (int) num%10;
        switch (t){
            case 1:
                return " копейка";
            case 2:
            case 3:
            case 4:
                return " копейки";
            default:
                if (t == 0 && num < 9){
                    return "ноль копеек";
                } else {
                    return " копеек";
                }
        }
    }
}