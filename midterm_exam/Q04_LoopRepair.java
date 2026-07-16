public class Q04_LoopRepair {
    public static void main(String[] args) {
        System.out.println(sumOddRange(3, 7));
        System.out.println(sumOddRange(7, 3));
        System.out.println(sumOddRange(2, 2));
        System.out.println(sumOddRange(-3, 3));
    }

    public static int sumOddRange(int start, int end) {
        int sum = 0;
        int min = Math.min(start, end);
        int max = Math.max(start, end);
        
        for (int i = min; i <= max; i++) {
            // 判斷是否為奇數（需考慮負奇數：例如 -3 % 2 == -1）
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }
}