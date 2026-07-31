public class RecursiveDigitSumPractice {
    public static int digitSum(int number) {
        if (number < 0) {
            number = Math.abs(number);
        }
        if (number < 10) {
            return number;
        }
        return (number % 10) + digitSum(number / 10);
    }

    public static void main(String[] args) {
        int[] testCases = {5729, 0, 7, 12345, 9999};
        
        System.out.println("--- 課堂實作一：遞迴計算各位數總和測試 ---");
        for (int num : testCases) {
            System.out.println("輸入: " + num + " -> 各位數總和: " + digitSum(num));
        }
    }
}