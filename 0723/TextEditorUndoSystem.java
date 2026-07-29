import java.util.Stack;

public class TextEditorUndoSystem {
    private StringBuilder currentText = new StringBuilder();
    private Stack<String> history = new Stack<>();

    public void display() {
        System.out.println("當前文本內容: \"" + currentText.toString() + "\"");
    }

    public void append(String str) {
        history.push(currentText.toString());
        currentText.append(str);
        display();
    }

    public void deleteLast(int count) {
        if (count <= 0) return;
        history.push(currentText.toString());
        
        int len = currentText.length();
        if (count > len) {
            currentText.setLength(0);
        } else {
            currentText.delete(len - count, len);
        }
        display();
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("【提示】沒有歷史紀錄，無法進行 Undo！");
            return;
        }
        currentText = new StringBuilder(history.pop());
        display();
    }

    public static void main(String[] args) {
        TextEditorUndoSystem editor = new TextEditorUndoSystem();

        System.out.println("--- 開始文字編輯測試 ---");
        editor.undo();
        
        editor.append("Hello ");
        editor.append("World");
        editor.append("!!!");
        
        editor.deleteLast(3);
        
        System.out.println("\n--- 開始連續進行 3 次以上 Undo 驗證 ---");
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();
    }
}