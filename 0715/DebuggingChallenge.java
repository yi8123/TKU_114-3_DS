/*
 ==============================================================================
 1. 錯誤位置：第 34 行 `System.out.println("系統結束，年齡：" + age)`
    - 錯誤類型：編譯錯誤 (compile-time error)
    - 原因：陳述句末尾漏掉了分號 `;`。
    - 修正方式：在該行尾端補上分號。
 
 2. 錯誤位置：第 21 行 `for (int i = 0; i <= scores.length; i++)`
    - 錯誤類型：執行錯誤 (runtime error)
    - 原因：迴圈終止條件寫了 `<= scores.length`。導致陣列發生越界例外。
    - 修正方式：將 `<=` 改為 `<`。
 
 3. 錯誤位置：第 33 行 `if (command == "exit")`
    - 錯誤類型：邏輯錯誤 (logic error)[cite: 1]
    - 原因：錯誤使用 `==` 比較字串，應該使用 `equals()` 來比對字串內容[cite: 1]。
    - 修正方式：改用 `command.equals("exit")`[cite: 1]。
 
 4. 錯誤位置：第 25 行 `double average = total / scores.length;`
    - 錯誤類型：邏輯錯誤 (logic error)[cite: 1]
    - 原因：整數除法會直接捨去小數位，產生不準確的平均值[cite: 1]。
    - 修正方式：將 `total` 強制轉型為 double，寫成 `(double) total / scores.length`[cite: 1]。
 
 5. 錯誤位置：第 30 行 `String command = sc.nextLine();`
    - 錯誤類型：執行錯誤/邏輯錯誤 (Scanner 換行殘留問題)[cite: 1]
    - 原因：`sc.nextInt()` 沒有讀走換行符號，導致後面的 `sc.nextLine()` 直接讀到空字串[cite: 1]。
    - 修正方式：在 `nextInt()` 後面加一行 `sc.nextLine();` 來讀走剩餘換行[cite: 1]。
 ==============================================================================
*/

import java.util.Scanner;

public class DebuggingChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = {80, 75, 92};
        int total = 0;

        // 修正 2：將 <= 改為 <，防止陣列越界 (runtime error)
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        // 修正 4：強制轉型為 double，避免整數除法失去小數點 (logic error)
        double average = (double) total / scores.length;
        System.out.printf("平均：%.2f%n", average);

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();
        
        // 修正 5：讀走剩餘換行，解決下一行過早讀取的問題
        sc.nextLine(); 

        System.out.print("請輸入指令：");
        String command = sc.nextLine();

        // 修正 3：字串比較改用 .equals()
        if (command.equals("exit")) {
            // 修正 1：補上句尾的分號 (compile-time error)
            System.out.println("系統結束，年齡：" + age); 
        }

        sc.close();
    }
}