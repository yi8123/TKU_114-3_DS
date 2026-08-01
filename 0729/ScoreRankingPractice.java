public class ScoreRankingPractice {
    public static void main(String[] args) {
        double[] scores = {85.5, 92.0, 58.0, 74.0, 92.0, 60.0, 45.0, 74.0};
        
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                double temp = scores[i];
                scores[i] = scores[maxIndex];
                scores[maxIndex] = temp;
            }
        }

        System.out.printf("%-12s%-12s%-12s\n", "名次", "分數", "是否及格");
        System.out.println("------------------------------------");

        int currentRank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && scores[i] != scores[i - 1]) {
                currentRank = i + 1;
            }
            
            String rankString = "第 " + currentRank + " 名";
            String scoreString = String.format("%.1f", scores[i]);
            String status = (scores[i] >= 60.0) ? "及格" : "不及格";
            
            System.out.printf("%-12s%-12s%-12s\n", rankString, scoreString, status);
        }
    }
}