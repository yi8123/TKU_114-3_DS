public class RecursiveDigitCounter {
    public static int countDigit(int number, int target) {
        if (target < 0 || target > 9) {
            throw new IllegalArgumentException("目標數字必須介於 0 到 9 之間");
        }
        
        if (number < 0) {
            number = Math.abs(number);
        }
        
        if (number < 10) {
            return (number == target) ? 1 : 0;
        }
        
        int match = (number % 10 == target) ? 1 : 0;
        return match + countDigit(number / 10, target);
    }

    public static void main(String[] args) {
        System.out.println("--- 課後作業一：遞迴統計數字出現次數 ---");
        System.out.println("1. 1223224 中出現 2 的次數: " + countDigit(1223224, 2));
        System.out.println("2. 55555 中出現 5 的次數: " + countDigit(55555, 5));
        System.out.println("3. 123456 中出現 9 的次數: " + countDigit(123456, 9));
        System.out.println("4. 0 中出現 0 的次數: " + countDigit(0, 0));
        System.out.println("5. 7 中出現 7 的次數: " + countDigit(7, 7));
        System.out.println("6. -2212 中出現 2 的次數: " + countDigit(-2212, 2));
    }
}