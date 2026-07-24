import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        inputScores(sc, scores);

        if (scores.size() == 0) {
            System.out.println("\n沒有任何成績資料！");
        } else {
            System.out.println("\n===== 成績統計 =====");
            System.out.println("成績筆數：" + scores.size());
            System.out.printf("平均成績：%.2f\n", calculateAverage(scores));
            System.out.println("最高成績：" + findMax(scores));
            System.out.println("最低成績：" + findMin(scores));

            printPassList(scores);
        }

        sc.close();
    }

    // 輸入成績
    public static void inputScores(Scanner sc, ArrayList<Integer> scores) {

        while (true) {
            System.out.print("請輸入成績(輸入-1結束)：");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤！請輸入整數。");
                sc.next();
                continue;
            }

            int score = sc.nextInt();

            if (score == -1) {
                break;
            }

            if (score < 0 || score > 100) {
                System.out.println("成績必須介於0~100！");
                continue;
            }

            scores.add(score);
        }
    }

    // 計算平均
    public static double calculateAverage(ArrayList<Integer> scores) {

        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        return (double) sum / scores.size();
    }

    // 找最高分
    public static int findMax(ArrayList<Integer> scores) {

        int max = scores.get(0);

        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        return max;
    }

    // 找最低分
    public static int findMin(ArrayList<Integer> scores) {

        int min = scores.get(0);

        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }

        return min;
    }

    // 顯示及格名單
    public static void printPassList(ArrayList<Integer> scores) {

        System.out.println("\n===== 及格名單 =====");

        boolean found = false;

        for (int score : scores) {
            if (score >= 60) {
                System.out.println(score);
                found = true;
            }
        }

        if (!found) {
            System.out.println("沒有及格成績。");
        }
    }
}