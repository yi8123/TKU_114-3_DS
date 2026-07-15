import java.util.Scanner;

public class ArrayStatistics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = readCount(sc);
        int[] scores = new int[count];

        inputScores(sc, scores);

        System.out.println("\n=== 全部成績 ===");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("第" + (i + 1) + "筆：" + scores[i]);
        }

        int total = calculateTotal(scores);
        double average = (double) total / scores.length;
        int max = findMax(scores);
        int min = findMin(scores);
        int pass = countPass(scores);
        int fail = scores.length - pass;

        System.out.println("\n=== 統計結果 ===");
        System.out.println("總分：" + total);
        System.out.printf("平均：%.2f\n", average);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("及格人數：" + pass);
        System.out.println("不及格人數：" + fail);

        System.out.print("\n請輸入要搜尋的成績：");
        int target = sc.nextInt();

        int index = findIndex(scores, target);

        if (index == -1) {
            System.out.println("找不到此成績。");
        } else {
            System.out.println("第一次出現的索引：" + index);
        }

        sc.close();
    }

    // 輸入資料筆數
    public static int readCount(Scanner sc) {
        int count;

        while (true) {
            System.out.print("請輸入資料筆數（1~50）：");
            count = sc.nextInt();

            if (count >= 1 && count <= 50) {
                return count;
            }

            System.out.println("錯誤！請輸入1~50之間的整數。");
        }
    }

    // 輸入成績
    public static void inputScores(Scanner sc, int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            while (true) {
                System.out.print("請輸入第" + (i + 1) + "筆成績（0~100）：");
                int score = sc.nextInt();

                if (score >= 0 && score <= 100) {
                    scores[i] = score;
                    break;
                }

                System.out.println("錯誤！成績必須介於0~100。");
            }
        }
    }

    // 計算總分
    public static int calculateTotal(int[] scores) {
        int total = 0;

        for (int score : scores) {
            total += score;
        }

        return total;
    }

    // 找最高分
    public static int findMax(int[] scores) {
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        return max;
    }

    // 找最低分
    public static int findMin(int[] scores) {
        int min = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }

        return min;
    }

    // 計算及格人數
    public static int countPass(int[] scores) {
        int count = 0;

        for (int score : scores) {
            if (score >= 60) {
                count++;
            }
        }

        return count;
    }

    // 尋找目標成績第一次出現的索引
    public static int findIndex(int[] scores, int target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                return i;
            }
        }

        return -1;
    }
}