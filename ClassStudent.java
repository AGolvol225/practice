import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassStudent {
    public static void main(String[] args){
        Student student = new Student();
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerDouble = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        System.out.print("Введите имя: ");
        student.setName(scannerStr.nextLine());

        System.out.print("Введите возраст: ");
        student.setAge(scannerInt.nextInt());

        System.out.print("Введите средний балл: ");
        student.setAverageGrade(scannerDouble.nextDouble());


        System.out.print("Введите количество предметов: ");
        int n = scannerInt.nextInt();

        for (int i = 0; i < n; i++){
            System.out.print("Введите " + (i + 1) + " предмет: ");
            student.addSubject(scannerStr.nextLine());
        }

        System.out.println(student.toString());

    }
}

class Student{
    private String name;
    private int age;
    private double averageGrade;
    private List<String> subjects;

    Student(){
        name = null;
        age = 0;
        averageGrade = 0;
        subjects = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void addSubject(String subject){
        subjects.add(subject);
    }

    public boolean isExcellent() {
        return averageGrade>=4.5;
    }

    @Override
    public String toString() {
        return "\nИмя студента: " + name +
                "\nВозраст: " + age +
                "\nСредний балл: " + averageGrade +
                "\nПредметы: " + subjects +
                "\nСтудент отличник? " + isExcellent();
    }
}