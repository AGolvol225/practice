import java.util.Random;

public class ArraysAndStrings {
    public static void main(String[] args){
        System.out.println("Массивы и строки:\n");
        int array[] = new int[10];
        int k = 0;
        Random random = new Random();

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100);
        }

        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++){
            if (max < array[i]){
                max = array[i];
            }
        }
        System.out.println("Максимальный элемент в массиве: " + max);

        for (int i = 0; i < array.length; i++){
            if (min > array[i]){
                min = array[i];
            }
        }
        System.out.println("Минимальный элемент в массиве: " + min);

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]){
                    k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            }
        }

        //System.out.print("Мин равен " + array[0] + ". Макс равен" + array[9] + "\n");

        System.out.print("Отсортированный массив: ");
        for(int n:array){
            System.out.print(n + ", ");
        }
    }
}