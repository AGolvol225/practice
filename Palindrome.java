public class Palindrome {
    public static void isPalindrome(String str) {

        String cleaned = str.toLowerCase().replace(" ", "");
        int n = 0;
        int length = cleaned.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(length - 1 - i)) {
                n = 1;
                break;
            } else{
                n = 2;
            }
        }
        if (n == 1){
            System.out.println("Это не полиндром.");
        } else {
            System.out.println("Это полиндром.");
        }
    }

    public static void main(String[] args){
        System.out.println("Палиндром: \n");
        isPalindrome("А роза упала на лапу Азора");

    }


}
