import java.util.Scanner;

public class GradeStatistics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int count = 0;
        int total = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int passCount = 0;
        int failCount = 0;

        while (true) {
            System.out.print("請輸入成績（輸入 -1 結束）：");
            
            // 驗證輸入是否為整數
            if (!sc.hasNextInt()) {
                System.out.println("【錯誤】請輸入合法的整數成績。");
                sc.next();
                continue;
            }
            
            int score = sc.nextInt();

            if (score == -1) {
                break;
            }

            // 驗證分數範圍是否合法 (0~100)
            if (!isValidScore(score)) {
                System.out.println("【錯誤】成績範圍必須在 0 到 100 之間，請重新輸入。");
                continue;
            }

            // 統計計算
            count++;
            total += score;
            
            if (score > max) max = score;
            if (score < min) min = score;

            if (isPassing(score)) {
                passCount++;
            } else {
                failCount++;
            }
        }

        if (count == 0) {
            System.out.println("\nNo scores entered.");
        } else {
            
            double average = (double) total / count;
            String grade = getGrade(average);
            
            
            printSummary(count, total, average, max, min, passCount, failCount, grade);
        }

        sc.close();
    }

    /**
     * 檢查分數是否在合法範圍 (0 ~ 100)
     */
    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    /**
     * 判斷是否及格 (60分以上)
     */
    public static boolean isPassing(int score) {
        return score >= 60;
    }

    /**
     * 根據平均分數轉換成等第
     */
    public static String getGrade(double average) {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }

    /**
     * 輸出最終的成績
     */
    public static void printSummary(int count, int total, double average, int max, int min, int passCount, int failCount, String grade) {
        System.out.println("\n=== Grade Summary ===");
        System.out.println("Count: " + count);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Pass count: " + passCount);
        System.out.println("Fail count: " + failCount);
        System.out.println("Average grade: " + grade);
    }
}