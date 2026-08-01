public class TransactionSortingSystem {
    public static void main(String[] args) {
        // 準備測試資料，包含相同金額以測試第二權重排序（時間序號升冪）
        Transaction[] txs = {
            new Transaction("T01", "Alice", 5000.0, 1),
            new Transaction("T02", "Bob", 1200.0, 2),
            new Transaction("T03", "Charlie", 5000.0, 3), // 金額同 T01，時間較晚
            new Transaction("T04", "David", 8500.0, 4),
            new Transaction("T05", "Emma", 5000.0, 2),   // 金額同 T01，時間介於中間
            new Transaction("T06", "Fred", 1200.0, 1)    // 金額同 T02，時間較早
        };

        System.out.println("=== 排序前 ===");
        for (Transaction t : txs) {
            System.out.println(t);
        }

        // 使用自訂 Insertion Sort 進行完整欄位多條件排序
        int n = txs.length;
        for (int i = 1; i < n; i++) {
            Transaction key = txs[i];
            int j = i - 1;

            while (j >= 0) {
                boolean shouldShift = false;
                
                // 條件 1: 金額較小者向右移 (金額降冪排序)
                if (txs[j].getAmount() < key.getAmount()) {
                    shouldShift = true;
                } 
                // 條件 2: 金額相同時，時間序號較大者向右移 (時間序號升冪排序)
                else if (txs[j].getAmount() == key.getAmount()) {
                    if (txs[j].getTimeSeq() > key.getTimeSeq()) {
                        shouldShift = true;
                    }
                }

                if (shouldShift) {
                    txs[j + 1] = txs[j];
                    j--;
                } else {
                    break;
                }
            }
            txs[j + 1] = key;
        }

        System.out.println("\n=== 排序後 (依金額降冪，同金額者依時間序號升冪) ===");
        for (Transaction t : txs) {
            System.out.println(t);
        }
    }
}