import java.util.Scanner;

public class WhileInputDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("輸入整數：");
        int number = scanner.nextInt();

        while (number != 0) {
            System.out.println("Number: " + number);

            System.out.print("輸入整數：");
            number = scanner.nextInt();
        }

        System.out.println("Finish");
        
        scanner.close();
    }
}

