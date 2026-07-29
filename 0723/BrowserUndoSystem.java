import java.util.Stack;

public class BrowserUndoSystem {
    private Stack<String> history = new Stack<>();
    private String currentPage = null;

    public void visit(String url) {
        if (currentPage != null) {
            history.push(currentPage);
        }
        currentPage = url;
        System.out.println("瀏覽頁面: " + currentPage);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("【提示】沒有上一頁可以返回！");
            return;
        }
        currentPage = history.pop();
        System.out.println("返回成功，目前頁面: " + currentPage);
    }

    public void showCurrent() {
        if (currentPage == null) {
            System.out.println("目前沒有瀏覽任何網頁。");
        } else {
            System.out.println("目前停留網頁: " + currentPage);
        }
    }

    public static void main(String[] args) {
        BrowserUndoSystem browser = new BrowserUndoSystem();
        
        System.out.println("--- 開始進行 8 次以上操作測試 ---");
        browser.back();
        browser.visit("google.com");
        browser.visit("github.com");
        browser.showCurrent();
        browser.visit("stackoverflow.com");
        browser.back();
        browser.back();
        browser.visit("medium.com");
        browser.showCurrent();
        browser.back();
        browser.back();
    }
}