public class ContestRankingSystem {
    public static void main(String[] args) {
        Contestant[] contestants = {
            new Contestant("C01", "張三", 95, 45),
            new Contestant("C02", "李四", 88, 50),
            new Contestant("C03", "王五", 95, 40), // 與張三同分但秒數少，應排前面
            new Contestant("C04", "趙六", 75, 60),
            new Contestant("C05", "孫七", 88, 42), // 與李四同分但秒數少，應排前面
            new Contestant("C06", "周八", 95, 45)  // 與張三同分同秒
        };

        // 使用自訂 Insertion Sort 進行多條件降冪/升冪排序
        int n = contestants.length;
        for (int i = 1; i < n; i++) {
            Contestant key = contestants[i];
            int j = i - 1;
            
            while (j >= 0) {
                boolean shouldMove = false;
                // 條件 1: 分數低者向右移 (分數高者排前面)
                if (contestants[j].getScore() < key.getScore()) {
                    shouldMove = true;
                } 
                // 條件 2: 分數相同時，完成秒數多者向右移 (秒數少者排前面)
                else if (contestants[j].getScore() == key.getScore()) {
                    if (contestants[j].getSeconds() > key.getSeconds()) {
                        shouldMove = true;
                    }
                }
                
                if (shouldMove) {
                    contestants[j + 1] = contestants[j];
                    j--;
                } else {
                    break;
                }
            }
            contestants[j + 1] = key;
        }

        // 顯示排名結果 (考量同分同秒同名次情況)
        System.out.println("=== 參賽者最終排名結果 ===");
        int currentRank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (contestants[i].getScore() != contestants[i - 1].getScore() || 
                          contestants[i].getSeconds() != contestants[i - 1].getSeconds())) {
                currentRank = i + 1;
            }
            System.out.printf("名次 %d | %s\n", currentRank, contestants[i]);
        }
    }
}