import java.util.Scanner;

public class JadenSmithString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println((int)'а' + "\n" + (int)'я' + "\n" + (int)'А' + "\n" + (int)'Я');
        System.out.print("Введите строку: ");
        String str = scanner.nextLine();
        System.out.println(JadenString(str));
    }

    private static String JadenString(String str){
        String[] s = str.trim().split("\\s+");
        String[] word;
        String timeLine = new String();
        String finishedWord = new String();
        StringBuilder sb = new StringBuilder();
        char ch;
        int numCh;
        for (int i = 0; i < s.length; i++) {
            timeLine = s[i];
            ch = s[i].charAt(0);
            if (((int)ch > 96 && (int)ch < 123) || ((int)ch > 1071 && (int)ch < 1104)){
                numCh = (int)ch - 32;
                ch = (char) numCh;
                finishedWord = ch + timeLine.substring(1);
                sb.append(finishedWord).append(" ");
            } else {
                sb.append(timeLine).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
