import java.util.Scanner;

public class PersonalProfileApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = sc.next();

        int age = readPositiveInt(sc, "請輸入年齡：");
        double height = readPositiveDouble(sc, "請輸入身高（公尺）：");
        double weight = readPositiveDouble(sc, "請輸入體重（公斤）：");

        double bmi = calculateBmi(height, weight);
        String level = getBmiLevel(bmi);
        boolean adult = isAdult(age);

        // 輸出完整報表
        printReport(name, age, adult, height, weight, bmi, level);

        sc.close();
    }

    /**
     * 讀取大於 0 的整數，若輸入錯誤或小於等於 0 則要求重新輸入
     */
    public static int readPositiveInt(Scanner sc, String message) {
        int value = 0;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                if (value > 0) {
                    break; 
                } else {
                    System.out.println("【錯誤】數值必須大於 0，請重新輸入。");
                }
            } else {
                System.out.println("【錯誤】請輸入合法的整數。");
                sc.next(); 
            }
        }
        return value;
    }

    /**
     * 讀取大於 0 的浮點數，若輸入錯誤或小於等於 0 則要求重新輸入
     */
    public static double readPositiveDouble(Scanner sc, String message) {
        double value = 0;
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                if (value > 0) {
                    break; 
                } else {
                    System.out.println("【錯誤】數值必須大於 0，請重新輸入。");
                }
            } else {
                System.out.println("【錯誤】請輸入合法的數字。");
                sc.next(); 
            }
        }
        return value;
    }

    /**
     * 計算 BMI 公式：體重 / (身高 * 身高)
     */
    public static double calculateBmi(double height, double weight) {
        return weight / (height * height);
    }

    /**
     * 根據 BMI 值判斷健康分級
     */
    public static String getBmiLevel(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24) {
            return "Normal";
        } else if (bmi < 27) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * 判斷是否滿 18 歲成年
     */
    public static boolean isAdult(int age) {
        return age >= 18;
    }

    /**
     * 印出完整的健康報表
     */
    public static void printReport(String name, int age, boolean adult, double height, double weight, double bmi, String level) {
        System.out.println("\n=== Personal Health Report ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Adult: " + adult);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("BMI: " + bmi);
        System.out.println("Level: " + level);
    }
}