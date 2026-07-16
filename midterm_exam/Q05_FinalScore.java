public class Q05_FinalScore {
    public static void main(String[] args) {
        System.out.println(calculateFinalScore(80, 90, 5));
        System.out.println(calculateFinalScore(100, 100, 10));
        System.out.println(calculateFinalScore(-1, 80, 5));
        System.out.println(calculateFinalScore(70, 60, 11));
    }

    public static double calculateFinalScore(int examScore, int assignmentScore, int bonus) {
        // 1. 範圍驗證
        if (examScore < 0 || examScore > 100) return -1.0;
        if (assignmentScore < 0 || assignmentScore > 100) return -1.0;
        if (bonus < 0 || bonus > 10) return -1.0;
        
        // 2. 原始成績 = 考試*40% + 作業*60%
        double original = (examScore * 0.4) + (assignmentScore * 0.6);
        
        // 3. 加上加分，最高 100
        double total = original + bonus;
        if (total > 100.0) {
            total = 100.0;
        }
        
        return total;
    }
}