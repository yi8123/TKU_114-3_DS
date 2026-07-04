import java.util.Scanner;

public class GreetingInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 輸入姓名
        System.out.print("請輸入姓名：");
        String name = sc.nextLine();

        // 輸入年齡
        System.out.print("請輸入年齡：");
        int age = sc.nextInt();

        // 輸出結果
        System.out.println("Hello, " + name + ". You are " + age + " years old.");

        sc.close();
    }
}