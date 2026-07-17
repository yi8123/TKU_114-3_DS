import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = getValidInput(sc);
        
        // 1. 顯示原始字元數與有效字元數
        System.out.println("原始字元數：" + input.length());
        String trimmed = input.trim();
        System.out.println("有效字元數 (trim 後) : " + trimmed.length());
        
        // 2. 切割單字
        String[] words = splitIntoWords(trimmed);
        System.out.println("單字數量：" + words.length);
        
        // 3. 計算母音數量
        int vowelCount = countVowels(trimmed);
        System.out.println("英文字母母音總數 (a, e, i, o, u)：" + vowelCount);
        
        // 4. 找出最長單字
        String longestWord = findLongestWord(words);
        System.out.println("最長單字：" + longestWord);
        
        // 5. 關鍵字搜尋
        System.out.print("請輸入要搜尋的關鍵字：");
        String keyword = sc.next();
        int keywordCount = countKeyword(words, keyword);
        System.out.println("關鍵字「" + keyword + "」出現次數 (忽略大小寫)：" + keywordCount);
        
        sc.close();
    }

    /**
     * 自訂方法 1：取得有效的非空白輸入
     */
    public static String getValidInput(Scanner sc) {
        String input;
        while (true) {
            System.out.print("請輸入一行非空白文字：");
            input = sc.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                break;
            }
            System.out.println("【錯誤】輸入不可為空字串或全空白，請重新輸入！");
        }
        return input;
    }

    /**
     * 自訂方法 2：使用空白切割單字
     */
    public static String[] splitIntoWords(String text) {
        return text.split("\\s+");
    }

    /**
     * 自訂方法 3：計算母音總數
     */
    public static int countVowels(String text) {
        int count = 0;
        String lowerText = text.toLowerCase();
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    /**
     * 自訂方法 4：尋找最長單字
     */
    public static String findLongestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        String longest = words[0];
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    /**
     * 自訂方法 5：計算關鍵字出現次數
     */
    public static int countKeyword(String[] words, String keyword) {
        int count = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(keyword.trim())) {
                count++;
            }
        }
        return count;
    }
}